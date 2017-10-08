/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco.mapping;

import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.clientelimitecreditorisco.ClienteLimiteCreditoRisco;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import br.com.nivelrisco.risco.model.Risco;
import br.com.nivelrisco.risco.model.TipoRisco;
import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 *
 * @author pedro
 */
public class ClienteLimiteCreditoRiscoDTOMapperTest {

    public static final String TESTE_NOME_CLIENTE = "Teste Nome";
    public static final String TESTE_LIMITE_VALOR_STR = "458";
    public static final String TESTE_TIPO_RISCO_A_STR = "A";

    private ClienteLimiteCreditoRiscoDTOMapper mapper = new ClienteLimiteCreditoRiscoDTOMapper();

    @Test
    public void testToModel() {
        ClienteLimiteCreditoRisco toModel = mapper.toModel(createClienteLimiteCreditoRiscoDTO());
        Assertions.assertThat(toModel).isNotNull();
        Assertions.assertThat(toModel.getCliente().getNome()).isEqualTo(TESTE_NOME_CLIENTE);
        Assertions.assertThat(toModel.getLimiteCredito().getValorLimite()).isEqualTo(TESTE_LIMITE_VALOR_STR);
        Assertions.assertThat(toModel.getRisco().getTipoRisco().toString()).isEqualTo(TESTE_TIPO_RISCO_A_STR);
    }

    @Test
    public void testToDTO() {
        ClienteLimiteCreditoRiscoDTO toDTO = mapper.toDTO(createClienteLimiteCreditoRisco());
        Assertions.assertThat(toDTO).isNotNull();
        Assertions.assertThat(toDTO.getNomeCliente()).isEqualTo(TESTE_NOME_CLIENTE);
        Assertions.assertThat(toDTO.getLimiteCredito()).isEqualTo(TESTE_LIMITE_VALOR_STR);
        Assertions.assertThat(toDTO.getTipoRisco()).isEqualTo(TESTE_TIPO_RISCO_A_STR);
    }

    public static ClienteLimiteCreditoRiscoDTO createClienteLimiteCreditoRiscoDTO() {
        return new ClienteLimiteCreditoRiscoDTO(TESTE_NOME_CLIENTE, TESTE_LIMITE_VALOR_STR, TESTE_TIPO_RISCO_A_STR);
    }

    public ClienteLimiteCreditoRisco createClienteLimiteCreditoRisco() {

        Cliente c = new Cliente(TESTE_NOME_CLIENTE);

        LimiteCredito limiteCredito = new LimiteCredito(new BigDecimal(TESTE_LIMITE_VALOR_STR));

        Risco risco = new Risco(TipoRisco.valueOf(TESTE_TIPO_RISCO_A_STR));

        return new ClienteLimiteCreditoRisco(c, limiteCredito, risco);
    }

}
