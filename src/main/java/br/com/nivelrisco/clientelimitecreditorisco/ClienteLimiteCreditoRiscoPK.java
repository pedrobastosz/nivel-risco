/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.clientelimitecreditorisco;

import br.com.nivelrisco.client.model.Cliente;
import br.com.nivelrisco.limitecredito.model.LimiteCredito;
import br.com.nivelrisco.risco.model.Risco;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author pedro
 */
@Embeddable
public class ClienteLimiteCreditoRiscoPK implements Serializable {

    private Cliente cliente;

    private LimiteCredito limiteCredito;

    private Risco risco;

    public ClienteLimiteCreditoRiscoPK(Cliente cliente, LimiteCredito limiteCredito, Risco risco) {
        this.cliente = cliente;
        this.limiteCredito = limiteCredito;
        this.risco = risco;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LimiteCredito getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(LimiteCredito limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cliente);
        hash = 41 * hash + Objects.hashCode(this.limiteCredito);
        hash = 41 * hash + Objects.hashCode(this.risco);
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
