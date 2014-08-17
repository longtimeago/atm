package com.ppol.atm.pl.controller;

import com.ppol.atm.domain.Card;
import com.ppol.atm.service.CardService;
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
public class LogoutController {

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(final HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }
}
