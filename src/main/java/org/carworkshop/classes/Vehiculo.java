package org.carworkshop.classes;

public abstract class Vehiculo {

    private Integer id;
    private String matricula;
    private String marca;
    private String modelo;
    private String v_year;
    private int id_cliente;
    private Integer tipo_vehiculo;
    private String bastidor;

    protected Vehiculo() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(Integer tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo vehiculo)) return false;

        if (!getMatricula().equals(vehiculo.getMatricula())) return false;
        if (!getMarca().equals(vehiculo.getMarca())) return false;
        if (!getModelo().equals(vehiculo.getModelo())) return false;
        if (!getV_year().equals(vehiculo.getV_year())) return false;
        if (!getTipo_vehiculo().equals(vehiculo.getTipo_vehiculo())) return false;
        return getBastidor().equals(vehiculo.getBastidor());
    }

    @Override
    public int hashCode() {
        int result = getMatricula().hashCode();
        result = 31 * result + getMarca().hashCode();
        result = 31 * result + getModelo().hashCode();
        result = 31 * result + getV_year().hashCode();
        result = 31 * result + getTipo_vehiculo().hashCode();
        result = 31 * result + getBastidor().hashCode();
        return result;
    }
}
