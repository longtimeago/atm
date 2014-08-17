package com.ppol.atm.service;

import com.ppol.atm.domain.Operation;
import com.ppol.atm.pl.model.CardInfo;
import java.math.BigDecimal;

/**
 * Created by ppolishchuk on 8/16/14.
 */
public interface ApplicationService {

    CardInfo getCard(String cardName) throws BusinessOperationException;

    BigDecimal getBalance(String cardName) throws BusinessOperationException;

    Operation withdraw(String cardNum, BigDecimal amount) throws BusinessOperationException;

    void checkPin(String cardNum, String pin) throws BusinessOperationException;
}
