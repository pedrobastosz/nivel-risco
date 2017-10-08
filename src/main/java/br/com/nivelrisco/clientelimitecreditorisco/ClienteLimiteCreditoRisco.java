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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author pedro
 */
@IdClass(ClienteLimiteCreditoRiscoPK.class)
@Entity(name = "ClienteLimiteCreditoRisco")
public class ClienteLimiteCreditoRisco implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "codigoCliente", nullable = false)
    private Cliente cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigoLimiteCredito", nullable = false)
    private LimiteCredito limiteCredito;

    @Id
    @ManyToOne
    @JoinColumn(name = "codigoRisco", nullable = false)
    private Risco risco;

    public ClienteLimiteCreditoRisco(Cliente cliente, LimiteCredito limiteCredito, Risco risco) {
        this.cliente = cliente;
        this.limiteCredito = limiteCredito;
        this.risco = risco;
    }

    public ClienteLimiteCreditoRisco() {
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

    public ClienteLimiteCreditoRiscoPK asPK() {
        return new ClienteLimiteCreditoRiscoPK(getCliente(), getLimiteCredito(), getRisco());
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
        final ClienteLimiteCreditoRisco other = (ClienteLimiteCreditoRisco) obj;
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
