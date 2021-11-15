package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Receipt;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.repository.ReceiptRepository;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("receiptService")
public class ReceiptServiceImpl implements ServiceDAO<Long, Receipt> {

//    private BaseDAO<Long, Receipt> receiptDAO;
//
//    @Autowired
//    @Qualifier("receiptDAOBean")
//    public void setReceiptDAO(BaseDAO<Long, Receipt> receiptDAO) {
//        this.receiptDAO = receiptDAO;
//    }

    private ReceiptRepository receiptRepository;

    @Autowired
    public void setReceiptRepository(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    //    @Override
//    @Transactional
//    public void save(Receipt receipt) {
//        receiptDAO.save(receipt);
//    }
//
//    @Override
//    @Transactional
//    public void update(Receipt receipt) {
//        receiptDAO.update(receipt);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Receipt receipt) {
//        receiptDAO.delete(receipt);
//    }
//
//    @Override
//    @Transactional
//    public Receipt getById(Long id) {
//        return receiptDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Receipt> getAll() {
//        return receiptDAO.getAll();
//    }

    @Override
 //   @Transactional
    public void save(Receipt receipt) {
        receiptRepository.saveAndFlush(receipt);
    }

    @Override
 //   @Transactional
    public void update(Receipt receipt) {
        receiptRepository.saveAndFlush(receipt);
    }

    @Override
 //   @Transactional
    public void delete(Receipt receipt) {
        receiptRepository.delete(receipt);
    }

    @Override
 //   @Transactional
    public Receipt getById(Long id) {
        return receiptRepository.getById(id);
    }

    @Override
 //   @Transactional
    public List<Receipt> getAll() {
        return receiptRepository.findAll();
    }
}
