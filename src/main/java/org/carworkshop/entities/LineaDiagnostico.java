package org.carworkshop.entities;

import jakarta.persistence.*;


/**
 * The persistent class for the linea_diagnostico database table.
 * 
 */
@Entity
@Table(name="linea_diagnostico")
@NamedQuery(name="LineaDiagnostico.findAll", query="SELECT l FROM LineaDiagnostico l")
public class LineaDiagnostico  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LineaDiagnosticoPK id;

	@Column(nullable=false)
	private float cantidad;

	@Column(nullable=false, length=50)
	private String descripcion;

	@Column(name="id_tipo_iva", nullable=false)
	private int idTipoIva;

	//bi-directional many-to-one association to CabeceraDiagnostico
	@ManyToOne
	@JoinColumn(name="id_diagnostico", nullable=false, insertable=false, updatable=false)
	private CabeceraDiagnostico cabeceraDiagnostico;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="codigo_operario", nullable=false)
	private Empleado empleado;

	public LineaDiagnostico() {
	}

	public LineaDiagnosticoPK getId() {
		return this.id;
	}

	public void setId(LineaDiagnosticoPK id) {
		this.id = id;
	}

	public float getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipoIva() {
		return this.idTipoIva;
	}

	public void setIdTipoIva(int idTipoIva) {
		this.idTipoIva = idTipoIva;
	}

	public CabeceraDiagnostico getCabeceraDiagnostico() {
		return this.cabeceraDiagnostico;
	}

	public void setCabeceraDiagnostico(CabeceraDiagnostico cabeceraDiagnostico) {
		this.cabeceraDiagnostico = cabeceraDiagnostico;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}