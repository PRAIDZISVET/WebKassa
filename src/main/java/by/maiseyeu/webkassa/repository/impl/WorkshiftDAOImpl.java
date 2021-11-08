package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("workshiftDAOBean")
public class WorkshiftDAOImpl implements BaseDAO<Long, Workshift> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Workshift workshift) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(workshift);
    }

    @Override
    public void update(Workshift workshift) {
        Session session = sessionFactory.getCurrentSession();
        session.update(workshift);
    }

    @Override
    public void delete(Workshift workshift) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(workshift);
    }

    @Override
    public Workshift getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Workshift.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Workshift> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Workshift").list();
    }
}
