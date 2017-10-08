/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco.web;

import br.com.nivelrisco.client.mapping.ClienteLimiteCreditoRiscoDTO;
import br.com.nivelrisco.client.service.ClienteService;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pedro
 */
@RestController
@RequestMapping("/cliente")
public class ClientController {

    private final ClienteService clienteService;

    @Autowired
    public ClientController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping("/{id}")
    public ClienteLimiteCreditoRiscoDTO getCliente(@PathParam(value = "id") Long codigo) {
        return clienteService.findOne(codigo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ClienteLimiteCreditoRiscoDTO saveCliente(@RequestParam ClienteLimiteCreditoRiscoDTO clienteDTO) {
        return clienteService.save(clienteDTO);
    }

}
