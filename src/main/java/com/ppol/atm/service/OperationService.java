package com.ppol.atm.service;

import com.ppol.atm.domain.Card;
import com.ppol.atm.domain.Operation;
import java.math.BigDecimal;

public interface OperationService {

    Operation withdraw(Card card, BigDecimal amount) throws BusinessOperationException;

    BigDecimal viewBalance(Card card) throws BusinessOperationException;
}
