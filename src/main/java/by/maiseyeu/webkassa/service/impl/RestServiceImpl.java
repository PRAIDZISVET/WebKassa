package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("restService")
public class RestServiceImpl implements ServiceDAO<Long,Rest> {

    private BaseDAO<Long, Rest> restDAO;

    @Autowired
    @Qualifier("restDAOBean")
    public void setRestDAO(BaseDAO<Long, Rest> restDAO) {
        this.restDAO = restDAO;
    }


    @Override
    @Transactional
    public void save(Rest rest) {
        restDAO.save(rest);
    }

    @Override
    @Transactional
    public void update(Rest rest) {
        restDAO.update(rest);
    }

    @Override
    @Transactional
    public void delete(Rest rest) {
        restDAO.delete(rest);
    }

    @Override
    @Transactional
    public Rest getById(Long id) {
        return restDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Rest> getAll() {
        return restDAO.getAll();
    }
}
