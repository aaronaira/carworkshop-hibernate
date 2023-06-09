package org.carworkshop.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class VehiculoDto {

    private Integer id;
    private String matricula;
    private String marca;
    private String modelo;
    private int v_year;
    private int cliente;
    private int tipo_vehiculo;
    private String bastidor;


}
