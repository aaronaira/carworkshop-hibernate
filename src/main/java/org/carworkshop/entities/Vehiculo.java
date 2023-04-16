package org.carworkshop.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "v_year", nullable = false)
    private Integer vYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;


    @Column(name = "tipo_vehiculo", nullable = false)
    private Integer tipoVehiculo;

    @Column(name = "bastidor")
    private String bastidor;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setVYear(Integer vYear) {
        this.vYear = vYear;
    }

    public Integer getVYear() {
        return vYear;
    }

    public void setTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Integer getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getBastidor() {
        return bastidor;
    }

//    @Override
//    public String toString() {
//        return "Vehiculo{" +
//                "id=" + id + '\'' +
//                "matricula=" + matricula + '\'' +
//                "marca=" + marca + '\'' +
//                "modelo=" + modelo + '\'' +
//                "vYear=" + vYear + '\'' +
//                "idCliente=" + clientes + '\'' +
//                "tipoVehiculo=" + tipoVehiculo + '\'' +
//                "bastidor=" + bastidor + '\'' +
//                '}';
//    }
}
