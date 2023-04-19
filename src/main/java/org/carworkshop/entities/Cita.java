package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
@Table(name = "cita")
public class Cita {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;

    @OneToOne
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo idVehiculo;

    @OneToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

    @OneToOne
    @JoinColumn(name = "id_diagnostico", nullable = false)
    private CabeceraDiagnostico cabeceraDiagnostico;

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

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdDiagnostico(CabeceraDiagnostico cabeceraDiagnostico) {
        this.cabeceraDiagnostico = cabeceraDiagnostico;
    }

    public CabeceraDiagnostico getIdDiagnostico() {
        return cabeceraDiagnostico;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id + '\'' +
                "fechaHora=" + fechaHora + '\'' +
                "idVehiculo=" + idVehiculo + '\'' +
                "idCliente=" + idCliente + '\'' +
                "idDiagnostico=" + cabeceraDiagnostico + '\'' +
                '}';
    }
}
