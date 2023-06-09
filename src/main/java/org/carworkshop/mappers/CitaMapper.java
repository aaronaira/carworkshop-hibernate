package org.carworkshop.mappers;


import org.carworkshop.dtos.CitaDto;
import org.carworkshop.entities.Cita;

public class CitaMapper {
    public static CitaDto parse(Cita cita) {
        return new CitaDto(cita.getId(),
                cita.getFechaHora(),
                VehiculoMapper.parse(cita.getIdVehiculo()),
                cita.getIdDiagnostico());
    }
}
