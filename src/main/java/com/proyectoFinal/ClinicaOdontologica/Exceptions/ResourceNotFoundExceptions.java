package com.proyectoFinal.ClinicaOdontologica.Exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptions extends Exception{

    public ResourceNotFoundExceptions(String msj){
        super(msj);
    }

    @ControllerAdvice
    public static class GlobalResourceNotFoundExceptionsHandler {

        private static final Logger logger = Logger.getLogger(GlobalResourceNotFoundExceptionsHandler.class);

        @ExceptionHandler(ResourceNotFoundExceptions.class)
        public ResponseEntity<?> erroresNotFound(ResourceNotFoundExceptions e){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }
}
