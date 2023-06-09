package org.carworkshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.carworkshop.entities.CabeceraDiagnostico;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor

public class CitaDto {
    int id;
    LocalDateTime fecha;
    VehiculoDto vehiculo;
    CabeceraDiagnostico diagnostico;

}
