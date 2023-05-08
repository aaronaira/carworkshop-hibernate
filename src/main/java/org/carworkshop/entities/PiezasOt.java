package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "piezas_ot", schema = "carworkshop", indexes = {
        @Index(name = "id_pieza", columnList = "id_pieza")

})
public class PiezasOt {
    @EmbeddedId
    private PiezasOtPK id;

    @MapsId("idOt")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_ot", nullable = true)
    private OtCabecera idOt;

    @MapsId("idPieza")
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_pieza", nullable = true)
    private Pieza idPieza;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public PiezasOtPK getId() {
        return id;
    }

    public void setId(PiezasOtPK id) {
        this.id = id;
    }

    public OtCabecera getIdOt() {
        return idOt;
    }

    public void setIdOt(OtCabecera idOt) {
        this.idOt = idOt;
    }

    public Pieza getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Pieza idPieza) {
        this.idPieza = idPieza;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}