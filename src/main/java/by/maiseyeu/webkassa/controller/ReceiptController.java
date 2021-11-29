package by.maiseyeu.webkassa.controller;

import by.maiseyeu.webkassa.model.*;
import by.maiseyeu.webkassa.service.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@SessionAttributes({"message"})
@RequestMapping("/receipt")
public class ReceiptController {

    private ServiceDAO<Long, Receipt> receiptService;
    private OperServiceDAO operService;
    private ServiceDAO<Long, Workshift> workshiftService;
    private RateServiceDAO rateService;
    private CurrencyServiceDAO currencyService;
    private RestServiceDAO restService;

    @Autowired
    @Qualifier("currencyService")
    public void setCurrencyService(CurrencyServiceDAO currencyService) {
        this.currencyService = currencyService;
    }

    @Autowired
    @Qualifier("receiptService")
    public void setReceiptService(ServiceDAO<Long, Receipt> receiptService) {
        this.receiptService = receiptService;
    }

    @Autowired
    @Qualifier("operService")
    public void setOperService(OperServiceDAO operService) {
        this.operService = operService;
    }

    @Autowired
    @Qualifier("workshiftService")
    public void setWorkshiftService(ServiceDAO<Long, Workshift> workshiftService) {
        this.workshiftService = workshiftService;
    }

    @Autowired
    @Qualifier("rateService")
    public void setRateService(RateServiceDAO rateService) {
        this.rateService = rateService;
    }

