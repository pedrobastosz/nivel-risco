/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.client.service;

import br.com.nivelrisco.client.dao.ClienteDAO;
import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.common.NegocioException;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public Cliente salvarOuCarregarPorNome(Cliente cliente) {
        Objects.requireNonNull(cliente, "Cliente deve ser fornecido");
        
        final String nomeCliente = cliente.getNome();
        validaNomeCliente( nomeCliente );
        
        Cliente findByNome = clienteDAO.findByNome(nomeCliente);
        if (findByNome == null) {
            return clienteDAO.save(cliente);
        } else {
            return findByNome;
        }
    }

    private void validaNomeCliente(String nomeCliente) {
        if (!StringUtils.hasText(nomeCliente)) {
            throw new NegocioException("Nome do cliente está vazio!");
        }
    }

}
