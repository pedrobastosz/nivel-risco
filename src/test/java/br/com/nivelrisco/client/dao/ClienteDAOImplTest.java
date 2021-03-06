/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.client.dao;

import br.com.nivelrisco.cliente.dao.ClienteDAO;
import br.com.nivelrisco.cliente.model.Cliente;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author pedro
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteDAOImplTest {

    private static final String TEST_NOME = "Nome";

    @Autowired
    private ClienteDAO clienteDAO;

    @Test
    public void testSave() {
        Cliente save = clienteDAO.save(createCliente());

        Assertions.assertThat(save)
                .isNotNull();

        Assertions.assertThat(save.getNome()).isEqualTo(TEST_NOME);
    }

    @Test
    public void testSaveByNome() {
        final Cliente createCliente = createCliente();
        
        Cliente save = clienteDAO.save(createCliente);
        
        save = clienteDAO.findByNome(save.getNome());
        
        Assertions.assertThat(save)
                .isNotNull();
        
        Assertions.assertThat(save.getNome()).isEqualTo(TEST_NOME);
    }

    private static Cliente createCliente() {
        return new Cliente(TEST_NOME);
    }

}
