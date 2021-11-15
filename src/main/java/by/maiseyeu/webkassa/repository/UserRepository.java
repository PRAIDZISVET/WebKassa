package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByLogin(String login);
}
