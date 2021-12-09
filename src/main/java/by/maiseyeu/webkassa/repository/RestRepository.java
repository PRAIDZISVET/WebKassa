package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workshift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestRepository extends JpaRepository<Rest, Long> {

    Optional<Rest> getRestByCurrencyAndWorkshift(Currency currency, Workshift workshift);

    Optional<Rest> getRestByCurrency(Currency currency);

    List<Rest> findAllByWorkshift(Workshift workshift);
}
