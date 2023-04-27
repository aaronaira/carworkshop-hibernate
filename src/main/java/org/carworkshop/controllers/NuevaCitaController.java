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
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;

public class NuevaCitaController{


    private static final List<LocalDateTime> getAllCitas = new ArrayList<>();
    private static final Map<LocalDate, List<LocalTime>> mapDaysHours = new LinkedHashMap<>();


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
            return calendarForm.replace("%f", englishMonthToSpanish(item.getKey())).replace("%s", String.join("", item.getValue()));
        }).collect(Collectors.joining());
    }

    public static Map<String, List<String>> getCalendar() {
        LinkedHashMap<String, List<String>> calendarFormatedDays = new LinkedHashMap<>();

        for (Map.Entry<LocalDate, List<LocalTime>> item : getAllAvaliableDates().entrySet()) {

            if (!calendarFormatedDays.containsKey(item.getKey().getMonth().name()))
                calendarFormatedDays.put(item.getKey().getMonth().name(), new ArrayList<>());

            if(!calendarFormatedDays.get(item.getKey().getMonth().name()).contains(isFirstDayAndWeekend(item.getKey())))
                calendarFormatedDays.get(item.getKey().getMonth().name()).add(isFirstDayAndWeekend(item.getKey()));
        }

            return calendarFormatedDays;

        }

    public static Map<LocalDate, List<LocalTime>> getAllAvaliableDates() {
        getDatesFromDB();
        DateTimeFormatter hoursFormatter = DateTimeFormatter.ofPattern("HH:mm");
        mapDaysHours.clear();

        for(LocalDateTime date: generateDatesAndHours()) {

            if( date.getHour() < 20 && date.getHour() >= 8 && date.getHour() > LocalDateTime.now().getHour()) {
                if(!getAllCitas.contains(date)) {

                    LocalDate proposalDay = date.toLocalDate();
                    LocalTime proposalTime = LocalTime.parse(date.toLocalTime().format(hoursFormatter));

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

        AllCitas.forEach(cita -> getAllCitas.add(cita.getFechaHora().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().truncatedTo(ChronoUnit.MINUTES)));
    }

    private static List<LocalDateTime> generateDatesAndHours() {
        LocalDateTime start = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).with(DayOfWeek.MONDAY).with(LocalTime.of(8, 0)).truncatedTo(ChronoUnit.MINUTES);
        LocalDateTime end = LocalDateTime.now().plusMonths(2).with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.of(20, 0));


        List<LocalDateTime> dates = new ArrayList<>();

        for(LocalDateTime date_s = start; date_s.isBefore(end); date_s = date_s.plusMinutes(45)) {
            dates.add(date_s);
        }

        return dates;
    }


    public static String isFirstDayAndWeekend(LocalDate day) {

        if (day.getDayOfMonth() == 1 && day.getDayOfWeek().name().equals("SATURDAY")
                || day.getDayOfMonth() == 1 && day.getDayOfWeek().name().equals("SUNDAY")) {

            return ("<li class='first-day cross-day' style = 'width : calc(14% * %dayofweek)'>"
                    + day.getDayOfMonth() + "</li>").replace("%dayofweek", String.valueOf(day.getDayOfWeek().getValue()));

        } else if (day.getDayOfWeek().name().equals("SATURDAY")
                || day.getDayOfWeek().name().equals("SUNDAY")) {

            return "<li class='cross-day'>" + day.getDayOfMonth() + "</li>";

        } else if (day.getDayOfMonth() == 1) {

            return ("<li class='first-day' style = 'width : calc(14% * %dayofweek)'><a href=/panel/reservacita?fecha="
                    + day +">"+ day.getDayOfMonth() + "</a></li>")
                    .replace("%dayofweek", String.valueOf(day.getDayOfWeek().getValue()));

        } else if (day.isBefore(LocalDate.now())) {

            return "<li class='cross-day'>" + day.getDayOfMonth() + "</li>";

        }
        return "<li><a href=/panel/reservacita?fecha=" + day +">"+ day.getDayOfMonth() + "</a></li>";
    }

    public static String  englishMonthToSpanish(String month) {

    LinkedHashMap<String, String> months = new LinkedHashMap<String, String>();

    months.put("JANUARY", "ENERO");
    months.put("FEBRUARY", "FEBRERO");
    months.put("MARCH", "MARZO");
    months.put("APRIL", "ABRIL");
    months.put("MAY", "MAYO");
    months.put("JUNE", "JUNIO");
    months.put("JULY", "JULIO");
    months.put("AUGUST", "AGOSTO");
    months.put("SEPTEMBER", "SEPTIEMBRE");
    months.put("OCTOBER", "OCTUBRE");
    months.put("NOVEMBER", "NOVIEMBRE");
    months.put("DECEMBER", "DICIEMBRE");

    return months.get(month);

}

}
