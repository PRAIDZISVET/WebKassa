package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("workplaceDAOBean")
public class WorkplaceDAOImpl implements BaseDAO<Long, Workplace> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Workplace workplace) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(workplace);
    }

    @Override
    public void update (Workplace workplace) {
        Session session = sessionFactory.getCurrentSession();
        session.update(workplace);
    }

    @Override
    public void delete(Workplace workplace) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(workplace);
    }

    @Override
    public Workplace getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Workplace.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Workplace> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Workplace").list();
    }
}
