/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.client.dao;

import br.com.nivelrisco.client.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
 
/**
 *
 * @author pedro
 */
public interface ClienteDAO extends JpaRepository<Cliente, Long>{
    Cliente findByNome(String nome);
}
