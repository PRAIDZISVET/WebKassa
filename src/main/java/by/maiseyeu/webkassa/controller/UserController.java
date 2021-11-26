package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.*;
import by.maiseyeu.webkassa.service.OperServiceDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import by.maiseyeu.webkassa.service.UserServiceDAO;
import by.maiseyeu.webkassa.service.WorkhiftServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes({"user","workshift"})
public class UserController {


    private UserServiceDAO  userService;
    private ServiceDAO<Long,Role> roleService;
    private ServiceDAO<Long, Workplace> workplaceService;
    private WorkhiftServiceDAO workshiftService;
    private OperServiceDAO operService;

    @Autowired
    @Qualifier("userService")
    public void setUserService(UserServiceDAO userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("roleService")
    public void setRoleService(ServiceDAO<Long, Role> roleService) {
        this.roleService = roleService;
    }

    @Autowired
    @Qualifier("workplaceService")
    public void setWorkplaceService(ServiceDAO<Long, Workplace> workplaceService) {
        this.workplaceService = workplaceService;
    }
    @Autowired
    @Qualifier("workshiftService")
    public void setWorkshiftService(WorkhiftServiceDAO workshiftService) {
        this.workshiftService = workshiftService;
    }

    @Autowired
    @Qualifier("operService")
    public void setOperService(OperServiceDAO operService) {
        this.operService = operService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView toLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("login") String login,
                              @RequestParam("password") String password) {
        User user = userService.getByLogin(login);
        Workshift workshift = workshiftService.findByUser(user);
 //       List<Oper> operList = operService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.addObject("workshift",workshift);
//        Oper oper = operList.get(0);
 //       modelAndView.addObject("operList",operList);
//        modelAndView.addObject("oper",oper);

        if (user != null ) {
            if (user.getPassword().equals(password)) {
                if (user.getRole().getId() == 1) {
                    modelAndView.setViewName("redirect:/admin");
                } else if (user.getRole().getId() == 2) {
                    modelAndView.setViewName("redirect:/cashier");
                }
            } else {
                modelAndView.setViewName("error/wrongPass");
            }
        } else {
            modelAndView.setViewName("error/unregisted");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/adminMain");
        return modelAndView;
    }

    @RequestMapping(value = "/cashier", method = RequestMethod.GET)
    public ModelAndView cashierPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Oper> operList = operService.getAll();
        modelAndView.addObject("operList",operList);
        modelAndView.setViewName("user/cashierMain");
        return modelAndView;
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView getUserEditPage(@PathVariable("id") Long id) {
        User user = (User) userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userEdit");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public ModelAndView userEdit(@ModelAttribute("user") User user,
                                 @RequestParam("role_id") Long role_id,
                                 @RequestParam("workplace_id") Long workplace_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        user.setWorkplace(workplaceService.getById(workplace_id));
        user.setRole(roleService.getById(role_id));
        userService.update(user);
        return modelAndView;
    }

    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList() {
        List<User> users = userService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userList");
        modelAndView.addObject("userList", users);
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user,
                                @RequestParam("role_id") Long role_id,
                                @RequestParam("workplace_id") Long workplace_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        user.setRole(roleService.getById(role_id));
        user.setWorkplace(workplaceService.getById(workplace_id));
        userService.save(user);
        return modelAndView;
    }

    @RequestMapping(value="/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        User user = userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }
}
