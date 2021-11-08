package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.*;
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
@RequestMapping("/receipt")
public class ReceiptController {

    private ServiceDAO<Long, Receipt> receiptService;
    private ServiceDAO<Long, Oper> operService;
    private ServiceDAO<Long, Workshift> workshiftService;
    private ServiceDAO<Long, Rate> rateService;

    @Autowired
    @Qualifier("receiptService")
    public void setReceiptService(ServiceDAO<Long, Receipt> receiptService) {
        this.receiptService = receiptService;
    }

    @Autowired
    @Qualifier("operService")
    public void setOperService(ServiceDAO<Long, Oper> operService) {
        this.operService = operService;
    }

    @Autowired
    @Qualifier("workshiftService")
    public void setWorkshiftService(ServiceDAO<Long, Workshift> workshiftService) {
        this.workshiftService = workshiftService;
    }

    @Autowired
    @Qualifier("rateService")
    public void setRateService(ServiceDAO<Long, Rate> rateService) {
        this.rateService = rateService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView receiptList() {
        List<Receipt> receipts = receiptService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rcptList");
        modelAndView.addObject("receiptList", receipts);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addReceipt() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rcptEdit");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addReceipt(@ModelAttribute("receipt") Receipt receipt,
                                   @RequestParam("oper_id") Long oper_id,
                                   @RequestParam("workshift_id") Long workshift_id,
                                   @RequestParam("rate_id") Long rate_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/receipt/list");
        receipt.setOper(operService.getById(oper_id));
        receipt.setWorkshift(workshiftService.getById(workshift_id));
        receipt.setRate(rateService.getById(rate_id));
        receipt.setDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        receiptService.save(receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getReceiptEditPage(@PathVariable("id") Long id) {
        Receipt receipt = receiptService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rcptEdit");
        modelAndView.addObject("receipt", receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView receiptEdit(@ModelAttribute("receipt") Receipt receipt,
                                    @RequestParam("oper_id") Long oper_id,
                                    @RequestParam("workshift_id") Long workshift_id,
                                    @RequestParam("rate_id") Long rate_id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/receipt/list");
        receipt.setOper(operService.getById(oper_id));
        receipt.setWorkshift(workshiftService.getById(workshift_id));
        receipt.setRate(rateService.getById(rate_id));
        receipt.setDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        receiptService.update(receipt);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteReceipt(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/receipt/list");
        Receipt receipt = receiptService.getById(id);;
        receiptService.delete(receipt);
        return modelAndView;
    }
}
