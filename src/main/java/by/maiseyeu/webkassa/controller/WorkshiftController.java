package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/workshift")
public class WorkshiftController {

    private ServiceDAO<Long, Workshift> workshiftService;
    private ServiceDAO<Long, User> userService;
    private ServiceDAO<Long, Workplace> workplaceService;

    @Autowired
    @Qualifier("workshiftService")
    public void setWorkshiftService(ServiceDAO<Long, Workshift> workshiftService) {
        this.workshiftService = workshiftService;
    }
    @Autowired
    @Qualifier("userService")
    public void setUserService(ServiceDAO<Long, User> userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier("workplaceService")
    public void setWorkplaceService(ServiceDAO<Long, Workplace> workplaceService) {
        this.workplaceService = workplaceService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView workshiftList() {
        List<Workshift> workshifts = workshiftService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workplace/wshList");
        modelAndView.addObject("workshiftList", workshifts);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addWorkshift() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workplace/wshEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addWorkshift(@ModelAttribute("workshift") Workshift workshift,
                                     @RequestParam("user_id") Long user_id,
                                     @RequestParam("workplace_id") Long workplace_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/workshift/list");
        workshift.setUser(userService.getById(user_id));
        workshift.setWorkplace(workplaceService.getById(workplace_id));
        workshift.setOpenDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        workshiftService.save(workshift);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getWorkshiftEditPage(@PathVariable("id") Long id) {
        Workshift workshift = workshiftService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workplace/wshEdit");
        modelAndView.addObject("workshift", workshift);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView workshiftEdit(@ModelAttribute("workshift") Workshift workshift,
                                      @RequestParam("user_id") Long user_id,
                                      @RequestParam("workplace_id") Long workplace_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/workshift/list");
        workshift.setUser(userService.getById(user_id));
        workshift.setWorkplace(workplaceService.getById(workplace_id));
        workshift.setOpenDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        workshiftService.update(workshift);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteWorkshift(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/workshift/list");
        Workshift workshift = workshiftService.getById(id);;
        workshiftService.delete(workshift);
        return modelAndView;
    }
}
