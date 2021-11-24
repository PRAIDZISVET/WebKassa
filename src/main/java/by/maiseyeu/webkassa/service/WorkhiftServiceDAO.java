package by.maiseyeu.webkassa.service;

import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workshift;

import java.util.Optional;

public interface WorkhiftServiceDAO extends ServiceDAO<Long, Workshift>{

    Workshift saveAndReturnObj (Workshift workshift);

    Workshift findByUser(User user);
}
