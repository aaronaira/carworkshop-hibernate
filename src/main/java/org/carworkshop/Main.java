package org.carworkshop;

import org.carworkshop.controllers.NuevaCitaController;
import org.carworkshop.daos.CitaDao;
import org.carworkshop.entities.Cita;

import java.sql.Time;
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
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
//        ClienteDao clienteDao = new ClienteDao();
//        LoginDao loginDao = new LoginDao();

//        Cliente cliente = new Cliente();
//        Login login = new Login();
//
//        login.setPassword("asdasd");
//        login.setEmail("aaron00@gmail.com");
//        login.setCliente(cliente);
//
//
//        cliente.setApellidos("aasd");
//        cliente.setNombre("aaron");
//        cliente.setDireccion("calle 2");
//        cliente.setDni("123213123A");
//        cliente.setEmail(login);
//        loginDao.save(login);
//        Login loginBorrar = loginDao.get(login.getId());
//        loginDao.delete(loginBorrar);

        //Login login = loginDao.get("email56@email.com");
//
//        System.out.println(login.getCliente().getDni());
//
        //login.setEmail("email56@email.com");
//
//
//        loginDao.update(login);
//
//        Optional<Cliente> cliente = clienteDao.get(37);
//
//        //System.out.println(login.getId());
//        CabeceraDiagnosticoDao cabeceraDiagnosticoDao = new CabeceraDiagnosticoDao();
//        Optional<CabeceraDiagnostico> cabeceraDiagnostico = cabeceraDiagnosticoDao.get(1);
//        VehiculoDao vehiculoDao = new VehiculoDao();
//
//        Optional<Vehiculo> vehiculo = vehiculoDao.get(1);
//        CitaDao citaDao = new CitaDao();
//
//        Cita cita = new Cita();
//        Date dateJava = new Date();
//        Timestamp sqlFecha = new Timestamp(dateJava.getTime());
//        cita.setFechaHora(sqlFecha);
//        cita.setIdCliente(cliente.get());
//        cita.setIdVehiculo(vehiculo.get());
//        cita.setIdDiagnostico(cabeceraDiagnostico.get());
//        citaDao.save(cita);
//
//        System.out.println(citaDao.get(1).get().getIdDiagnostico().getIdVehiculo());

//
//        LocalDateTime start = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).truncatedTo(ChronoUnit.MINUTES);
//        LocalDateTime end = start.plusMonths(2).with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.of(20, 0));
//
//        List<LocalDateTime> dates = Stream.iterate(start, date -> date.plusMinutes(45))
//                .filter(date_ -> date_.isBefore(end))
//                .limit(ChronoUnit.HOURS.between(start, end))
//                .toList();
//
//        List<LocalDateTime> dates_ = new ArrayList<>();
//
//        for(LocalDateTime date_s = start; date_s.isBefore(end); date_s = date_s.plusMinutes(45)) {
//            dates_.add(date_s);
//        }
//        AtomicInteger index = new AtomicInteger();
//
//        for (int i = 0; i < 10 ; i++) {
//            System.out.println(index.incrementAndGet());
//        }
        //System.out.println(NuevaCitaController.makeCalendar());

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String date = "2023-04-26 16:48";
//
//        System.out.println(LocalDateTime.parse(date, formatter));
        System.out.println(NuevaCitaController.getCalendar());
// new Timestamp(new Date().getTime())
//        CitaDao citaDao = new CitaDao();
//        List<String> citas = citaDao.getAll().stream()
//                .map(cita -> new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cita.getFechaHora())).toList();
//
//
//        List<String> horasLibres = new ArrayList<>();
//
//        for(LocalDateTime date: dates) {
//            String nextDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Timestamp.valueOf(date));
//            String getHour = new SimpleDateFormat("H").format(Timestamp.valueOf(date));
//
//            if( Integer.parseInt(getHour) < 20 && Integer.parseInt(getHour) > 8) {
//                if(!citas.contains(nextDate)) horasLibres.add(nextDate);
//            }
//        }





//        for (int i = 1; i < day; i++) {
//            System.out.printf("%-4s", "");
//        }
//
//        for(int i = day; i <= today; i++) {
//            System.out.printf("%-4d", i);
//        }


    }

}
