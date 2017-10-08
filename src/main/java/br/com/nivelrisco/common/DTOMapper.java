/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.common;

/**
 *
 * @author pedro
 */
public interface DTOMapper<M, DTO> {

    DTO toDTO(M modelo);

    M toModel(DTO dto);
    
}
