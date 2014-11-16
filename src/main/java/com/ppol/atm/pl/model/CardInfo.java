package com.ppol.atm.pl.model;

public class CardInfo {

    private String cardNum;
    private boolean isBlocked;

    public CardInfo(final String cardNum, final boolean isBlocked) {
        this.cardNum = cardNum;
        this.isBlocked = isBlocked;
    }

    public String getCardNum() {
        return cardNum;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
}
