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
    public void update(Workplace workplace) {

    }

    @Override
    public void delete(Workplace workplace) {

    }

    @Override
    public Workplace getById(Long id) {
        return null;
    }

    @Override
    public List<Workplace> getAll() {
        return null;
    }
}
