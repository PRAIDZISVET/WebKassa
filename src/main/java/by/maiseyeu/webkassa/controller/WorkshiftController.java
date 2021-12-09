package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.Rest;
import by.maiseyeu.webkassa.model.User;
import by.maiseyeu.webkassa.model.Workplace;
import by.maiseyeu.webkassa.model.Workshift;
import by.maiseyeu.webkassa.service.RateServiceDAO;
import by.maiseyeu.webkassa.service.RestServiceDAO;
import by.maiseyeu.webkassa.service.ServiceDAO;
import by.maiseyeu.webkassa.service.WorkhiftServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@SessionAttributes({"workshift","message"})
@RequestMapping("/workshift")
public class WorkshiftController {

    private WorkhiftServiceDAO workshiftService;
    private ServiceDAO<Long, User> userService;
    private ServiceDAO<Long, Workplace> workplaceService;
    private RestServiceDAO restService;

    @Autowired
    @Qualifier("workshiftService")
    public void setWorkshiftService(WorkhiftServiceDAO workshiftService) {
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

    @Autowired
    @Qualifier("restService")
    public void setRestService(RestServiceDAO restService) {
        this.restService = restService;
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

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public ModelAndView openWorkshift(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cashier");
        User user = (User) session.getAttribute("user");
        Workshift workshift = new Workshift();
            workshift.setUser(user);
            workshift.setWorkplace(user.getWorkplace());
            workshift.setOpenDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
            Workshift checkWorkshift = workshiftService.findByUser(user);
            if (checkWorkshift==null){
                Workshift workshiftDB = workshiftService.saveAndReturnObj(workshift);
                modelAndView.addObject("workshift",workshiftDB);
//                Long prevWorkshiftId = workshiftDB.getId() - 1;
                List<Rest> restsList = restService.getAll();
                for (Rest item: restsList) {
                    item.setWorkshift(workshiftDB);
                    restService.update(item);
                }
            } else {
                String message = "Найдена открытая смена № " + checkWorkshift.getId()+ " ,открыта " + checkWorkshift.getOpenDateTime();
                modelAndView.addObject("message", message);
            }

 //       }
        return modelAndView;
    }

    @RequestMapping(value = "/close", method = RequestMethod.GET)
    public ModelAndView closeWorkshift(HttpSession session, SessionStatus status) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cashier");
        User user = (User) session.getAttribute("user");
        Workshift checkWorkshift = workshiftService.findByUser(user);
        if (checkWorkshift!=null){
            checkWorkshift.setCloseDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
            workshiftService.update(checkWorkshift);
//            Workshift workshift = workshiftService.findByUser(user);
//           modelAndView.addObject("workshift",workshift);

//            session.removeAttribute("workshift");
        }
//        Workshift workshift=(Workshift) session.getAttribute("workshift");
 ////       Workshift workshift=workshiftService.getById(user.getWorkplace().getWorkshifts().get(0).getId());
//        User user = (User) session.getAttribute("user");
//        workshift.setUser(user);
//        workshift.
//        workshift.setWorkplace(workplaceService.getById(user.getWorkplace().getId()));
//        workshift.setCloseDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
//        workshiftService.update(workshift);
        status.setComplete();
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
