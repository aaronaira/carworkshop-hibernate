package org.carworkshop.dtos;
import java.util.Date;

public class RecepcionDto {

    private int id;
    private String foto;
    private Date fechaHora;
    private VehiculoDto idVehiculo;
    private EmpleadoDto idEmpleadoRecepcion;
    private CabeceraDiagnosticoDto idDiagnosticoInicial;
    private CabeceraDiagnosticoDto IdDiagnosticoRecepcion;

    public RecepcionDto(int id, Date fechaHora, VehiculoDto idVehiculo, EmpleadoDto idEmpleadoRecepcion, CabeceraDiagnosticoDto idDiagnosticoInicial, CabeceraDiagnosticoDto IdDiagnosticoRecepcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.idVehiculo = idVehiculo;
        this.idEmpleadoRecepcion = idEmpleadoRecepcion;
        this.idDiagnosticoInicial = idDiagnosticoInicial;
        this.IdDiagnosticoRecepcion = IdDiagnosticoRecepcion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    public void setFechaHoraecha(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public VehiculoDto getIdVehiculo() {
        return idVehiculo;
    }
    public void setIdVehiculo(VehiculoDto idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public EmpleadoDto getEmpleadoRecepcion() {
        return idEmpleadoRecepcion;
    }
    public void  setIdEmpleadoRecepcion(EmpleadoDto idEmpleadoRecepcion) {
        this.idEmpleadoRecepcion = idEmpleadoRecepcion;
    }

    public CabeceraDiagnosticoDto  getidDiagnosticoInicial() {
        return idDiagnosticoInicial;
    }
    public void setIdDiagnosticoInicial(CabeceraDiagnosticoDto idDiagnosticoInicial) {
        this.idDiagnosticoInicial = idDiagnosticoInicial;
    }

    public CabeceraDiagnosticoDto  getIdDiagnosticoRecepcion() {
        return IdDiagnosticoRecepcion;
    }
    public void setIdDiagnosticoRecepcion(CabeceraDiagnosticoDto IdDiagnosticoRecepcion) {
        this.IdDiagnosticoRecepcion = IdDiagnosticoRecepcion;
    }

}