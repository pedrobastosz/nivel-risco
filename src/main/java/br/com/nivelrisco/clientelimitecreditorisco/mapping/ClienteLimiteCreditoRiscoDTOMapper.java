package br.com.nivelrisco.clientelimitecreditorisco.mapping;

import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.common.DTOMapper;
import br.com.nivelrisco.clientelimitecreditorisco.model.ClienteLimiteCreditoRisco;
import br.com.nivelrisco.common.NegocioException;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import br.com.nivelrisco.risco.model.Risco;
import br.com.nivelrisco.risco.model.TipoRisco;
import java.math.BigDecimal;
import java.util.Objects;
import org.springframework.stereotype.Component;

/**
 *
 * @author pedro
 */
@Component
public class ClienteLimiteCreditoRiscoDTOMapper implements
        DTOMapper<ClienteLimiteCreditoRisco, ClienteLimiteCreditoRiscoDTO> {

    @Override
    public ClienteLimiteCreditoRiscoDTO toDTO(ClienteLimiteCreditoRisco clienteLimiteCreditoRisco) {
        Objects.requireNonNull(clienteLimiteCreditoRisco, "modelo não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRisco.getCliente(), "cliente não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRisco.getLimiteCredito(), "limite de crédito não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRisco.getRisco(), "Risco não pode ser nulo");

        Cliente cliente = clienteLimiteCreditoRisco.getCliente();
        String nome = cliente.getNome();

        String valorLimite = clienteLimiteCreditoRisco.getLimiteCredito().getValorLimite().toString();

        String tipoRisco = clienteLimiteCreditoRisco.getRisco().getTipoRisco().toString();

        return new ClienteLimiteCreditoRiscoDTO(nome, valorLimite, tipoRisco);

    }

    @Override
    public ClienteLimiteCreditoRisco toModel(ClienteLimiteCreditoRiscoDTO clienteLimiteCreditoRiscoDTO) {
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO, "modelo não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO.getNome(), "cliente não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO.getLimiteCredito(), "limite de crédito não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO.getTipoRisco(), "TipoRisco não pode ser nulo");

        Cliente cliente = new Cliente(clienteLimiteCreditoRiscoDTO.getNome());

        LimiteCredito limiteCredito = new LimiteCredito(toBD(clienteLimiteCreditoRiscoDTO.getLimiteCredito()));

        Risco risco = new Risco(TipoRisco.valueOf(clienteLimiteCreditoRiscoDTO.getTipoRisco()));

        return new ClienteLimiteCreditoRisco(cliente, limiteCredito, risco);
    }

    private BigDecimal toBD(String limiteCredito) {
        try {
            return new BigDecimal(limiteCredito);
        } catch (Exception e) {
            throw new NegocioException("limite crédito deve ser um número decimal válido: " + limiteCredito);
        }
    }
}
