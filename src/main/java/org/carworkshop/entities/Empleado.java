package org.carworkshop.entities;

import jakarta.persistence.*;

import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@Table(name="empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado  {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=50)
	private String departamento;

	@Column(nullable=false, length=50)
	private String dni;

	@Column(nullable=false, length=50)
	private String nombre;

	@Column(nullable=false, length=50)
	private String puesto;

	//bi-directional many-to-one association to LineaDiagnostico
	@OneToMany(mappedBy="empleado")
	private List<LineaDiagnostico> lineaDiagnosticos;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public List<LineaDiagnostico> getLineaDiagnosticos() {
		return this.lineaDiagnosticos;
	}

	public void setLineaDiagnosticos(List<LineaDiagnostico> lineaDiagnosticos) {
		this.lineaDiagnosticos = lineaDiagnosticos;
	}

	public LineaDiagnostico addLineaDiagnostico(LineaDiagnostico lineaDiagnostico) {
		getLineaDiagnosticos().add(lineaDiagnostico);
		lineaDiagnostico.setEmpleado(this);

		return lineaDiagnostico;
	}

	public LineaDiagnostico removeLineaDiagnostico(LineaDiagnostico lineaDiagnostico) {
		getLineaDiagnosticos().remove(lineaDiagnostico);
		lineaDiagnostico.setEmpleado(null);

		return lineaDiagnostico;
	}

}