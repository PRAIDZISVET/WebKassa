package by.maiseyeu.webkassa.service;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workshift;

import java.util.List;
import java.util.Optional;

public interface RestServiceDAO extends ServiceDAO<Long,Rest> {

    Rest getRestByCurrencyAndWorkshift(Currency currency, Workshift workshift);

    Rest saveAndReturnObj (Rest rest);

    Rest getRestByCurrency (Currency currency);

    List<Rest> findAllByWorkshift(Workshift workshift);
}
