/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.risco.dao;

import br.com.nivelrisco.risco.model.Risco;
import br.com.nivelrisco.risco.model.TaxaJuros;
import br.com.nivelrisco.risco.model.TipoRisco;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RiscoDAOIT {

    @Autowired
    private RiscoDAO riscoDAO;

    @Test
    public void testSave_RiscoA() {
        Risco save = riscoDAO.save(createRiscoTipoA());

        Assertions.assertThat(save)
                .isNotNull();

        Assertions.assertThat(save.getTipoRisco()).isEqualTo(TipoRisco.A);
        Assertions.assertThat(save.getTaxaJuros()).isEqualTo(TaxaJuros.NENHUMA);
    }

    @Test
    public void testSave_RiscoB() {
        Risco save = riscoDAO.save(createRiscoTipoB());

        Assertions.assertThat(save)
                .isNotNull();
        Assertions.assertThat(save.getTipoRisco()).isEqualTo(TipoRisco.B);
        Assertions.assertThat(save.getTaxaJuros()).isEqualTo(TaxaJuros.DEZ_PORCENTO);
    }

    @Test
    public void testSave_RiscoC() {
        Risco save = riscoDAO.save(createRiscoTipoC());

        Assertions.assertThat(save)
                .isNotNull();
        Assertions.assertThat(save.getTipoRisco()).isEqualTo(TipoRisco.C);
        Assertions.assertThat(save.getTaxaJuros()).isEqualTo(TaxaJuros.VINTE_PORCENTO);
    }

    @Test
    public void testFindByTipoRIsco() {
        final Risco createRiscoTipoC = createRiscoTipoC();

        riscoDAO.save(createRiscoTipoC);

        Risco find = riscoDAO.findByTipoRisco(createRiscoTipoC.getTipoRisco());
        
        Assertions.assertThat(find).isNotNull();
    }

    private static Risco createRiscoTipoA() {
        return new Risco(TipoRisco.A);
    }

    private static Risco createRiscoTipoB() {
        return new Risco(TipoRisco.B);
    }

    private static Risco createRiscoTipoC() {
        return new Risco(TipoRisco.C);
    }

}
