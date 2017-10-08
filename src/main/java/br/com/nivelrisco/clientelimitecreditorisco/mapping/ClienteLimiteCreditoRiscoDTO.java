package br.com.nivelrisco.clientelimitecreditorisco.mapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *
 * @author pedro
 */
public class ClienteLimiteCreditoRiscoDTO {

    private final String nome;
    private final String limiteCredito;
    private final String tipoRisco;

    @JsonCreator
    public ClienteLimiteCreditoRiscoDTO(
            String nome,
            String lmiteCredito,
            String tipoRisco) {
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
