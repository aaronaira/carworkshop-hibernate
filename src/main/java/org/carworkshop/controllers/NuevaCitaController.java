package org.carworkshop.controllers;

import org.carworkshop.daos.CitaDao;
import org.carworkshop.daos.ClienteDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.dtos.VehiculoDto;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Vehiculo;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NuevaCitaController {

    public static String getAllVehiculos(HttpServletRequest request) {
        ClienteDto clienteDto = (ClienteDto) request.getServletContext().getAttribute("cliente");
        ClienteDao clienteDao = new ClienteDao();

        Optional<Cliente> cliente = clienteDao.get(clienteDto.getId());

        List<VehiculoDto> allVehiculos = parseToVehiculoDto(cliente.get().getVehiculos());

        return parseDataVehiculosToHtmlForm(allVehiculos);

    }

    public static String getCalendar() {

    return null;
    }

    private static List<String> getAllAvaliableDates() {
        List<String> horasLibres = new ArrayList<>();

        for(LocalDateTime date: generateDatesAndHours()) {
            String nextDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Timestamp.valueOf(date));
            String getHour = new SimpleDateFormat("H").format(Timestamp.valueOf(date));

            if( Integer.parseInt(getHour) < 20 && Integer.parseInt(getHour) > 8) {
                if(!getDatesFromDB().contains(nextDate)) horasLibres.add(nextDate);
            }
        }

        return horasLibres;
    }

    private static List<String> getDatesFromDB() {
        CitaDao citaDao = new CitaDao();
        return citaDao.getAll().stream()
                .map(cita -> new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cita.getFechaHora())).toList();
    }

    private static List<LocalDateTime> generateDatesAndHours() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

        return Stream.iterate(start, date -> date.plusMinutes(45))
                .limit(ChronoUnit.DAYS.between(start, end))
                .toList();
    }

    private static String parseDataVehiculosToHtmlForm(List<VehiculoDto> vehiculos) {
        return vehiculos.stream().map(vehiculo -> {
            //   <option value="coche1">coche1</option>

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
