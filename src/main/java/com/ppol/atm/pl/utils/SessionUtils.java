package com.ppol.atm.pl.utils;

import javax.servlet.http.HttpServletRequest;

public final class SessionUtils {

    public static String getCardNum(final HttpServletRequest request) {
        return (String) request.getSession().getAttribute("card_number");
    }

    public static void setCardNum(final HttpServletRequest request, final String cardNum) {
        request.getSession().setAttribute("card_number", cardNum);
    }
}
