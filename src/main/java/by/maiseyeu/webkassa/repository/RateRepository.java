package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Long> {
//    Rate getByCurrIn (Integer currIn, Integer currOut);
}
