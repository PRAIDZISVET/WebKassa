package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workshift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestRepository extends JpaRepository<Rest, Long> {

    Rest getRestByCurrencyAndWorkshift(Currency currency, Workshift workshift);
}
