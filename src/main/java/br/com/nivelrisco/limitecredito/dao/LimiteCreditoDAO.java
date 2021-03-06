/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.limitecredito.dao;

import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pedro
 */
public interface LimiteCreditoDAO extends JpaRepository<LimiteCredito, Long>{
    LimiteCredito findByValorLimite(BigDecimal valorLimite);
}
