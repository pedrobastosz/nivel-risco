/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco;

import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.client.service.ClienteService;
import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTO;
import br.com.nivelrisco.clientelimitecreditorisco.mapping.ClienteLimiteCreditoRiscoDTOMapper;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import br.com.nivelrisco.limitecredito.service.LimiteCreditoService;
import br.com.nivelrisco.risco.model.Risco;
import br.com.nivelrisco.risco.service.RiscoService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class ClienteLimiteCreditoRiscoServiceImpl implements ClienteLimiteCreditoRiscoService {

    private final ClienteLimiteCreditoRiscoDAO clienteLimiteCreditoRiscoDAO;

    private final ClienteLimiteCreditoRiscoDTOMapper mapper;

    private final ClienteService clienteService;

    private final LimiteCreditoService limiteCreditoService;

    private final RiscoService riscoService;

    @Autowired
    public ClienteLimiteCreditoRiscoServiceImpl(
            ClienteLimiteCreditoRiscoDAO clienteLimiteCreditoRiscoDAO,
            ClienteLimiteCreditoRiscoDTOMapper mapper,
            ClienteService clienteService,
            LimiteCreditoService limiteCreditoService,
            RiscoService riscoService) {
        this.clienteLimiteCreditoRiscoDAO = clienteLimiteCreditoRiscoDAO;
        this.mapper = mapper;
        this.clienteService = clienteService;
        this.limiteCreditoService = limiteCreditoService;
        this.riscoService = riscoService;
    }

    @Transactional
    @Override
    public ClienteLimiteCreditoRiscoDTO salvar(ClienteLimiteCreditoRiscoDTO clienteLimiteCreditoRiscoDTO) {
        ClienteLimiteCreditoRisco clienteLimiteCreditoRisco = mapper.toModel(clienteLimiteCreditoRiscoDTO);

        Cliente cliente = clienteService.salvarOuCarregarPorNome(clienteLimiteCreditoRisco.getCliente());

        LimiteCredito limiteCredito = limiteCreditoService.salvarOuCarregarPorValorLimite(clienteLimiteCreditoRisco.getLimiteCredito());

        Risco risco = riscoService.salvarOuCarregarPorTipoRisco(clienteLimiteCreditoRisco.getRisco());

        ClienteLimiteCreditoRisco save = clienteLimiteCreditoRiscoDAO.save(new ClienteLimiteCreditoRisco(cliente, limiteCredito, risco));

        return mapper.toDTO(save);
    }

}
