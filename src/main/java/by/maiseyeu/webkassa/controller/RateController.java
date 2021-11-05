package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rate;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.service.RateServiceDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rate")
public class RateController {

    private RateServiceDAO rateService;
    private ServiceDAO<Long, Currency> currencyService;

    @Autowired
    @Qualifier("rateService")
    public void setRateService(RateServiceDAO rateService) {
        this.rateService = rateService;
    }

    @Autowired
    @Qualifier("currencyService")
    public void setCurrencyService(ServiceDAO<Long, Currency> currencyService) {
        this.currencyService = currencyService;
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
    public ModelAndView addRate(@ModelAttribute("rate") Rate rate,
                                @RequestParam ("currin_id") Long currIn_id,
                                @RequestParam("currout_id") Long currOut_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rate/list");
        rate.setCurrIn(currencyService.getById(currIn_id));
        rate.setCurrOut(currencyService.getById(currOut_id));
        rateService.save(rate);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getRateEditPage(@PathVariable("id") Long id) {
        Rate rate = rateService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rateEdit");
        modelAndView.addObject("rate", rate);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView rateEdit(@ModelAttribute("rate") Rate rate,
                                 @RequestParam ("currin_id") Long currIn_id,
                                 @RequestParam("currout_id") Long currOut_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rate/list");
        rate.setCurrIn(currencyService.getById(currIn_id));
        rate.setCurrOut(currencyService.getById(currOut_id));
        rateService.update(rate);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRate(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rate/list");
        Rate rate = rateService.getById(id);;
        rateService.delete(rate);
        return modelAndView;
    }
}
