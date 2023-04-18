package org.carworkshop;

import org.carworkshop.daos.*;
import org.carworkshop.entities.Cita;

import java.util.*;

import static org.carworkshop.classes.Calendario.formatDate;
import static org.carworkshop.classes.Calendario.showCalendar;

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
//        loginDao.update(login);

//        Optional<Cliente> cliente = clienteDao.get(37);
//
//        //System.out.println(login.getId());
//        CabeceraDiagnosticoDao cabeceraDiagnosticoDao = new CabeceraDiagnosticoDao();
//        Optional<CabeceraDiagnostico> cabeceraDiagnostico = cabeceraDiagnosticoDao.get(1);
//        VehiculoDao vehiculoDao = new VehiculoDao();
//
//        Optional<Vehiculo> vehiculo = vehiculoDao.get(1);
        CitaDao citaDao = new CitaDao();
//
        //Cita cita = new Cita();
//        Date dateJava = new Date();
//        Timestamp sqlFecha = new Timestamp(dateJava.getTime());
//        cita.setFechaHora(sqlFecha);
//        cita.setIdCliente(cliente.get());
//        cita.setIdVehiculo(vehiculo.get());
//        cita.setIdDiagnostico(cabeceraDiagnostico.get());
//        citaDao.save(cita);
//




/* Displaying Current Date using
             Calendar Class */


        // Creating an object of Calendar Class
        Calendar cal = Calendar.getInstance();

        /* Creating an object of
             GregorianCalendar Class */
        GregorianCalendar gcal = new GregorianCalendar();

        /* Displaying Current Date using
             Calendar Class */
        System.out.println("Calendar date: "
                + (gcal.getTime()));

        /* Displaying Current Date using
             GregorianCalendar Class */
        System.out.print("Gregorian date: "
                + gcal.getTime());
        System.out.println();
        System.out.println(formatDate(citaDao.get(1).get().getFechaHora()));
        System.out.println(formatDate(gcal.getTime()));
        System.out.println(formatDate(gcal.getTime()) + " Fecha actual");
        for (Cita cita:citaDao.getAll()) {
            System.out.println(formatDate(cita.getFechaHora()));
            if (formatDate(cita.getFechaHora()).equals(formatDate(gcal.getTime()))) {


                System.out.println("Hay citas concedidas en la fecha " + formatDate(gcal.getTime()));

            }

        }


    }




}



