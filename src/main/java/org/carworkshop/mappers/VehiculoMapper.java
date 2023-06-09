package org.carworkshop.mappers;

import org.carworkshop.dtos.VehiculoDto;
import org.carworkshop.entities.Vehiculo;

public class VehiculoMapper {

    public static VehiculoDto parse(Vehiculo vehiculo) {
        return new VehiculoDto(vehiculo.getId(), vehiculo.getMatricula(),
                vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getVYear(),
                vehiculo.getCliente().getId(), vehiculo.getTipoVehiculo(),
                vehiculo.getBastidor());
    }
}
