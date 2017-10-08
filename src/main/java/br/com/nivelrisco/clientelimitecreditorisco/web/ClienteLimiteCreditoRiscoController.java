/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco.web;

import br.com.nivelrisco.clientelimitecreditorisco.ClienteLimiteCreditoRiscoService;
import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTO;
import static br.com.nivelrisco.clientelimitecreditorisco.web.ClienteLimiteCreditoRiscoController.URI_CADASTRO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@RestController
@RequestMapping(URI_CADASTRO)
public class ClienteLimiteCreditoRiscoController {

    public static final String URI_CADASTRO = "/cadastro";

    private final ClienteLimiteCreditoRiscoService clienteLimiteCreditoRiscoService;

    @Autowired
    public ClienteLimiteCreditoRiscoController(ClienteLimiteCreditoRiscoService clienteService) {
        this.clienteLimiteCreditoRiscoService = clienteService;
    }

    @PostMapping
    public ClienteLimiteCreditoRiscoDTO saveClienteLimiteCreditoRiscoDTO(
            @Valid @RequestParam ClienteLimiteCreditoRiscoDTO clienteDTO) {
        return clienteLimiteCreditoRiscoService.salvar(clienteDTO);
    }

}
