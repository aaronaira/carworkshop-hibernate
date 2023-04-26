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
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NuevaCitaController {
    private static final List<String> getAllCitas = new ArrayList<>();
    private static final Map<LocalDate, List<String>> mapDaysHours = new LinkedHashMap<>();

    private static final String calendarForm = """
                    <div class="calendar">
                    <h2> %f </h2>
                        <ul>
                        <li>LUN</li>
                        <li>MAR</li>
                        <li>MIE</li>
                        <li>JUE</li>
                        <li>VIE</li>
                        <li>SAB</li>
                        <li>DOM</li>
                            %s
                        </ul>
                    </div>
            """;



    public static String makeCalendar(HttpServletRequest request) {
       request.getServletContext().setAttribute("fechas", mapDaysHours);

        return getCalendar().entrySet().stream().map(item -> {
           return calendarForm.replace("%f", item.getKey()).replace("%s", String.join("", item.getValue()));
       }).collect(Collectors.joining());

    }

    public static Map<String, List<String>> getCalendar() {
        LinkedHashMap<String, List<String>> calendarFormatedHours = new LinkedHashMap<>();

        for(Map.Entry<LocalDate, List<String>> item: getAllAvaliableDates().entrySet()) {
            String evaluateDayOfMonth =
                    item.getKey().getDayOfWeek().name().equals("SATURDAY")
                    || item.getKey().getDayOfWeek().name().equals("SUNDAY")
                  || item.getKey().isBefore(LocalDate.now())
                    //|| LocalDate.now().isAfter(ChronoLocalDate.from(item.getKey().atStartOfDay().toLocalDate()))
                    ? "<li class='cross-day'>" + item.getKey().getDayOfMonth() + "</li>"
                    : String.format("<li><a href='/panel/reservacita?fecha=%s'>" + item.getKey().getDayOfMonth() + "</a></li>", String.valueOf(item.getKey()));

            String firstYearOfMonth = item.getKey().getDayOfMonth() == 1
                    ? ("<li class='first-day' style='width: calc(14% * %f );'><a href='/panel/reservacita?fecha=%s&vehiculo=%b'>"+ item.getKey().getDayOfMonth() + "</a></li>")
                    .replaceAll("%f", String.valueOf(item.getKey().getDayOfWeek().getValue()))
                    .replaceAll("%s", String.valueOf(item.getKey()))
                    //.replaceAll("%b", vehiculo)
                    : null;


            String checkDate = firstYearOfMonth != null ? firstYearOfMonth : evaluateDayOfMonth;

            if (!calendarFormatedHours.containsKey(item.getKey().getMonth().name()))
                calendarFormatedHours.put(item.getKey().getMonth().name(), new ArrayList<>());

            if(!calendarFormatedHours.get(item.getKey().getMonth().name()).contains(checkDate))
                calendarFormatedHours.get(item.getKey().getMonth().name()).add(checkDate);

        }

        return  calendarFormatedHours;
    }

    public static Map<LocalDate, List<String>> getAllAvaliableDates() {
        getDatesFromDB();

        for(LocalDateTime date: generateDatesAndHours()) {
            String nextDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Timestamp.valueOf(date));
            String getHour = new SimpleDateFormat("H").format(Timestamp.valueOf(date));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            if( Integer.parseInt(getHour) < 20 && Integer.parseInt(getHour) >= 8) {
                if(!getAllCitas.contains(nextDate)) {

                    LocalDate proposalDay = Timestamp.valueOf(nextDate).toLocalDateTime().toLocalDate();
                    String proposalTime = Timestamp.valueOf(nextDate).toLocalDateTime().toLocalTime().format(formatter);

                    if(!LocalDate.now().minusMonths(1).getMonth().name().equals(proposalDay.getMonth().name())) {
                        if (!mapDaysHours.containsKey(proposalDay)) mapDaysHours.put(proposalDay, new ArrayList<>());

                        if(!mapDaysHours.get(proposalDay).contains(proposalTime)) {
                            mapDaysHours.get(proposalDay).add(proposalTime);
                        }
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

    private static List<LocalDateTime> generateDatesAndHours() {
        LocalDateTime start = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).with(DayOfWeek.MONDAY);
        LocalDateTime end = LocalDateTime.now().plusMonths(3).with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.of(20, 0));

        List<LocalDateTime> dates = new ArrayList<>();

        for(LocalDateTime date_s = start; date_s.isBefore(end); date_s = date_s.plusMinutes(45)) {
            dates.add(date_s);
        }

        return dates;
    }




}
