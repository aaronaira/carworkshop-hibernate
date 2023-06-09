package org.carworkshop.dtos;

import org.carworkshop.classes.Persona;
import org.carworkshop.entities.Login;

import java.util.List;

public class ClienteDto extends Persona {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private Login login;
    private List<VehiculoDto> vehiculos;


    public ClienteDto(int id, String nombre, String apellidos, String dni, String direccion, Login login, List<VehiculoDto> vehiculos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.login = login;
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
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
        return login.getEmail();

    }

    public void setLogin(Login login) {this.login = login;}

    public Login getLogin() {return login;}

    public List<VehiculoDto> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoDto> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
