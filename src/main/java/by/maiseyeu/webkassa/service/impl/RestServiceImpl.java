package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.repository.RateRepository;
import by.maiseyeu.webkassa.repository.RestRepository;
import by.maiseyeu.webkassa.service.RestServiceDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("restService")
public class RestServiceImpl implements RestServiceDAO {

//    private BaseDAO<Long, Rest> restDAO;
//
//    @Autowired
//    @Qualifier("restDAOBean")
//    public void setRestDAO(BaseDAO<Long, Rest> restDAO) {
//        this.restDAO = restDAO;
//    }

    private RestRepository restRepository;

    @Autowired
    public void setRestRepository(RestRepository restRepository) {
        this.restRepository = restRepository;
    }

    //    @Override
//    @Transactional
//    public void save(Rest rest) {
//        restDAO.save(rest);
//    }
//
//    @Override
//    @Transactional
//    public void update(Rest rest) {
//        restDAO.update(rest);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Rest rest) {
//        restDAO.delete(rest);
//    }
//
//    @Override
//    @Transactional
//    public Rest getById(Long id) {
//        return restDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Rest> getAll() {
//        return restDAO.getAll();
//    }

    @Override
    @Transactional
    public void save(Rest rest) {
        restRepository.saveAndFlush(rest);
    }

    @Override
    @Transactional
    public void update(Rest rest) {
        restRepository.saveAndFlush(rest);
    }

    @Override
    public void delete(Rest rest) {
        restRepository.delete(rest);
    }

    @Override
    @Transactional
    public Rest getById(Long id) {
        return restRepository.getById(id);
    }

    @Override
    @Transactional
    public List<Rest> getAll() {
        return restRepository.findAll();
    }


    @Override
    public Rest getRestByCurrencyAndWorkshift(Currency currency, Workshift workshift) {
        return restRepository.getRestByCurrencyAndWorkshift(currency,workshift);
    }
}
