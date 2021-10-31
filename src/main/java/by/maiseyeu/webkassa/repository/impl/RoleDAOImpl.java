package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.Role;
import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.repository.RoleDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(Role role) {

    }

//    @Override
//    public Role getById(Long id) {
//        return null;
//    }

    @Override
    public Role getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
