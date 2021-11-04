package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Rate;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.service.RateServiceDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rate")
public class RateController {

    private RateServiceDAO rateService;

    @Autowired
    @Qualifier("rateService")
    public void setRateService(RateServiceDAO rateService) {
        this.rateService = rateService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView rateList() {
        List<Rate> rates = rateService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rateList");
        modelAndView.addObject("rateList", rates);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addRate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rateEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRate(@ModelAttribute("rate") Rate rate) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rate/list");
        rateService.save(rate);
        return modelAndView;
    }
}
