package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Oper;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("operService")
public class OperServiceImpl implements ServiceDAO<Long,Oper> {

    private BaseDAO<Long, Oper> operDAO;

    @Autowired
    @Qualifier("operDAOBean")
    public void setOperDAO(BaseDAO<Long, Oper> operDAO) {
        this.operDAO = operDAO;
    }

    @Override
    @Transactional
    public void save(Oper oper) {
        operDAO.save(oper);
    }

    @Override
    @Transactional
    public void update(Oper oper) {
        operDAO.update(oper);
    }

    @Override
    @Transactional
    public void delete(Oper oper) {

    }

    @Override
    @Transactional
    public Oper getById(Long id) {
        return operDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Oper> getAll() {
        return operDAO.getAll();
    }
}
