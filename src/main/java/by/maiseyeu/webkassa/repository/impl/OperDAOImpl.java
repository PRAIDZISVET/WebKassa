package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Oper;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("operDAOBean")
public class OperDAOImpl implements BaseDAO<Long, Oper> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Oper oper) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(oper);
    }

    @Override
    public void update(Oper oper) {
        Session session = sessionFactory.getCurrentSession();
        session.update(oper);
    }

    @Override
    public void delete(Oper oper) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(oper);
    }

    @Override
    public Oper getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Oper.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Oper> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Oper").list();
    }
}
