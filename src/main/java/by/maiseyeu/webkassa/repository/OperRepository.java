package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Oper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperRepository extends JpaRepository<Oper, Long> {

//    List<Oper> getAllByActiveTrue();
}
