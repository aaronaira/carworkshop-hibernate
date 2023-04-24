package org.carworkshop.dtos;

import org.carworkshop.entities.Empleado;

public class EmpleadoDto {

    private int id;
    private String nombre;
    private String dni;
    private String puesto;
    private String departamento;

    public EmpleadoDto(Empleado empleado) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.puesto= puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
