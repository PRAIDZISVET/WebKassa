package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceServiceImpl implements ServiceDAO<Long, Workplace> {

    private BaseDAO<Long,Workplace> workplaceDAO;


    @Autowired
    @Qualifier("workplaceDAOBean")
    public void setWorkplaceDAO(BaseDAO<Long, Workplace> workplaceDAO) {
        this.workplaceDAO = workplaceDAO;
    }

    @Override
    public void save(Workplace workplace) {
        workplaceDAO.save(workplace);
    }

    @Override
    public void update(Workplace workplace) {

    }

    @Override
    public void delete(Workplace workplace) {

    }

    @Override
    public Workplace getById(Long id) {
        return null;
    }

    @Override
    public List<Workplace> getAll() {
        return null;
    }
}
