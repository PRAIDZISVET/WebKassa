package by.maiseyeu.webkassa.controller;


import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/workplace")
public class WorkplaceController {

    private ServiceDAO<Long, Workplace> workplaceService;

    @Autowired
    @Qualifier("workplaceService")
    public void setWorkplaceService(ServiceDAO<Long, Workplace> workplaceService) {
        this.workplaceService = workplaceService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView workplaceList() {
        List<Workplace> workplaces = workplaceService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workplace/wpList");
        modelAndView.addObject("workplaceList", workplaces);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addWorkplace() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workplace/wpEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addWorkplace(@ModelAttribute("workplace") Workplace workplace) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/workplace/list");
        workplaceService.save(workplace);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getWorkplaceEditPage(@PathVariable("id") Long id) {
        Workplace workplace = workplaceService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("workplace/wpEdit");
        modelAndView.addObject("workplace", workplace);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView workplaceEdit(@ModelAttribute("workplace") Workplace workplace) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/workplace/list");
        workplaceService.update(workplace);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteWorkplace(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/workplace/list");
        Workplace workplace = workplaceService.getById(id);;
        workplaceService.delete(workplace);
        return modelAndView;
    }
}
