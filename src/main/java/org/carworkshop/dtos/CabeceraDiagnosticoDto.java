package org.carworkshop.dtos;

import org.carworkshop.dtos.VehiculoDto;

import java.util.Date;

public class CabeceraDiagnosticoDto {

    private Integer id;
    private Date fechaHora;
    private VehiculoDto vehiculo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public VehiculoDto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDto vehiculo) {
        this.vehiculo = vehiculo;
    }
}

