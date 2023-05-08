package org.carworkshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * The primary key class for the linea_diagnostico database table.
 *
 */
@Embeddable
public class PiezasOtPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="id_ot", unique=true)
    private int idOt;

    @Column(name="id_pieza", unique=true)
    private int idPieza;

    public PiezasOtPK() {
    }

    public int getidOt() {
        return this.idOt;
    }
    public void setidOt(int idOt) {
        this.idOt = idOt;
    }
    public int getidPieza() {
        return this.idPieza;
    }
    public void setidPieza(int idPieza) {
        this.idPieza = idPieza;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PiezasOtPK)) {
            return false;
        }
        PiezasOtPK castOther = (PiezasOtPK)other;
        return
                (this.idOt == castOther.idOt)
                        && (this.idPieza == castOther.idPieza);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.idOt;
        hash = hash * prime + this.idPieza;

        return hash;
    }
}
