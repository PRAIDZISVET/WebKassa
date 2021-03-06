package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.repository.CurrencyRepository;
import by.maiseyeu.webkassa.service.CurrencyServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyServiceDAO {

//    private BaseDAO<Long,Currency> currencyDAO;
//
//    @Autowired
//    @Qualifier("currencyDAOBean")
//    public void setCurrencyDAO(BaseDAO<Long, Currency> currencyDAO) {
//        this.currencyDAO = currencyDAO;
//    }

    private CurrencyRepository currencyRepository;

    @Autowired
    public void setCurrencyRepository(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

//    @Override
//    @Transactional
//    public void save(Currency currency) {
//        currencyDAO.save(currency);
//    }
//
//    @Override
//    @Transactional
//    public void update(Currency currency) {
//        currencyDAO.update(currency);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Currency currency) {
//        currencyDAO.delete(currency);
//    }
//
//    @Override
//    @Transactional
//    public Currency getById(Long id) {
//        return currencyDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Currency> getAll() {
//        return currencyDAO.getAll();
//    }

    @Override
    @Transactional
    public void save(Currency currency) {
        currencyRepository.saveAndFlush(currency);
    }

    @Override
    @Transactional
    public void update(Currency currency) {
        currencyRepository.saveAndFlush(currency);
    }

    @Override
    public void delete(Currency currency) {
        currencyRepository.delete(currency);
    }

    @Override
    @Transactional
    public Currency getById(Long id) {

        return currencyRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }


    @Override
    @Transactional
    public Currency getCurrencyByName(String currName) {
        return currencyRepository.getCurrencyByName(currName);
    }

    @Override
    @Transactional
    public Currency getCurrencyByIso(String iso) {
        return currencyRepository.getCurrencyByIso(iso);
    }

//    @Override
//    @Transactional
//    public List<Currency> getAllByActiveIsTrue() {
//        return currencyRepository.getAllByActiveIsTrue();
//    }
}
