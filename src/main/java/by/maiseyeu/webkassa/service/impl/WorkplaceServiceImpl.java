package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.repository.WorkplaceRepository;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workplaceService")
public class WorkplaceServiceImpl implements ServiceDAO<Long, Workplace> {

//    private BaseDAO<Long,Workplace> workplaceDAO;
//
//
//    @Autowired
//    @Qualifier("workplaceDAOBean")
//    public void setWorkplaceDAO(BaseDAO<Long, Workplace> workplaceDAO) {
//        this.workplaceDAO = workplaceDAO;
//    }

    private WorkplaceRepository workplaceRepository;

    @Autowired
    public void setWorkplaceRepository(WorkplaceRepository workplaceRepository) {
        this.workplaceRepository = workplaceRepository;
    }

    //    @Override
//    @Transactional
//    public void save(Workplace workplace) {
//        workplaceDAO.save(workplace);
//    }
//
//    @Override
//    @Transactional
//    public void update(Workplace workplace) {
//    workplaceDAO.update(workplace);
//    }
//
//    @Override
//    @Transactional
//    public void delete(Workplace workplace) {
//    workplaceDAO.delete(workplace);
//    }
//
//    @Override
//    @Transactional
//    public Workplace getById(Long id) {
//      return workplaceDAO.getById(id);
//    }
//
//    @Override
//    @Transactional
//    public List<Workplace> getAll() {
//        return workplaceDAO.getAll();
//    }

    @Override
//    @Transactional
    public void save(Workplace workplace) {
        workplaceRepository.saveAndFlush(workplace);
    }

    @Override
//    @Transactional
    public void update(Workplace workplace) {
        workplaceRepository.saveAndFlush(workplace);
    }

    @Override
//    @Transactional
    public void delete(Workplace workplace) {
        workplaceRepository.delete(workplace);
    }

    @Override
 //   @Transactional
    public Workplace getById(Long id) {
        return workplaceRepository.getById(id);
    }

    @Override
 //   @Transactional
    public List<Workplace> getAll() {
        return workplaceRepository.findAll();
    }
}
