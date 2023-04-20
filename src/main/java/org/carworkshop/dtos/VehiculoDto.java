package org.carworkshop.dtos;

public class VehiculoDto {

    private Integer id;
    private String matricula;
    private String marca;
    private String modelo;
    private int v_year;
    private int cliente;
    private int tipo_vehiculo;
    private String bastidor;

    public VehiculoDto(Integer id, String matricula, String marca, String modelo, int v_year, int cliente, int tipo_vehiculo, String bastidor) {
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

    public int getV_year() {
        return v_year;
    }

    public void setV_year(int v_year) {
        this.v_year = v_year;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(int tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }
}
