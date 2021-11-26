package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rate;
import by.maiseyeu.webkassa.repository.RateDAO;
import by.maiseyeu.webkassa.repository.RateRepository;
import by.maiseyeu.webkassa.service.RateServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service ("rateService")
public class RateServiceImpl implements RateServiceDAO {

//    private RateDAO rateDAO;
//
//    @Autowired
//    @Qualifier("rateDAOBean")
//    public void setRateDAO(RateDAO rateDAO) {
//        this.rateDAO = rateDAO;
//    }

    private RateRepository rateRepository;

    @Autowired
    public void setRateRepository(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

//    @Override
//    @Transactional
//    public void save(Rate rate) {
//        rateDAO.save(rate);
//    }
//
//    @Override
//    @Transactional
//    public void update(Rate rate) {
//        rateDAO.update(rate);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Rate rate) {
//        rateDAO.delete(rate);
//    }
//
//    @Override
//    @Transactional
//    public Rate getById(Long id) {
//        return rateDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Rate> getAll() {
//        return rateDAO.getAll();
//    }
//
//    @Override
//    @Transactional
//    public Rate getByCurrCodes(Integer currIn, Integer currOut) {
//        return rateDAO.getByCurrCodes(currIn,currOut);
//    }

    @Override
//    @Transactional
    public void save(Rate rate) {
        rateRepository.saveAndFlush(rate);
    }

    @Override
 //   @Transactional
    public void update(Rate rate) {
        rateRepository.saveAndFlush(rate);
    }

    @Override
  //  @Transactional
    public void delete(Rate rate) {
        rateRepository.delete(rate);
    }

    @Override
 //   @Transactional
    public Rate getById(Long id) {
        return rateRepository.getById(id);
    }

    @Override
//    @Transactional
    public List<Rate> getAll() {
        return rateRepository.findAll();
    }

    @Override
    public Rate getRateByCurrInIsAndCurrOutIs(Currency currIn, Currency currOut) {
        return rateRepository.getRateByCurrInIsAndCurrOutIs(currIn,currOut);
    }

//    @Override
 ////   @Transactional
 //   public Rate getByCurrCodes(Integer currIn, Integer currOut) {
 //       return rateRepository.getByCurrInAndCurrOut(currIn,currOut);
 //   }
}
