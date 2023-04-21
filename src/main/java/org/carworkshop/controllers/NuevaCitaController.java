package org.carworkshop.controllers;

import org.carworkshop.daos.CitaDao;
import org.carworkshop.daos.ClienteDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.dtos.VehiculoDto;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Vehiculo;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NuevaCitaController {
    private static final List<String> getAllCitas = new ArrayList<>();
    private static final Map<LocalDate, List<String>> mapDaysHours = new LinkedHashMap<>();

    private static final String calendarForm = """
                    <div class="calendar">
                        <ul>
                            %s
                        </ul>
                    </div>     
            """;

    public static String getAllVehiculos(HttpServletRequest request) {
        ClienteDto clienteDto = (ClienteDto) request.getServletContext().getAttribute("cliente");
        ClienteDao clienteDao = new ClienteDao();

        Optional<Cliente> cliente = clienteDao.get(clienteDto.getId());

        List<VehiculoDto> allVehiculos = parseToVehiculoDto(cliente.get().getVehiculos());

        return parseDataVehiculosToHtmlForm(allVehiculos);

    }

    public static String makeCalendar() {
        return calendarForm.replace("%s", getCalendar());
    }

    public static String getCalendar() {

        return getAllAvaliableDates().entrySet().stream().map((item) -> {
            return "<li>" + item.getKey().getDayOfMonth() + "</li>";
        }).collect(Collectors.joining());
    }

    public static Map<LocalDate, List<String>> getAllAvaliableDates() {
        List<LocalTime> horasLibres = new ArrayList<>();
        getDatesFromDB();

        for(LocalDateTime date: generateDatesAndHours()) {
            String nextDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Timestamp.valueOf(date));
            String getHour = new SimpleDateFormat("H").format(Timestamp.valueOf(date));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            if( Integer.parseInt(getHour) < 20 && Integer.parseInt(getHour) >= 8) {
                if(!getAllCitas.contains(nextDate)) {

                    LocalDate proposalDay = Timestamp.valueOf(nextDate).toLocalDateTime().toLocalDate();
                    String proposalTime = Timestamp.valueOf(nextDate).toLocalDateTime().toLocalTime().format(formatter);

                    if(!mapDaysHours.containsKey(proposalDay)) mapDaysHours.put(proposalDay, new ArrayList<String>());

                    if(!mapDaysHours.get(proposalDay).contains(proposalTime)) {
                        mapDaysHours.get(proposalDay).add(proposalTime);

                    }

                }
            }
        }
        return mapDaysHours;
    }

    private static void getDatesFromDB() {
        CitaDao citaDao = new CitaDao();
        List<Cita> AllCitas = citaDao.getAll();

        AllCitas.stream()
                .map(cita -> getAllCitas.add(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cita.getFechaHora())));
    }
    private static Boolean queryFrom(TemporalAccessor temporal) {
        return temporal.get(ChronoField.DAY_OF_WEEK) >= 5;
    }
    private static List<LocalDateTime> generateDatesAndHours() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMonths(2).with(TemporalAdjusters.lastDayOfMonth());


        return Stream.iterate(start, date -> date.plusMinutes(45))
                .limit(ChronoUnit.HOURS.between(start, end))
                .filter(date -> !date.getDayOfWeek().name().equals("SATURDAY") || !date.getDayOfWeek().name().equals("MONDAY"))
                .toList();
    }

    private static String parseDataVehiculosToHtmlForm(List<VehiculoDto> vehiculos) {
        return vehiculos.stream().map((vehiculo) -> {
            boolean isSelected = vehiculo.getId().equals(1);
            String selected = isSelected ? "selected" : "";

            return "<option " + selected + " value="+ vehiculo.getId() +">"
                    + vehiculo.getMarca() + " "
                    + vehiculo.getModelo() + " "
                    + vehiculo.getMatricula() + " "
                    + vehiculo.getBastidor()
                    +"</option>";
        }).collect(Collectors.joining());
    }

    private static List<VehiculoDto> parseToVehiculoDto(List<Vehiculo> vehiculos) {

        return vehiculos.stream().map(vehiculo ->
                new VehiculoDto(vehiculo.getId(), vehiculo.getMatricula(), vehiculo.getMarca(),
                        vehiculo.getModelo(), vehiculo.getVYear(), vehiculo.getCliente().getId(),
                        vehiculo.getTipoVehiculo(), vehiculo.getBastidor())).toList();
    }
}
