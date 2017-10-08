/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.limitecredito.service;

import br.com.nivelrisco.limitecredito.dao.LimiteCreditoDAO;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;
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
    public <S extends LimiteCredito> S save(S entity) {
        return limiteCreditoDAO.save(entity);
    }

    @Override
    public LimiteCredito findOne(Long id) {
        return limiteCreditoDAO.findOne(id);
    }

}
