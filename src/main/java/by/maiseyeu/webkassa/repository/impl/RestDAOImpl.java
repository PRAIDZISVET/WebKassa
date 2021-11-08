package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("restDAOBean")
public class RestDAOImpl implements BaseDAO<Long, Rest> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Rest rest) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(rest);
    }

    @Override
    public void update(Rest rest) {
        Session session = sessionFactory.getCurrentSession();
        session.update(rest);
    }

    @Override
    public void delete(Rest rest) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(rest);
    }

    @Override
    public Rest getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Rest.class, id);
    }

    @Override
        @SuppressWarnings("unchecked")
        public List<Rest> getAll() {
            Session session = sessionFactory.getCurrentSession();
            return session.createQuery("from Rest").list();
    }
}
