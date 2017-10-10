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

        return new ClienteLimiteCreditoRiscoDTO(nome, valorLimite, tipoRisco, clienteLimiteCreditoRisco.getRisco().getTaxaJuros().getTaxa());

    }

    @Override
    public ClienteLimiteCreditoRisco toModel(ClienteLimiteCreditoRiscoDTO clienteLimiteCreditoRiscoDTO) {
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO, "modelo não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO.getNome(), "cliente não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO.getLimiteCredito(), "limite de crédito não pode ser nulo");
        Objects.requireNonNull(clienteLimiteCreditoRiscoDTO.getTipoRisco(), "TipoRisco não pode ser nulo");

        Cliente cliente = new Cliente(clienteLimiteCreditoRiscoDTO.getNome());

        LimiteCredito limiteCredito = new LimiteCredito(toBD(clienteLimiteCreditoRiscoDTO.getLimiteCredito()));

        Risco risco = new Risco(toTipoRisco(clienteLimiteCreditoRiscoDTO));

        return new ClienteLimiteCreditoRisco(cliente, limiteCredito, risco);
    }

    public static TipoRisco toTipoRisco(ClienteLimiteCreditoRiscoDTO clienteLimiteCreditoRiscoDTO) {
        final String tipoRisco = clienteLimiteCreditoRiscoDTO.getTipoRisco();
        try {
            return TipoRisco.valueOf(tipoRisco);
        } catch (IllegalArgumentException e) {
            throw new NegocioException("Tipo de risco deve ser A, B ou C. Valor informado: " + tipoRisco, e);
        }
    }

    private BigDecimal toBD(String limiteCredito) {
        try {
            final BigDecimal bigDecimal = new BigDecimal(limiteCredito.replaceAll(",", "."));

            if (bigDecimal.scale() > 2) {
                throw new IllegalArgumentException("Limite credito deve conter no máximo 2 casas decimais");
            }

            return bigDecimal;
        } catch (IllegalArgumentException e) {
            throw new NegocioException("limite crédito deve ser um número decimal válido com no máximo 2 casas decimais. Valor informado: " + limiteCredito);
        }
    }
}
