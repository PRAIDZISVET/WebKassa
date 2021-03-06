package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.repository.WorkshiftRepository;
import by.maiseyeu.webkassa.service.WorkhiftServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("workshiftService")
public class WorkshiftServiceImpl implements WorkhiftServiceDAO {

//    private BaseDAO<Long, Workshift> workshiftDAO;
//
//
//    @Autowired
//    @Qualifier("workshiftDAOBean")
//    public void setWorkshiftDAO(BaseDAO<Long, Workshift> workshiftDAO) {
//        this.workshiftDAO = workshiftDAO;
//    }

    private WorkshiftRepository workshiftRepository;

    @Autowired
    public void setWorkshiftRepository(WorkshiftRepository workshiftRepository) {
        this.workshiftRepository = workshiftRepository;
    }

    //    @Override
//    @Transactional
//    public void save(Workshift workshift) {
//     workshiftDAO.save(workshift);
//    }
//
//    @Override
//    @Transactional
//    public void update(Workshift workshift) {
//        workshiftDAO.update(workshift);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Workshift workshift) {
//workshiftDAO.delete(workshift);
//    }
//
//    @Override
//    @Transactional
//    public Workshift getById(Long id) {
//        return workshiftDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Workshift> getAll() {
//        return workshiftDAO.getAll();
//    }

    @Override
    @Transactional
    public void save(Workshift workshift) {
        workshiftRepository.saveAndFlush(workshift);
    }

    @Override
    @Transactional
    public Workshift saveAndReturnObj(Workshift workshift) {
        return workshiftRepository.save(workshift);
    }

    @Override
    @Transactional
    public Workshift findByUser(User user) {
        return workshiftRepository.findByUserAndCloseDateTimeNull(user).orElse(null);
    }

    @Override
    @Transactional
    public void update(Workshift workshift) {
        workshiftRepository.saveAndFlush(workshift);
    }

    @Override
    public void delete(Workshift workshift) {
        workshiftRepository.delete(workshift);
    }

    @Override
    @Transactional
    public Workshift getById(Long id) {

        return workshiftRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Workshift> getAll() {
        return workshiftRepository.findAll();
    }

}
