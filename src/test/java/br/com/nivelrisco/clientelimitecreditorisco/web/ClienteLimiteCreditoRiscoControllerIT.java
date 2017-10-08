/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco.web;

import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTO;
import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTOMapperTest;
import javax.servlet.ServletContext;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.RequestEntity.post;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteLimiteCreditoRiscoControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    public ClienteLimiteCreditoRiscoControllerIT() {
    }

    @Test
    public void testSomeMethod() {
        final ClienteLimiteCreditoRiscoDTO createCadastro = createCadastro();
        
        ResponseEntity<ClienteLimiteCreditoRiscoDTO> postForEntity = restTemplate.postForEntity(
                "/api" + ClienteLimiteCreditoRiscoController.URI_CADASTRO, 
                createCadastro, 
                ClienteLimiteCreditoRiscoDTO.class);
        
        Assertions.assertThat(postForEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.OK);
        Assertions.assertThat(postForEntity.getBody()).isEqualToComparingFieldByField(createCadastro);
        
    }

    public static ClienteLimiteCreditoRiscoDTO createCadastro() {
        return ClienteLimiteCreditoRiscoDTOMapperTest.createClienteLimiteCreditoRiscoDTO();
    }

}
