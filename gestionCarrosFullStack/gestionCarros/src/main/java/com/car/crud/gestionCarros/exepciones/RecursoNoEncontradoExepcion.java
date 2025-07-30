package com.car.crud.gestionCarros.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class RecursoNoEncontradoExepcion extends RuntimeException {
    private String mensaje; //mensaje de la exepcion

    public RecursoNoEncontradoExepcion(String mensaje) {
        super(mensaje);
        this.mensaje = mensaje;
    }
}
