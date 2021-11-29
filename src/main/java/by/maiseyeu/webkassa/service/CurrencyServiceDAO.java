package by.maiseyeu.webkassa.service;

import by.maiseyeu.webkassa.model.Currency;

public interface CurrencyServiceDAO extends ServiceDAO<Long, Currency>{
    Currency getCurrencyByName (String currName);
    Currency getCurrencyByIso (String iso);
//    List<Currency> getAllByActiveIsTrue();
}
