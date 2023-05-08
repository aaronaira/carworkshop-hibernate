package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Entity
@Table(name = "ot_cabecera", schema = "carworkshop", indexes = {
        @Index(name = "id_diagnostico", columnList = "id_diagnostico"),
        @Index(name = "id_vehiculo", columnList = "id_vehiculo")
})
public class OtCabecera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha_hora", nullable = false)
    private Date fechaHora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo idVehiculo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_diagnostico", nullable = false)
    private CabeceraDiagnostico idDiagnostico;

   // @OneToMany(mappedBy = "idOt")
   // private Set<Encuesta> encuestas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idOt")
    private Set<PiezasOt> idOt = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idOt")
    private Set<ManoobraOt> manoobraOts = new LinkedHashSet<>();

   // @OneToMany(mappedBy = "idOt")
   // private Set<FacturaCabecera> facturaCabeceras = new LinkedHashSet<>();

    @OneToOne(mappedBy = "otCabecera")
    private OtTotales otTotales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CabeceraDiagnostico getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(CabeceraDiagnostico idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

}