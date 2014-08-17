package com.ppol.atm.service;

import com.ppol.atm.domain.Operation;
import com.ppol.atm.pl.model.CardInfo;
import java.math.BigDecimal;

/**
 * Main service facade
 *
 * Created by ppolishchuk on 8/16/14.
 */
public interface ApplicationService {

    CardInfo getCard(String cardName) throws BusinessOperationException;

    BigDecimal getBalance(String cardName) throws BusinessOperationException;

    /**
     * Withdraw funds from given card
     * @param cardNum card num
     * @param amount amount to withdraw
     * @return {@code Operation} objects
     * @throws BusinessOperationException if not enough cash on card to perform withdrawal
     */
    Operation withdraw(String cardNum, BigDecimal amount) throws BusinessOperationException;

    /**
     * Check that entered pin
     * @param cardNum card num
     * @param pin pin code
     * @throws BusinessOperationException if pin is wrong, or card is/become blocked
     */
    void checkPin(String cardNum, String pin) throws BusinessOperationException;
}
