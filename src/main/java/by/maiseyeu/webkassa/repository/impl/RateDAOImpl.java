package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Rate;
import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.RateDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository ("rateDAOBean")
public class RateDAOImpl implements RateDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Rate rate) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(rate);
    }

    @Override
    public void update(Rate rate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(rate);
    }

    @Override
    public void delete(Rate rate) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(rate);
    }

    @Override
    public Rate getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Rate.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Rate> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Rate").list();
    }

    @Override
    public Rate getByCurrCodes(Integer currIn, Integer currOut) {
        Session session = sessionFactory.getCurrentSession();
        Query<Rate> query = session.createQuery("SELECT u from Rate u where login=:userLogin");
        query.setParameter("curr_in_id",currIn);
        query.setParameter("curr_out_id",currOut);
        return query.uniqueResult();
    }
}
