/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author pedro
 */
public class GenericExceptionHandler {
    
    private static final Logger log = LoggerFactory.getLogger(GenericExceptionHandler.class);
//    
//    @ExceptionHandler
//    public ResponseEntity<ErroDTO> handleNegocioException(Exception e) {
//        
//        if (e instanceof NegocioException) {
//            return new ResponseEntity<>(new ErroDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//        log.error("Interceptado erro desconhecido {}", e);
//        return new ResponseEntity<>(new ErroDTO("Ocorreu um erro desconhecido"),
//                HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErroDTO> handleNegocioException(Exception e) {
        if (e instanceof NegocioException) {
            return new ResponseEntity<>(new ErroDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        } else {
            return null;
        }
    }
}
