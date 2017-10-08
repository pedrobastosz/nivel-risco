/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author pedro
 */
@Embeddable
public class ClienteLimiteCreditoRiscoPK implements Serializable {

    private Long cliente;

    private Long limiteCredito;

    private Long risco;

    public ClienteLimiteCreditoRiscoPK() {
    }

    public ClienteLimiteCreditoRiscoPK(Long cliente, Long limiteCredito, Long risco) {
        this.cliente = cliente;
        this.limiteCredito = limiteCredito;
        this.risco = risco;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Long limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Long getRisco() {
        return risco;
    }

    public void setRisco(Long risco) {
        this.risco = risco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cliente);
        hash = 29 * hash + Objects.hashCode(this.limiteCredito);
        hash = 29 * hash + Objects.hashCode(this.risco);
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
        final ClienteLimiteCreditoRiscoPK other = (ClienteLimiteCreditoRiscoPK) obj;
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.limiteCredito, other.limiteCredito)) {
            return false;
        }
        if (!Objects.equals(this.risco, other.risco)) {
            return false;
        }
        return true;
    }

}
