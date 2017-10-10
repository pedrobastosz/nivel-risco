package br.com.nivelrisco.clientelimitecreditorisco.mapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author pedro
 */
public class ClienteLimiteCreditoRiscoDTO {

    @NotBlank(message = "Nome cliente deve ser informado")
    private String nome;

    @NotBlank(message = "valor de limite credito cliente deve ser informado")
    private String limiteCredito;

    @NotBlank(message = "Tipo do risco deve ser informado")
    private String tipoRisco;

    private String taxaJuros;

    public ClienteLimiteCreditoRiscoDTO() {
    }

    @JsonCreator
    public ClienteLimiteCreditoRiscoDTO(
            @JsonProperty("nome") String nome,
            @JsonProperty("limiteCredito") String lmiteCredito,
            @JsonProperty("tipoRisco") String tipoRisco,
            @JsonProperty("taxaJuros") String taxaJuros) {
        this.nome = nome;
        this.limiteCredito = lmiteCredito;
        this.tipoRisco = tipoRisco;
        this.taxaJuros = taxaJuros;
    }

    public String getNome() {
        return nome;
    }

    public String getLimiteCredito() {
        return limiteCredito;
    }

    public String getTipoRisco() {
        return tipoRisco;
    }

    public void setLimiteCredito(String limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoRisco(String tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public String getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(String taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.limiteCredito);
        hash = 67 * hash + Objects.hashCode(this.tipoRisco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClienteLimiteCreditoRiscoDTO other = (ClienteLimiteCreditoRiscoDTO) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.limiteCredito, other.limiteCredito)) {
            return false;
        }
        if (!Objects.equals(this.tipoRisco, other.tipoRisco)) {
            return false;
        }
        return true;
    }

}
