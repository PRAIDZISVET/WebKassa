package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workshift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkshiftRepository extends JpaRepository<Workshift, Long> {

   Optional<Workshift> findByUserAndCloseDateTimeNull(User user);
}
