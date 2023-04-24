package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "recepcion", schema = "carworkshop", indexes = {
        @Index(name = "id_empleado_recepcion", columnList = "id_empleado_recepcion"),
        @Index(name = "id_diagnostico_inicial", columnList = "id_diagnostico_inicial"),
        @Index(name = "id_vehiculo", columnList = "id_vehiculo"),
        @Index(name = "id_diagnostico_recepcion", columnList = "id_diagnostico_recepcion")
})
public class Recepcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "foto", nullable = false, length = 50)
    private String foto;

    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo idVehiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_empleado_recepcion", nullable = false)
    private Empleado idEmpleadoRecepcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_diagnostico_inicial", nullable = false)
    private CabeceraDiagnostico idDiagnosticoInicial;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_diagnostico_recepcion", nullable = false)
    private CabeceraDiagnostico idDiagnosticoRecepcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Empleado getIdEmpleadoRecepcion() {
        return idEmpleadoRecepcion;
    }

    public void setIdEmpleadoRecepcion(Empleado idEmpleadoRecepcion) {
        this.idEmpleadoRecepcion = idEmpleadoRecepcion;
    }

    public CabeceraDiagnostico getIdDiagnosticoInicial() {
        return idDiagnosticoInicial;
    }

    public void setIdDiagnosticoInicial(CabeceraDiagnostico idDiagnosticoInicial) {
        this.idDiagnosticoInicial = idDiagnosticoInicial;
    }

    public CabeceraDiagnostico getIdDiagnosticoRecepcion() {
        return idDiagnosticoRecepcion;
    }

    public void setIdDiagnosticoRecepcion(CabeceraDiagnostico idDiagnosticoRecepcion) {
        this.idDiagnosticoRecepcion = idDiagnosticoRecepcion;
    }

}