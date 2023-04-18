package org.carworkshop;

import org.carworkshop.daos.CitaDao;
import org.carworkshop.entities.Cita;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
        showCalendar(2023,4,1);

        System.out.println();

        System.out.println(formatDate(gcal.getTime()) + " Fecha actual");

        System.out.println();

        String fecha = "2009-11-11 13";;

        for (Cita cita:citaDao.getAll()) {

            System.out.println(formatDate(cita.getFechaHora()));

            if (formatDate(cita.getFechaHora()).equals(gcal.getTime())) {

                System.out.println("Hay citas concedidas en la fecha " + fecha);

            } else {



            }

        }

        System.out.println();
        System.out.println("No hay citas concedidas en la fecha ");


    }




}



