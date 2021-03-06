package by.maiseyeu.webkassa.service.impl;

import by.maiseyeu.webkassa.model.Role;
import by.maiseyeu.webkassa.repository.RoleRepository;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements ServiceDAO<Long, Role> {

//    private BaseDAO <Long,Role> roleDAO;
//
//    @Autowired
//    @Qualifier("roleDAOBean")
//    public void setRoleDAO(BaseDAO<Long,Role> roleDAO) {
//        this.roleDAO = roleDAO;
//    }

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    //    @Override
//    public void save(Role role) {
//
//    }
//
//    @Override
//    public void update(Role role) {
//
//    }
//
//    @Override
//    public void delete(Role role) {
//
//    }
//
//    @Override
//    @Transactional
//    public Role getById(Long id) {
//        return roleDAO.getById(id);
//    }
//
//    @Override
//    public List<Role> getAll() {
//        return null;
//    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(Role role) {

    }

    @Override
 //   @Transactional
    public Role getById(Long id) {
        return roleRepository.getById(id);
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
