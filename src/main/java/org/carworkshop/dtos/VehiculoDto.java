package org.carworkshop.dtos;

public class VehiculoDto {

    private Integer id;
    private String matricula;
    private String marca;
    private String modelo;
    private String v_year;
    private ClienteDto cliente;
    private String tipo_vehiculo;
    private String bastidor;

    public VehiculoDto(Integer id, String matricula, String marca, String modelo, String v_year, ClienteDto cliente, String tipo_vehiculo, String bastidor) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.v_year = v_year;
        this.cliente = cliente;
        this.tipo_vehiculo = tipo_vehiculo;
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

    public String getV_year() {
        return v_year;
    }

    public void setV_year(String v_year) {
        this.v_year = v_year;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }
}
