package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.repository.UserDAO;
import by.maiseyeu.webkassa.repository.impl.UserDAOImpl;
import by.maiseyeu.webkassa.service.ServiceDAO;
import by.maiseyeu.webkassa.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
public class UserSericeImpl implements UserServiceDAO {

//    private UserDAO userDAO = new UserDAOImpl();

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    @Transactional
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    @Transactional
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }
}
