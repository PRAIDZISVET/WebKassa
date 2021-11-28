package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    Currency getCurrencyByName (String currName);
    Currency getCurrencyByIso (String iso);
}
