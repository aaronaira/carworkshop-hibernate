package org.carworkshop.entities;


import jakarta.persistence.*;
import java.io.Serializable;

/**
 * The primary key class for the linea_diagnostico database table.
 * 
 */
@Embeddable
public class LineaDiagnosticoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_diagnostico", insertable=false, updatable=false, unique=true, nullable=false)
	private int idDiagnostico;

	@Column(name="n_linea", unique=true, nullable=false)
	private int nLinea;

	public LineaDiagnosticoPK(int idDiagnostico, int nLinea) {
		this.idDiagnostico = idDiagnostico;
		this.nLinea = nLinea;
	}
	public int getIdDiagnostico() {
		return this.idDiagnostico;
	}
	public void setIdDiagnostico(int idDiagnostico) {
		this.idDiagnostico = idDiagnostico;
	}
	public int getNLinea() {
		return this.nLinea;
	}
	public void setNLinea(int nLinea) {
		this.nLinea = nLinea;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LineaDiagnosticoPK)) {
			return false;
		}
		LineaDiagnosticoPK castOther = (LineaDiagnosticoPK)other;
		return 
			(this.idDiagnostico == castOther.idDiagnostico)
			&& (this.nLinea == castOther.nLinea);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDiagnostico;
		hash = hash * prime + this.nLinea;
		
		return hash;
	}
}