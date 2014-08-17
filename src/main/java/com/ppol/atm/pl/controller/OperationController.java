package com.ppol.atm.pl.controller;

import com.ppol.atm.domain.Card;
import com.ppol.atm.domain.Operation;
import com.ppol.atm.pl.model.CardInfo;
import com.ppol.atm.service.ApplicationService;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.CardService;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Controller
public class OperationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value="/operation", method = RequestMethod.GET)
    public String operation() {
        return "operation";
    }

    @RequestMapping(value="/balance", method = RequestMethod.POST)
    public String balance(
        ModelMap model,
        HttpServletRequest request) throws BusinessOperationException {

        final String cardNumber = (String) request.getSession().getAttribute("card_number");
        // session is broken -> redirect to login page
        if (StringUtils.isBlank(cardNumber)) {
            return "redirect:login";
        }

        final BigDecimal balance = this.applicationService.getBalance(cardNumber);
        model.addAttribute("balance", balance.doubleValue());

        return "balance";
    }

    @RequestMapping(value="/withdraw", method = RequestMethod.GET)
    public String withdraw() {
        return "withdraw";
    }

    @RequestMapping(value="/withdraw", method = RequestMethod.POST)
    public String withdraw(
        @RequestParam(value="amount", required=true) final String amount,
        ModelMap model,
        HttpServletRequest request) throws BusinessOperationException {

        final String cardNumber = (String) request.getSession().getAttribute("card_number");
        // session is broken -> redirect to login page
        if (StringUtils.isBlank(cardNumber)) {
            return "redirect:login";
        }

        final Operation operation = this.applicationService.withdraw(cardNumber, BigDecimal.valueOf(Double.valueOf(amount)));
        model.addAttribute("operation", operation);

        return "withdraw_report";
    }
}
