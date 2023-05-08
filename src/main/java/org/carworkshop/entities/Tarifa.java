package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tarifa")

public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "seccion", nullable = false, length = 50)
    private String seccion;

    //@OneToOne (fetch = FetchType.LAZY, optional = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "tipo_vehiculo", nullable = false)
    private Integer tipoVehiculo;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @OneToMany(mappedBy = "tarifa")
    private Set<ManoobraOt> manoobraOts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Integer getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

}