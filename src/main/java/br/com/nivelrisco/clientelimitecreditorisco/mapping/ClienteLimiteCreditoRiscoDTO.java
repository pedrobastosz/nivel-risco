package br.com.nivelrisco.clientelimitecreditorisco.mapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author pedro
 */
public class ClienteLimiteCreditoRiscoDTO {
    
    @NotBlank(message = "Nome cliente deve ser informado")
    private final String nome;

    @NotBlank(message = "valor de limite credito cliente deve ser informado")    
    private final String limiteCredito;
    
    @NotBlank(message = "Tipo do risco deve ser informado")
    private final String tipoRisco;

    @JsonCreator
    public ClienteLimiteCreditoRiscoDTO(
            @JsonProperty("nome") String nome,
            @JsonProperty("limiteCredito") String lmiteCredito,
            @JsonProperty("tipoRisco") String tipoRisco) {
        this.nome = nome;
        this.limiteCredito = lmiteCredito;
        this.tipoRisco = tipoRisco;
    }
    
    public String getNomeCliente() {
        return nome;
    }

    public String getLimiteCredito() {
        return limiteCredito;
    }

    public String getTipoRisco() {
        return tipoRisco;
    }

}
