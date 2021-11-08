package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Currency;
import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.service.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rest")
public class RestController {

    private ServiceDAO<Long, Rest> restService;
    private ServiceDAO<Long, Currency> currencyService;
    private ServiceDAO<Long, Workshift> workshiftService;

    @Autowired
    @Qualifier("restService")
    public void setRestService(ServiceDAO<Long, Rest> restService) {
        this.restService = restService;
    }

    @Autowired
    @Qualifier("currencyService")
    public void setCurrencyService(ServiceDAO<Long, Currency> currencyService) {
        this.currencyService = currencyService;
    }

    @Autowired
    @Qualifier("workshiftService")
    public void setWorkshiftService(ServiceDAO<Long, Workshift> workshiftService) {
        this.workshiftService = workshiftService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView restList() {
        List<Rest> rests = restService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("balance/restList");
        modelAndView.addObject("restList", rests);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addRest() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("balance/restEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRest(@ModelAttribute("rest") Rest rest,
                                @RequestParam("curr_id") Long curr_id,
                                @RequestParam("workshift_id") Long workshift_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rest/list");
        rest.setCurrency(currencyService.getById(curr_id));
        rest.setWorkshift(workshiftService.getById(workshift_id));
        restService.save(rest);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getRestEditPage(@PathVariable("id") Long id) {
        Rest rest = restService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("balance/restEdit");
        modelAndView.addObject("rest", rest);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView resteEdit(@ModelAttribute("rest") Rest rest,
                                  @RequestParam("curr_id") Long curr_id,
                                  @RequestParam("workshift_id") Long workshift_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rest/list");
        rest.setCurrency(currencyService.getById(curr_id));
        rest.setWorkshift(workshiftService.getById(workshift_id));
        restService.update(rest);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView restWorkplace(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rest/list");
        Rest rest = restService.getById(id);;
        restService.delete(rest);
        return modelAndView;
    }
}
