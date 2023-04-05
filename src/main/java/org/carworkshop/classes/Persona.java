package org.carworkshop.classes;

import org.carworkshop.entities.Login;

public abstract class Persona {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String email;

    protected Persona() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;

        if (!getDni().equals(persona.getDni())) return false;
        return getEmail().equals(persona.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getDni().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}

