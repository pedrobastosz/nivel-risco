/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.limitecredito.service;

import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.limitecredito.dao.LimiteCreditoDAO;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import java.math.BigDecimal;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class LimiteCreditoServiceImpl implements LimiteCreditoService {

    private final LimiteCreditoDAO limiteCreditoDAO;

    @Autowired
    public LimiteCreditoServiceImpl(LimiteCreditoDAO limiteCreditoDAO) {
        this.limiteCreditoDAO = limiteCreditoDAO;
    }

    @Override
    public LimiteCredito salvarOuCarregarPorValorLimite(LimiteCredito limiteCredito) {
        Objects.requireNonNull(limiteCredito, "Limite de credito deve ser fornecido");

        final BigDecimal valorLimite = limiteCredito.getValorLimite();

        LimiteCredito findByLimiteCredito = limiteCreditoDAO.findByValorLimite(valorLimite);
        if (findByLimiteCredito == null) {
            return limiteCreditoDAO.save(limiteCredito);
        } else {
            return findByLimiteCredito;
        }
    }

}
