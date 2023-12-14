package com.example.verduleriaweb.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsuarioExceptionHandler {

    @ExceptionHandler(value = {UsuarioNotFoundException.class})
    public ResponseEntity<Object> handleUsuarioNotFoundException (UsuarioNotFoundException usuarioNotFoundException){
        UsuarioException usuarioException = new UsuarioException(
                usuarioNotFoundException.getMessage(),
                usuarioNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(usuarioNotFoundException, HttpStatus.NOT_FOUND);
    }
}
