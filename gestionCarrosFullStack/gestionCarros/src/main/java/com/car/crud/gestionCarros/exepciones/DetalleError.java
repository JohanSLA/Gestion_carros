package com.car.crud.gestionCarros.exepciones;

import java.time.LocalDateTime;

public class DetalleError {
    private LocalDateTime timeStamp;
    private String mensaje;
    private String patch;
    private String error;

    //Metodos contructor

    public DetalleError() {
    }

    /**
     * Metodo contructor de la clase DetalleError
     * @param timeStamp
     * @param mensaje
     * @param patch
     * @param error
     */
    public DetalleError(LocalDateTime timeStamp, String mensaje, String patch, String error) {
        this.timeStamp = timeStamp;
        this.mensaje = mensaje;
        this.patch = patch;
        this.error = error;
    }


    //Getter y setter de la clase

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
