package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Rate;

public interface RateDAO extends BaseDAO<Long,Rate> {

    Rate getByCurrCodes (Integer currIn,Integer currOut);
}
