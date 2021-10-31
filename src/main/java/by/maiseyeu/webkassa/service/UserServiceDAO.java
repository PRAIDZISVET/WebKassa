package by.maiseyeu.webkassa.service;

import by.maiseyeu.webkassa.model.User;

public interface UserServiceDAO extends ServiceDAO<Long, User>{

    User getByLogin (String login);
}
