package com.ppol.atm.service;

import com.ppol.atm.domain.Card;
import com.ppol.atm.domain.Operation;
import java.math.BigDecimal;

/**
 * Created by ppolishchuk on 8/16/14.
 */
public interface OperationService {

    Operation withdraw(Card card, BigDecimal amount) throws BusinessOperationException;

    BigDecimal viewBalance(Card card) throws BusinessOperationException;
}
