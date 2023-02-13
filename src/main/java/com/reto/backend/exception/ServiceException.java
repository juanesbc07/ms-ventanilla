package com.reto.backend.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -7661881974216233311L;
    private  int statusCode;

    public ServiceException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getStatusCode(){return statusCode;}

}
