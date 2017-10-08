/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.client.service;

import br.com.nivelrisco.common.EntidadeNaoEncontradaException;
import br.com.nivelrisco.client.dao.ClienteDAO;
import br.com.nivelrisco.client.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteDAO clienteDAO;

    @Autowired
    public ClienteServiceImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente findOne(Long id) {
        Cliente findOne = clienteDAO.findOne(id);
        if (findOne == null) {
            throw new EntidadeNaoEncontradaException("Cliente");
        }
        return findOne;
    }

}
