package by.maiseyeu.webkassa.repository.impl;

import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.repository.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    private static final AtomicLong AUTO_ID = new AtomicLong(0);
//    private static Map<Long, User> userMap = new HashMap<>();
//
//    static {
//
//        User user1 = new User();
//        user1.setId(AUTO_ID.getAndIncrement());
//        user1.setName("Petr Petrov");
//        user1.setLogin("Petr86");
//        user1.setPassword("1111");
//        userMap.put(user1.getId(), user1);
//
//        User user2 = new User();
//        user2.setId(AUTO_ID.getAndIncrement());
//        user2.setName("Olga");
//        user2.setLogin("Olga86");
//        user2.setPassword("2222");
//        userMap.put(user2.getId(), user2);
//
//    }

//    @Override
//    public void save(User user) {
//        user.setId(AUTO_ID.getAndIncrement());
//        userMap.put(user.getId(), user);
//    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

//    @Override
//    public void update(User user) {
//        userMap.put(user.getId(), user);
//    }

    @Override
    public void update (User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

//    @Override
//    public void delete(User user) {
//        userMap.remove(user.getId());
//    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

//    @Override
//    public User getById(Long id) {
//        return userMap.get(id);
//    }

    @Override
    public User getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, login);
        Query<User> query = session.createQuery("SELECT u from User u where login=:userLogin");
//        return session.createQuery("select e from User e where e.login = :login",User.class);
        query.setParameter("userLogin",login);
//        query.executeUpdate();
//               session.createQuery("select e from Employee e where e.firstName = :firstName", Employee.class)
        return query.uniqueResult();
// Query<Cinema> query = session.createQuery("delete from Cinema where id=:cinemaId");
//        query.setParameter("cinemaId",id);
//        query.executeUpdate();

    }

//    @Override
//    public List<User> getAll() {
//        return new ArrayList<>(userMap.values());
//    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").list();
    }
}
