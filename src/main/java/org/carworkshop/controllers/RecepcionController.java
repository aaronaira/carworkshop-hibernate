package org.carworkshop.controllers;

import org.carworkshop.classes.LeerMatricula;
import org.carworkshop.daos.CitaDao;
import org.carworkshop.daos.EmpleadoDao;
import org.carworkshop.daos.RecepcionDao;
import org.carworkshop.daos.VehiculoDao;
import org.carworkshop.entities.Cita;
import org.carworkshop.entities.Empleado;
import org.carworkshop.entities.Recepcion;
import org.carworkshop.entities.Vehiculo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RecepcionController {


    //RECOGE TODAS LAS MATRICULAS EN UN ARRAY DE STRINGS QUE TIENEN CITAS
    private static List<String> getAllMatriculasCitas() {
        List<String> allMatriculasCitas = new ArrayList<>();
        CitaDao citaDao = new CitaDao();
        List<Cita> listaCitas = citaDao.getAll();

        for ( Cita cita : listaCitas ) {
            allMatriculasCitas.add(cita.getIdVehiculo().getMatricula());
        }
        return allMatriculasCitas;
    }

    //COMPRUEBA QUE LA MATRICULA DE LA FOTO SE ENCUENTRA ENTRE LAS MASTRICULAS DE LOS COCHES CON CITAS, DEVUELVE UN TRUE PARA SEGUIR CON LA CREACION DE LA RECEPCION
    public static boolean checkIfCarExists(String matricula) {
        List <String> matriculascita = getAllMatriculasCitas();
        return matriculascita.contains(matricula);
    }

    //RECOGE TODAS LAS HORAS DE LAS CITAS Y COMPRUEBA SI EN LA HORA ACTUAL HAY ALGUNA CITA, DEVUELVE TRUE PARA SEGUIR CON LA CREACION DE LA RECEPCION
    public static boolean checkIfCitaExists() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        CitaDao citaDao = new CitaDao();
        List<Cita> listaCitas = citaDao.getAll();
        List<String> listaHorasCitas = new ArrayList<>();
        //CONVERSION A STRING
        String horaactual = LocalDateTime.now()
                .format(formatter)
                .toString()
                .substring(0, 13);
        //RECORRER ARRAY DE CITAS
        for (Cita cita : listaCitas) {
            String horacita = cita.getFechaHora()
                    .toString()
                    .substring(0, 13);
            //AÑADIR LAS FECHAS EN STRING A UN ARRAY DE STRINGS
            listaHorasCitas.add(horacita);
        }
        return listaHorasCitas.contains(horaactual);
    }

    //RECOGE EL VEHICULO DE LA CITA SEGUN LA MATRICULA DE LA FOTO Y LO DEVUELVE
    public static Optional<Vehiculo> getVehiculoCita(String matricula) {
        VehiculoDao vehiculoDao = new VehiculoDao();

        return vehiculoDao.get(matricula);
    }

    //RECOGE LA CITA DE LA MATRICULA DE LA FOTO Y LA DEVUELVE
    public static Optional<Cita> getCitaMatricula(String matricula) {
        CitaDao citaDao = new CitaDao();
        return citaDao.get(getVehiculoCita(matricula).get());
    }

    //RECOGE EL EMPLEADO DE RECEPCION, COMO ESTA PLANTEADO SOLO DEBE DE HABER UN EMPLEADO EN RECEPCION EN TODA LA BASE DE DATOS
    public static Optional<Empleado> getEmpleadoRecepcion() {
        EmpleadoDao empleadoDao = new EmpleadoDao();
        List <Empleado> listaempleados = empleadoDao.getAll();

        for (Empleado empleado : listaempleados) {

           if (empleado.getDepartamento().equals("Recepcion")) {
               return Optional.of(empleado);
           }
        }

        return Optional.ofNullable(null);
    }


    //REGISTRA LA RECEPCION DEL VEHICULO
    public static void registerRecepcion() {
        String matricula = "";
        matricula = LeerMatricula.leerMatricula();

        if (checkIfCarExists(matricula) || checkIfCitaExists()) {

            RecepcionDao recepcionDao = new RecepcionDao();
            Recepcion recepcion = new Recepcion();

            recepcion.setFoto(matricula);
            recepcion.setFechaHora(new Timestamp(new Date().getTime()));
            recepcion.setIdVehiculo(getVehiculoCita(matricula).get());
            recepcion.setIdEmpleadoRecepcion(getEmpleadoRecepcion().get());
            recepcion.setIdDiagnosticoInicial(getCitaMatricula(matricula).get().getIdDiagnostico());
            recepcion.setIdDiagnosticoRecepcion(getCitaMatricula(matricula).get().getIdDiagnostico());

            recepcionDao.save(recepcion);


        }

    }
}
