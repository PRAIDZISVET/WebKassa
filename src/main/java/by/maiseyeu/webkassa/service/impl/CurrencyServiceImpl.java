package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("currencyService")
public class CurrencyServiceImpl implements ServiceDAO<Long, Currency> {

    private BaseDAO<Long,Currency> currencyDAO;

    @Autowired
    @Qualifier("currencyDAOBean")
    public void setCurrencyDAO(BaseDAO<Long, Currency> currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Override
    @Transactional
    public void save(Currency currency) {
        currencyDAO.save(currency);
    }

    @Override
    @Transactional
    public void update(Currency currency) {
        currencyDAO.update(currency);
    }

    @Override
    @Transactional
    public void delete(Currency currency) {
        currencyDAO.delete(currency);
    }

    @Override
    @Transactional
    public Currency getById(Long id) {
        return currencyDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Currency> getAll() {
        return currencyDAO.getAll();
    }
}
