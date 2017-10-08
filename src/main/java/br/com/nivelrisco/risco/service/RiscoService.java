/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.risco.service;

import br.com.nivelrisco.risco.model.Risco;

/**
 *
 * @author pedro
 */
public interface RiscoService {

    Risco findOne(Long id);

    <S extends Risco> S save(S entity);

}
