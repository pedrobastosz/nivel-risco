/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.limitecredito.service;

import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;

/**
 *
 * @author pedro
 */
public interface LimiteCreditoService {

    LimiteCredito findOne(Long id);

    <S extends LimiteCredito> S save(S entity);

}