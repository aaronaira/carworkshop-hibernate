package org.carworkshop.enums;
public enum ErroresLogin {
    EMAIL_NOT_FOUND("EMAIL_NOT_FOUND", "No hemos podido encontrar ninguna cuenta con ese nombre de cliente o contraseña."),
    PASSWORD_WRONG("PASSWORD_WRONG", "Su cuenta o contraseña es incorrecta.");


    private String errorCode;
    private String errorMessage;

    ErroresLogin(String errorCode, String errorMessage) {
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
