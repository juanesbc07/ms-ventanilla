package com.reto.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class ErrorResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("dateTransaction")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private ZonedDateTime dateTransaction;

    public ErrorResponse(ZonedDateTime dateTransaction){
        this.dateTransaction = dateTransaction;
    }

    public ErrorResponse(){
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(ZonedDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    @Override
    public String toString(){
        return "ErrorResponse [message=" + message +", dateTransaction=" + dateTransaction + "]";
    }
}