    @Autowired
    @Qualifier("restService")
    public void setRestService(RestServiceDAO restService) {
        this.restService = restService;
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

    @RequestMapping(value = "/make/{id}/{name}", method = RequestMethod.GET)
    public ModelAndView getReceiptEditPage(@PathVariable("id") Long operId,
                                           @PathVariable("name") String operName,
                                           HttpSession session) {
//        Receipt receipt = new Receipt();
        ModelAndView modelAndView = new ModelAndView();
        Workshift workshift = (Workshift) session.getAttribute("workshift");
        if (workshift==null){
            String message = "You can`t do opers! The workshift is not opened!";
            modelAndView.setViewName("redirect:/cashier");
            modelAndView.addObject("message", message);
        } else {
        List<Currency> currlist = currencyService.getAll();
        Oper oper = new Oper();
        oper.setId(operId);
        oper.setName(operName);
        //      receipt.setOper(operService.getById(operId));
        //       Rate rate = rateService.getById(id);
        modelAndView.setViewName("oper/receiptpage");
        //       modelAndView.addObject("receipt", receipt);
        ////       modelAndView.addObject("operId",operId);
        modelAndView.addObject("oper", oper);
        modelAndView.addObject("currList", currlist);
        }
//        modelAndView.addObject("rate",rate);
        return modelAndView;
    }


    @RequestMapping(value = "/make", method = RequestMethod.POST)
    public ModelAndView makeReceiptEdit(@ModelAttribute("receipt") Receipt receipt,
                                        @RequestParam("operId") Long operId,
                                        @RequestParam("curr") Long currId,
                                        @RequestParam("sum") BigDecimal sum,
                                        @RequestParam(value = "currEq", required = false) Long currEqId,
                                        HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
//        Currency currIn = currencyService.getCurrencyByName(currInName);
//        Currency currOut = currencyService.getCurrencyByName(currOutName);
        Oper oper = operService.getById(operId);
        Currency currIn; //= new Currency();
        Currency currOut; //= new Currency();
        Rate rate; //= new Rate();
        if (oper.isIncom()) {
            if (oper.getId() == 3) {
                currIn = currencyService.getById(currId);
                currOut = currencyService.getById(currEqId);
            } else {
                currIn = currencyService.getById(currId);
                currOut = currencyService.getCurrencyByIso("BYN");
            }
            rate = rateService.getRateByCurrInIsAndCurrOutIs(currIn, currOut);
            receipt.setSumIn(sum);
            receipt.setSumOut(calcSumOut(sum, rate));
        } else {
            currIn = currencyService.getCurrencyByIso("BYN");
            currOut = currencyService.getById(currId);
            rate = rateService.getRateByCurrInIsAndCurrOutIs(currIn, currOut);
            receipt.setSumIn(calcSumOut(sum, rate));
            receipt.setSumOut(sum);
        }
        //       User user = (User) session.getAttribute("user");
//        Rate rate = rateService.getRateByCurrInIsAndCurrOutIs(currIn,currOut);

        Workshift workshift = (Workshift) session.getAttribute("workshift");
        if (isEnoughRest(currOut, workshift, receipt.getSumOut())) {
            modelAndView.setViewName("oper/finalcalc");
            //       receipt.setOper(operService.getById(oper_id));
            receipt.setOper(oper);
            receipt.setWorkshift(workshift);
            receipt.setRate(rate);
//        receipt.setDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
            modelAndView.addObject("receipt", receipt);
        } else {
//            String redirectUrl = "redirect:/receipt/make/" + oper.getId() + "/" + oper.getName();
            modelAndView.setViewName("redirect:/cashier");
            String message = "There is not enough rest. Please, get the rest or enter less sum!";
            modelAndView.addObject("message", message);
//            session.setAttribute("restmessage",message);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/finalcalc", method = RequestMethod.POST)
    public ModelAndView getFinalCalcPage(@ModelAttribute(value = "receipt") Receipt receipt) {
        //       Rate rate = rateService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        Rate rate = rateService.getById(receipt.getRate().getId());
        Oper oper = operService.getById(receipt.getOper().getId());
        Workshift workshift = workshiftService.getById(receipt.getWorkshift().getId());
//        Rate rate = rateService.getRateByCurrInIsAndCurrOutIs(currIn,currOut);
        receipt.setRate(rate);
        receipt.setOper(oper);
        receipt.setWorkshift(workshift);
        receipt.setDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        modelAndView.setViewName("redirect:/cashier");
//        modelAndView.addObject("receipt", receipt);
//        modelAndView.addObject("currIn", currIn);
        //       modelAndView.addObject("currOut", currOut);
//        modelAndView.addObject("rate",rate);

        receiptService.save(receipt);
        updateRests(receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getExchangePage(@PathVariable("id") Long id) {
        Receipt receipt = receiptService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("oper/rcptEdit");
        modelAndView.addObject("receipt", receipt);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView setReceipt(@ModelAttribute("receipt") Receipt receipt,
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteReceipt(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/receipt/list");
        Receipt receipt = receiptService.getById(id);
        ;
        receiptService.delete(receipt);
        return modelAndView;
    }

    public BigDecimal calcSumOut(BigDecimal sumIn, Rate rate) {
        return sumIn.multiply(BigDecimal.valueOf(rate.getValue()));
    }

    public boolean isEnoughRest(Currency currency, Workshift workshift, BigDecimal sum) {
        boolean result;
        Rest restOutDB = restService.getRestByCurrencyAndWorkshift(currency, workshift);
        if (restOutDB == null) {
            result = false;
        } else {
            BigDecimal sumDB = restOutDB.getSum();
            result = sumDB.compareTo(sum) > -1;
        }
        return result;
    }

    public void updateRests(Receipt receipt) {
        Currency currIn = receipt.getRate().getCurrIn();
        Currency currOut = receipt.getRate().getCurrOut();
        Workshift workshift = receipt.getWorkshift();
        Rest rest = new Rest();
        Rest currentRestToPlusByWorkshift = restService.getRestByCurrencyAndWorkshift(currIn, workshift);
        Rest currentRestToPlusByCurr = restService.getRestByCurrency(currIn);
        if (currentRestToPlusByWorkshift==null){
            if (currentRestToPlusByCurr==null){
                currentRestToPlusByWorkshift = rest;
                currentRestToPlusByWorkshift.setWorkshift(workshift);
                currentRestToPlusByWorkshift.setCurrency(currIn);
                currentRestToPlusByWorkshift = restService.saveAndReturnObj(currentRestToPlusByWorkshift);
            } else {
                currentRestToPlusByWorkshift=currentRestToPlusByCurr;
                currentRestToPlusByWorkshift.setWorkshift(workshift);
            }
        }
        Rest currentRestToMinusByWorkshift = restService.getRestByCurrencyAndWorkshift(currOut, workshift);
        Rest currentRestToMinusByCurr = restService.getRestByCurrency(currOut);
        if (currentRestToMinusByWorkshift==null){
            if (currentRestToMinusByCurr==null){
                currentRestToMinusByWorkshift = rest;
                currentRestToMinusByWorkshift.setWorkshift(workshift);
                currentRestToMinusByWorkshift.setCurrency(currOut);
                currentRestToMinusByWorkshift = restService.saveAndReturnObj(currentRestToMinusByWorkshift);
            } else {
                currentRestToMinusByWorkshift = currentRestToMinusByCurr;
                currentRestToMinusByWorkshift.setWorkshift(workshift);
            }
        }
        if (currentRestToPlusByWorkshift.getSum()==null){
            currentRestToPlusByWorkshift.setSum(BigDecimal.valueOf(0));
        }
        if (currentRestToMinusByWorkshift.getSum()==null){
            currentRestToMinusByWorkshift.setSum(BigDecimal.valueOf(0));
        }
        currentRestToPlusByWorkshift.setSum(currentRestToPlusByWorkshift.getSum().add(receipt.getSumIn()));
        currentRestToMinusByWorkshift.setSum(currentRestToMinusByWorkshift.getSum().subtract(receipt.getSumOut()));
        restService.update(currentRestToPlusByWorkshift);
        restService.update(currentRestToMinusByWorkshift);
    }

//    @ModelAttribute
//    public void addAttributes(ModelAndView modelAndView) {
//        Receipt receipt = new Receipt();
//        modelAndView.addObject("receipt", receipt);
//    }
}
