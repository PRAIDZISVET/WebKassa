package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.User;

public interface UserDAO extends BaseDAO<Long,User>{

    User getByLogin(String login);
}
