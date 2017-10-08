/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.client.service;

import br.com.nivelrisco.client.model.Cliente;

/**
 *
 * @author pedro
 */
public interface ClienteService {

    Cliente findOne(Long id);

    Cliente save(Cliente cliente);

    Cliente salvarOuCarregarPorNome(Cliente cliente);

}
