/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nivelrisco.client.dao;

import br.com.nivelrisco.client.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
/**
 *
 * @author pedro
 */
@RepositoryRestResource
public interface ClienteDAO extends JpaRepository<Cliente, Long>{
    
}
