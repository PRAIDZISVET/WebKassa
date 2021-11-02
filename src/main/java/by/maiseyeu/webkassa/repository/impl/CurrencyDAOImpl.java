package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("currencyDAOBean")
public class CurrencyDAOImpl implements BaseDAO<Long, Currency> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(currency);
    }

    @Override
    public void update(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.update(currency);
    }

    @Override
    public void delete(Currency currency) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(currency);
    }

    @Override
    public Currency getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Currency.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Currency> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Currency ").list();
    }
}
