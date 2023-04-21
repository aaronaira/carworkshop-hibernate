package org.carworkshop.controllers;

import org.carworkshop.classes.*;
import org.carworkshop.daos.*;
import org.carworkshop.dtos.*;
import org.carworkshop.entities.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

public class RecepcionController {



    private static List<String> getAllMatriculasCitas() {
        List<String> allMatriculasCitas = new ArrayList<>();
        CitaDao citaDao = new CitaDao();
        List<Cita> listaCitas = citaDao.getAll();

        for ( Cita cita : listaCitas ) {
            allMatriculasCitas.add(cita.getIdVehiculo().getMatricula());
        }
        return allMatriculasCitas;
    }

    public static boolean checkIfCarExists() {
        String matricula = "";
        matricula = LeerMatricula.leerMatricula();
        List <String> matriculascita = getAllMatriculasCitas();
        return matriculascita.contains(matricula);
    }


    public static Optional<Vehiculo> getVehiculoCita() {

        VehiculoDao vehiculoDao = new VehiculoDao();

        return vehiculoDao.get(LeerMatricula.leerMatricula());
    }


    public static Optional<Cita> getCitaMatricula() {

        CitaDao citaDao = new CitaDao();

        return citaDao.get(getVehiculoCita().get());
    }

    public static Optional<Empleado> getEmpleadoRecepcion() {

        EmpleadoDao empleadoDao = new EmpleadoDao();
        List <Empleado> listaempleados = empleadoDao.getAll();
        Empleado empleadorecepcion = new Empleado();



        for (Empleado empleado : listaempleados) {

           String recepcion = empleado.getDepartamento();



           if (recepcion == "Recepcion") {

               System.out.println(empleado.getNombre());
           } else {
               System.out.println(empleado.getNombre());
               return null;
           }

        }


        return Optional.of(empleadorecepcion);
    }

    public static void registerRecepcion() {

        if (checkIfCarExists()) {
            RecepcionDao recepcionDao = new RecepcionDao();
            Recepcion recepcion = new Recepcion();

            recepcion.setFoto(LeerMatricula.leerMatricula());
            recepcion.setFechaHora(LocalDateTime.now());
            recepcion.setIdVehiculo(getVehiculoCita().get());
         //   recepcion.setIdEmpleadoRecepcion();
            recepcion.setIdDiagnosticoInicial(getCitaMatricula().get().getIdDiagnostico());
            recepcion.setIdDiagnosticoRecepcion(null);




        }

    }
}
