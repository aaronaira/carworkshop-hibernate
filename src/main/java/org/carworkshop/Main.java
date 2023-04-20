package org.carworkshop;

import org.carworkshop.daos.CitaDao;
import org.carworkshop.entities.Cita;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
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


        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

        List<LocalDateTime> dates = Stream.iterate(start, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .toList();

        CitaDao citaDao = new CitaDao();
        List<String> citas = citaDao.getAll().stream().map(cita -> new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cita.getFechaHora())).toList();


        List<String> horasLibres = new ArrayList<>();

        for(LocalDateTime date: dates) {
            String nextDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Timestamp.valueOf(date));

            if(!citas.contains(nextDate)) horasLibres.add(nextDate);

        }


//        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(timestamp));



//        for (int i = 1; i < day; i++) {
//            System.out.printf("%-4s", "");
//        }
//
//        for(int i = day; i <= today; i++) {
//            System.out.printf("%-4d", i);
//        }


    }

}
