/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.risco.model;

/**
 *
 * @author pedro
 */
public enum TaxaJuros {

    NENHUMA("Nenhuma"), DEZ_PORCENTO("10%"), VINTE_PORCENTO("20%");

    private final String taxa;

    private TaxaJuros(String taxa) {
        this.taxa = taxa;
    }

    public String getTaxa() {
        return taxa;
    }
    
}
