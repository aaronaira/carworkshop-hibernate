package org.carworkshop.Enums;

public enum ErroresRegistro {
    NAME("El campo de nombre, los apellidos y direccion, " +
            "tienen que tener entre 3 y 50 caracteres alfanuméricos",
            "name_format_error"),
    DNI("El campo DNI tiene que cumplir el formato: 12345678A",
            "dni_format_error"),
    PASSWORD("El campo PASSWORD tiene que tener 8 caracteres como mínimo " +
            "y 15 como máximo. Tiene que incluir al menos una letra en mayuscula, " +
            "un número y alguno de los siguientes signos: #$_.!@^+-", "password_format_error"),
    PASSWORD1("El PASSWORD no coincide", "password_match"),

    EMAIL("Introduzca una dirección de correo electrónica válida", "email_format_error");


    private String errorMessage;
    private String errorCode;

    ErroresRegistro(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
