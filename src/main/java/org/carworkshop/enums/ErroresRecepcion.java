package org.carworkshop.enums;
public enum ErroresRecepcion {
    HORA_MATRICULA_WRONG("MATRICULA_WRONG", "No hemos podido encontrar ninguna matricula o cita hoy en la base de datos."),
    MATRICULA_WRONG("MATRICULA_WRONG", "No hemos podido encontrar ninguna matricula como la introducida en la base de datos."),
    VEHICLE_WRONG("VEHICLE WRONG", "No hemos podido encontrar ningun vehiculo con la matricula introducida que tenga cita hoy."),
    EMPLEADO_MISSING("EMPLEADO_MISSING","No hay ningun empleado asociado a la recepcion." );

    private String errorCode;
    private String errorMessage;

    ErroresRecepcion(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
