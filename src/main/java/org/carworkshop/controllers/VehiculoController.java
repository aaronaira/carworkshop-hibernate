package org.carworkshop.controllers;

import org.carworkshop.daos.VehiculoDao;
import org.carworkshop.entities.Vehiculo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehiculoController {


    public static boolean checkVehiculoFields(HttpServletRequest request) {
        String matricula = request.getParameter("matricula");
        Map<String, String> carFields = new HashMap<>();

        if(!checkIfCarExists(matricula)) {
            request.getParameterMap().forEach((key, value) -> {
                carFields.put(key, value[0]);
            });

            registerVehiculo(carFields, request);
            return true;
        }
        return false;


    }

    private static boolean checkIfCarExists(String matricula) {

        VehiculoDao vehiculoDao = new VehiculoDao();
        Optional<Vehiculo> vehiculo = vehiculoDao.get(matricula);

        return vehiculo.isPresent();
    }

    private static void registerVehiculo(Map<String, String> carFields, HttpServletRequest request) {
        VehiculoDao vehiculoDao = new VehiculoDao();
        Vehiculo vehiculo = new Vehiculo();

        Optional<Vehiculo> vehiculo1 = vehiculoDao.get(carFields.get("matricula"));

        vehiculo.setTipoVehiculo(Integer.valueOf(carFields.get("tipo_vehiculo")));
        vehiculo.setBastidor(carFields.get("bastidor"));
        vehiculo.setCliente(vehiculo1.get().getCliente());
        vehiculo.setMarca(carFields.get("marca"));
        vehiculo.setMatricula(carFields.get("matricula"));
        vehiculo.setModelo(carFields.get("modelo"));
        vehiculo.setVYear(Integer.valueOf(carFields.get("vyear")));

        vehiculoDao.save(vehiculo);

    }

}
