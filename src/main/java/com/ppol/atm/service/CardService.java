package com.ppol.atm.service;

import com.ppol.atm.domain.Card;
import java.math.BigDecimal;

/**
 * Created by ppolishchuk on 8/16/14.
 */
public interface CardService {

    Card getCard(String cardNum) throws BusinessOperationException;

}
