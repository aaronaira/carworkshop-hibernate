package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "manoobra_ot")
@NamedQuery(name="ManoobraOt.findAll", query="SELECT l FROM ManoobraOt l")
public class ManoobraOt {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ot", nullable = false)
    private OtCabecera idOt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tarifa", nullable = false)
    private Tarifa tarifa;

    @Column(name = "operacion", nullable = false, length = 50)
    private String operacion;

    @Column(name = "ts_inicio", nullable = false)
    private Date tsInicio;

    @Column(name = "ts_fin")
    private Date tsFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OtCabecera getIdOt () {
        return idOt;
    }

    public void  setIdOt(OtCabecera otCabecera) {
        this.idOt = otCabecera;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Date getTsInicio() {
        return tsInicio;
    }

    public void setTsInicio(Date tsInicio) {
        this.tsInicio = tsInicio;
    }

    public Date getTsFin() {
        return tsFin;
    }

    public void setTsFin(Date tsFin) {
        this.tsFin = tsFin;
    }

}