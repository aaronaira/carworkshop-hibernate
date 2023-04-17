package org.carworkshop.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cabecera_diagnostico")
public class CabeceraDiagnostico {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;

    @OneToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo idVehiculo;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

//    @Override
//    public String toString() {
//        return "CabeceraDiagnostico{" +
//                "id=" + id + '\'' +
//                "fechaHora=" + fechaHora + '\'' +
//                "idVehiculo=" + idVehiculo + '\'' +
//                '}';
//    }
}
