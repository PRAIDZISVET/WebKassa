package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Role;
import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.service.ServiceDAO;
import by.maiseyeu.webkassa.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

//    ServiceDAO userService = new UserSericeImpl();

    private UserServiceDAO  userService;
    private ServiceDAO<Long,Role> roleService;

    @Autowired
    public void setUserService(UserServiceDAO userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(ServiceDAO<Long, Role> roleService) {
        this.roleService = roleService;
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
        ModelAndView modelAndView = new ModelAndView();
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
                                 @RequestParam("role_id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        user.setRole(roleService.getById(id));
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
                                @RequestParam("role_id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        user.setRole(roleService.getById(id));
        userService.save(user);
        return modelAndView;
    }

    @RequestMapping(value="/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteFilm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/userList");
        User user = (User) userService.getById(id);
        userService.delete(user);
        return modelAndView;
    }
}
