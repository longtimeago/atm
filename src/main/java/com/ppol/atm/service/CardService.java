package com.ppol.atm.service;

import com.ppol.atm.domain.Card;

public interface CardService {

    Card getCard(String cardNum) throws BusinessOperationException;

}
