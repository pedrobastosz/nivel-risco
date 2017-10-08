package br.com.nivelrisco.risco.service;

import br.com.nivelrisco.risco.dao.RiscoDAO;
import br.com.nivelrisco.risco.model.Risco;
import br.com.nivelrisco.risco.model.TipoRisco;
import java.math.BigDecimal;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class RiscoServiceImpl implements RiscoService {

    private final RiscoDAO riscoDAO;

    @Autowired
    public RiscoServiceImpl(RiscoDAO RiscoDAO) {
        this.riscoDAO = RiscoDAO;
    }

    @Override
    public <S extends Risco> S save(S entity) {
        return riscoDAO.save(entity);
    }

    @Override
    public Risco findOne(Long id) {
        return riscoDAO.findOne(id);
    }

    @Override
    public Risco salvarOuCarregarPorTipoRisco(Risco risco) {
        Objects.requireNonNull(risco, "Limite de credito deve ser fornecido");

        final TipoRisco tipoRisco = risco.getTipoRisco();

        Risco findByTipoRisco = riscoDAO.findByTipoRisco(tipoRisco);
        if (findByTipoRisco == null) {
            return save(risco);
        } else {
            return findByTipoRisco;
        }
    }

}
