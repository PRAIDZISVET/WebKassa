package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.repository.BaseDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("workshiftService")
public class WorkshiftServiceImpl implements ServiceDAO <Long, Workshift> {

    private BaseDAO<Long, Workshift> workshiftDAO;


    @Autowired
    @Qualifier("workshiftDAOBean")
    public void setWorkshiftDAO(BaseDAO<Long, Workshift> workshiftDAO) {
        this.workshiftDAO = workshiftDAO;
    }

    @Override
    @Transactional
    public void save(Workshift workshift) {
     workshiftDAO.save(workshift);
    }

    @Override
    @Transactional
    public void update(Workshift workshift) {
        workshiftDAO.update(workshift);
    }

    @Override
    @Transactional
    public void delete(Workshift workshift) {
workshiftDAO.delete(workshift);
    }

    @Override
    @Transactional
    public Workshift getById(Long id) {
        return workshiftDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Workshift> getAll() {
        return workshiftDAO.getAll();
    }
}
