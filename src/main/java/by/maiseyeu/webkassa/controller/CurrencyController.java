package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Workplace;
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
@RequestMapping("/currency")
public class CurrencyController {

    private ServiceDAO<Long, Currency> currencyService;

    @Autowired
    @Qualifier("currencyService")
    public void setCurrencyService(ServiceDAO<Long, Currency> currencyService) {
        this.currencyService = currencyService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView currencyList() {
        List<Currency> currencies = currencyService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("balance/currList");
        modelAndView.addObject("currencyList", currencies);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addCurrency() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("balance/currEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addCurrency(@ModelAttribute("currency") Currency currency) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/currency/list");
        currencyService.save(currency);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getCurrencyEditPage(@PathVariable("id") Long id) {
        Currency currency = currencyService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("balance/currEdit");
        modelAndView.addObject("currency", currency);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView currencyEdit(@ModelAttribute("currency") Currency currency) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/currency/list");
        currencyService.update(currency);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCurrency(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/currency/list");
        Currency currency = currencyService.getById(id);;
        currencyService.delete(currency);
        return modelAndView;
    }
}
