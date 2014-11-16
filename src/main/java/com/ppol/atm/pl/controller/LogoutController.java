package com.ppol.atm.pl.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(final HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login";
    }
}
