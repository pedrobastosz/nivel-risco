/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.risco.model;

import java.math.BigDecimal;

/**
 *
 * @author pedro
 */
public enum TaxaJuros {

    NENHUMA(null), DEZ_PORCENTO(BigDecimal.valueOf(10)), VINTE_PORCENTO(BigDecimal.valueOf(20)) ;

    private BigDecimal taxa;

    private TaxaJuros(BigDecimal taxa) {
        this.taxa = taxa;
    }

}
