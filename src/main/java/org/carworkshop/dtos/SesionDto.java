package org.carworkshop.dtos;


import java.time.Instant;
import java.util.Date;

public class SesionDto {
    private Integer id;
    private Date dtIniciosesion;
    private Date dtFinsesion;
    private Integer idCliente;

    public SesionDto(int id, Instant dtIniciosesion, Instant dtFinsesion, Integer idCliente) {
        this.id = id;
        this.dtIniciosesion = Date.from(dtIniciosesion);
        this.dtFinsesion = Date.from(dtFinsesion);
        this.idCliente = idCliente;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtIniciosesion() {
        return dtIniciosesion;
    }

    public void setDtIniciosesion(Date dtIniciosesion) {
        this.dtIniciosesion = dtIniciosesion;
    }

    public Date getDtFinsesion() {
        return dtFinsesion;
    }

    public void setDtFinsesion(Date dtFinsesion) {
        this.dtFinsesion = dtFinsesion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
