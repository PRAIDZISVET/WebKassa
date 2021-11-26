package by.maiseyeu.webkassa.service;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rate;

public interface RateServiceDAO extends ServiceDAO <Long, Rate>{

 //  Rate getByCurrCodes (Integer currIn, Integer currOut);
 Rate getRateByCurrInIsAndCurrOutIs (Currency currIn, Currency currOut);
}
