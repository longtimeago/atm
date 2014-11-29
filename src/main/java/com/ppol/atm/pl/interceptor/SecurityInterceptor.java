package com.ppol.atm.pl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {

        System.out.println("Pre-handle: " + request.getRequestURI());

        final String cardNumber = (String) request.getSession().getAttribute("card_number");
        // session is broken -> redirect to login page
        if (StringUtils.isBlank(cardNumber)) {
            System.out.println("Session is broken. Redirecting to login page");
            response.sendRedirect("/login");
        }
        return true;
    }
}
