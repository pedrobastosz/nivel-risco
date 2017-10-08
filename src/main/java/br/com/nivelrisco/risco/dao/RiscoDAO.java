package br.com.nivelrisco.risco.dao;

import br.com.nivelrisco.risco.model.Risco;
import br.com.nivelrisco.risco.model.TipoRisco;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pedro
 */
public interface RiscoDAO extends JpaRepository<Risco, Long> {

    public Risco findByTipoRisco(TipoRisco tipoRisco);

}
