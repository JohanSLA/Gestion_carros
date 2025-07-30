package com.car.crud.gestionCarros.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CapturadorGobalExepcion {

    @ExceptionHandler(RecursoNoEncontradoExepcion.class)
    public ResponseEntity<  DetalleError> handleResourceNotFoundException(RecursoNoEncontradoExepcion ex,
                                                                        WebRequest webRequest){
        DetalleError error = new DetalleError (
                LocalDateTime.now(),
                ex.getMessage(),
                webRequest.getDescription(false),
                "No encontrado");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
