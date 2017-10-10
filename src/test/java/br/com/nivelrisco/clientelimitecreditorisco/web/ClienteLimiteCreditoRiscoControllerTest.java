/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco.web;

import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTO;
import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTOMapperTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteLimiteCreditoRiscoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    public ClienteLimiteCreditoRiscoControllerTest() {
    }

    @Test
    public void testSomeMethod() {
        final ClienteLimiteCreditoRiscoDTO createCadastro = createCadastro();
        
        ResponseEntity<ClienteLimiteCreditoRiscoDTO> postForEntity = restTemplate.postForEntity(
                ClienteLimiteCreditoRiscoController.URI_CADASTRO, 
                createCadastro, 
                ClienteLimiteCreditoRiscoDTO.class);
        
        Assertions.assertThat(postForEntity.getBody()).isEqualToComparingFieldByField(createCadastro);
        Assertions.assertThat(postForEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        
    }

    public static ClienteLimiteCreditoRiscoDTO createCadastro() {
        return ClienteLimiteCreditoRiscoDTOMapperTest.createClienteLimiteCreditoRiscoDTO();
    }

}
