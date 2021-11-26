package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Oper;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.service.OperServiceDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/oper")
public class OperController {

    private OperServiceDAO operService;


    @Autowired
    @Qualifier("operService")
    public void setOperService(OperServiceDAO operService) {
        this.operService = operService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView operList() {
        List<Oper> opers = operService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/opList");
        modelAndView.addObject("operList", opers);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addOper() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/opEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addOper(@ModelAttribute("oper") Oper oper) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/oper/list");
        operService.save(oper);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getOperEditPage(@PathVariable("id") Long id) {
        Oper oper= operService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/opEdit");
        modelAndView.addObject("oper", oper);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView operEdit(@ModelAttribute("oper") Oper oper) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/oper/list");
        operService.update(oper);
        return modelAndView;
    }
}
