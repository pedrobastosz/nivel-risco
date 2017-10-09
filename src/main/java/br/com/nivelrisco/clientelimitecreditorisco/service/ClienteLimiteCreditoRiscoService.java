/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco.service;

import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTO;
import java.util.List;

/**
 *
 * @author pedro
 */
public interface ClienteLimiteCreditoRiscoService {

    ClienteLimiteCreditoRiscoDTO salvar(ClienteLimiteCreditoRiscoDTO clienteLimiteCreditoRiscoDTO);

    List<ClienteLimiteCreditoRiscoDTO> listarTodos();
    
}
