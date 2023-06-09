package org.carworkshop.controllers;

import org.carworkshop.daos.ClienteDao;
import org.carworkshop.daos.VehiculoDao;
import org.carworkshop.dtos.ClienteDto;
import org.carworkshop.dtos.VehiculoDto;
import org.carworkshop.entities.Cliente;
import org.carworkshop.entities.Vehiculo;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
        } else {
            request.getServletContext().setAttribute("coche", "El coche ya existe en nuestra base de datos.");
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
        ClienteDao clienteDao = new ClienteDao();

        Vehiculo vehiculo = new Vehiculo();
        ClienteDto clienteDto = (ClienteDto) request.getServletContext().getAttribute("cliente");

        Optional<Cliente> cliente = clienteDao.get(clienteDto.getId());

        vehiculo.setTipoVehiculo(Integer.valueOf(carFields.get("tipo_vehiculo")));
        vehiculo.setBastidor(carFields.get("bastidor"));
        vehiculo.setCliente(cliente.get());
        vehiculo.setMarca(carFields.get("marca"));
        vehiculo.setMatricula(carFields.get("matricula"));
        vehiculo.setModelo(carFields.get("modelo"));
        vehiculo.setVYear(Integer.valueOf(carFields.get("vyear")));


        vehiculoDao.save(vehiculo);

    }

    public static List<VehiculoDto> parseToVehiculoDto(List<Vehiculo> vehiculos) {

        return vehiculos.stream().map(vehiculo ->
                new VehiculoDto(vehiculo.getId(), vehiculo.getMatricula(), vehiculo.getMarca(),
                        vehiculo.getModelo(), vehiculo.getVYear(), vehiculo.getCliente().getId(),
                        vehiculo.getTipoVehiculo(), vehiculo.getBastidor())).toList();
    }

}
