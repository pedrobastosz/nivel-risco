package br.com.nivelrisco.risco.service;

import br.com.nivelrisco.risco.dao.RiscoDAO;
import br.com.nivelrisco.risco.model.Risco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
public class RiscoServiceImpl implements RiscoService {

    private final RiscoDAO RiscoDAO;

    @Autowired
    public RiscoServiceImpl(RiscoDAO RiscoDAO) {
        this.RiscoDAO = RiscoDAO;
    }

    @Override
    public <S extends Risco> S save(S entity) {
        return RiscoDAO.save(entity);
    }

    @Override
    public Risco findOne(Long id) {
        return RiscoDAO.findOne(id);
    }

}
