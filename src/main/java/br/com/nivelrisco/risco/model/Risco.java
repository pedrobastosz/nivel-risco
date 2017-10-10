/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.risco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pedro
 */
@Entity(name = "Risco")
public class Risco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @NotNull(message = "Tipo de risco é obrigatório")
    @Column(length = 1, nullable = false, unique = true)
    private TipoRisco tipoRisco;

    private TaxaJuros taxaJuros;

    public Risco() {
        super();
    }

    public Risco(TipoRisco tipoRisco) {
        this.tipoRisco = tipoRisco;
        setTaxaJurosBaseadoNivelRisco(tipoRisco);
    }

    public final void setTaxaJurosBaseadoNivelRisco(TipoRisco tipoRisco1) {
        switch (tipoRisco1) {
             case A:
                this.taxaJuros = TaxaJuros.NENHUMA;
                break;
            case B:
                this.taxaJuros = TaxaJuros.DEZ_PORCENTO;
                break;
            case C:
                this.taxaJuros = TaxaJuros.VINTE_PORCENTO;
                break;
            default:
                throw new IllegalArgumentException(String.format(
                        "Nivel de risco %s não tem uma taxa de juros associada", tipoRisco1));
        }
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoRisco getTipoRisco() {
        return tipoRisco;
    }

    public void setTipoRisco(TipoRisco tipoRisco) {
        this.tipoRisco = tipoRisco;
    }

    public TaxaJuros getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(TaxaJuros taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
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
        final Risco other = (Risco) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

}
