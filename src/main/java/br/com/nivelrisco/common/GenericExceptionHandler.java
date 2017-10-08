/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.common;

import javax.websocket.ClientEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author pedro
 */
@ControllerAdvice(annotations = ClientEndpoint.class)
public class GenericExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler
    public ResponseEntity<Object> handle(Exception e) {
        
        return new ResponseEntity<>(e.getMessage().substring(0, 50), HttpStatus.BAD_REQUEST);
    }
}
