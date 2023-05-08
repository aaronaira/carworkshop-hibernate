package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@ToString
@Entity
@Table(name = "ot_totales", schema = "carworkshop")
public class OtTotales {
    @Id
    @Column(name = "id_ot", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_ot", nullable = false)
    private OtCabecera otCabecera;

    @Column(name = "total_piezas")
    private Integer totalPiezas;

    @Column(name = "total_manoobra", nullable = false)
    private Integer totalManoobra;

    @Column(name = "total_tiempo", nullable = false)
    private Float totalTiempo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OtCabecera getOtCabecera() {
        return otCabecera;
    }

    public void setOtCabecera(OtCabecera otCabecera) {
        this.otCabecera = otCabecera;
    }

    public Integer getTotalPiezas() {
        return totalPiezas;
    }

    public void setTotalPiezas(Integer totalPiezas) {
        this.totalPiezas = totalPiezas;
    }

    public Integer getTotalManoobra() {
        return totalManoobra;
    }

    public void setTotalManoobra(Integer totalManoobra) {
        this.totalManoobra = totalManoobra;
    }

    public Float getTotalTiempo() {
        return totalTiempo;
    }

    public void setTotalTiempo(Float totalTiempo) {
        this.totalTiempo = totalTiempo;
    }

}