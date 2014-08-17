package com.ppol.atm.pl.controller;

import com.ppol.atm.pl.model.CardInfo;
import com.ppol.atm.service.ApplicationService;
import com.ppol.atm.service.BusinessOperationException;
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
public class LoginController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String welcome() {
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(
        @RequestParam(value="card_number", required=true) final String cardNum,
        final HttpServletRequest request) throws BusinessOperationException {

        if (StringUtils.isBlank(cardNum)) {
            throw new BusinessOperationException("Card number should not be blank");
        }

        final CardInfo card = this.applicationService.getCard(cardNum);
        if (card == null) {
            throw new BusinessOperationException("Card not found");
        }

        if (card.isBlocked()) {
            throw new BusinessOperationException("Card is blocked");
        }

        request.getSession().setAttribute("card_number", cardNum);

        return "redirect:pin";
    }

    @RequestMapping(value="/pin", method = RequestMethod.GET)
    public String pin() {
        return "pin";
    }

    @RequestMapping(value="/pin", method = RequestMethod.POST)
    public String pin(
        @RequestParam(value="pin", required=true) final String pin,
        final HttpServletRequest request) throws BusinessOperationException {

        if (StringUtils.isBlank(pin)) {
            throw new BusinessOperationException("Invalid pin");
        }

        final String cardNumber = (String) request.getSession().getAttribute("card_number");
        // session is broken -> redirect to login page
        if (StringUtils.isBlank(cardNumber)) {
            return "redirect:login";
        }

        applicationService.checkPin(cardNumber, pin);

        return "redirect:operation";
    }
}
