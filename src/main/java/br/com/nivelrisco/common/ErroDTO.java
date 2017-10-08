/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.http.HttpStatus;

/**
 *
 * @author pedro
 */
public class ErroDTO {

//    private HttpStatus status;
    private String mensagem;
    
    @JsonCreator
    public ErroDTO(HttpStatus status, String mensagem) {
//        this.status = status;
        this.mensagem = mensagem;
    }

}
