package org.carworkshop.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 50)
    private String dni;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "email", nullable = false, referencedColumnName = "email")
    private Login email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos = new ArrayList<>();


    public List<Vehiculo> getVehiculos() {
        return vehiculos;
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

    public Login getEmail() {
        return email;
    }

    public void setEmail(Login email) {
        this.email = email;
    }


//    @Override
//    public String toString() {
//        return "{id:" + id + ",nombre:" + nombre +", apellidos:" + apellidos\" + \"dni:" + dni + ",direccion:"+ direccion +"}";
//    }

}