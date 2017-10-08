/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.limitecredito.dao;

import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LimiteCreditoDAOIT {
    
    private static final BigDecimal TEST_VALOR = BigDecimal.TEN;

    @Autowired
    private LimiteCreditoDAO limiteCreditoDAO;

    @Test
    public void testSave() {
        LimiteCredito save = limiteCreditoDAO.save(createLimiteCredito());

        Assertions.assertThat(save)
                .isNotNull();

        Assertions.assertThat(save.getValorLimite()).isEqualTo(TEST_VALOR);
    }

    private static LimiteCredito createLimiteCredito() {
        return new LimiteCredito(TEST_VALOR);
    }

    
}
