package org.carworkshop.dtos;


import org.carworkshop.entities.Cliente;

import java.lang.String;

public class CocheDto {
    private Integer id;

    private String matricula;

    private String marca;

    private String modelo;

    private Integer vYear;

    private Cliente cliente;

    private Integer tipoVehiculo;

    private String bastidor;

    public CocheDto(int id, String matricula, String modelo, int vYear, int idCliente, Integer tipoVehiculo, String bastidor) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.vYear = vYear;
        this.cliente = cliente;
        this.tipoVehiculo = tipoVehiculo;
        this.bastidor = bastidor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getvYear() {
        return vYear;
    }

    public void setvYear(Integer vYear) {
        this.vYear = vYear;
    }

    //public Integer getIdCliente() {
        //return idCliente;
    //}

//    public void setIdCliente(Integer idCliente) {
//        this.idCliente = idCliente;
//    }

    public Integer getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }
}
