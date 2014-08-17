package com.ppol.atm.service.impl;

import com.ppol.atm.domain.Card;
import com.ppol.atm.domain.Operation;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.OperationService;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Service
@Transactional
public class OperationServiceImpl implements OperationService {

    @Override
    public Operation withdraw(final Card card, final BigDecimal amount) throws BusinessOperationException {
        final BigDecimal balance = card.getBalance();
        if (amount.compareTo(BigDecimal.ZERO ) == -1) {
            throw new BusinessOperationException("Amount can't be less than zero");
        }
        if (balance.compareTo(amount) == -1) {
            throw new BusinessOperationException("Insufficient funds to perform withdraw");
        }
        final Operation operation = new Operation(card, amount, "W");
        card.getOperations().add(operation);
        card.setBalance(balance.subtract(amount));
        return operation;
    }

    @Override
    public BigDecimal viewBalance(final Card card) throws BusinessOperationException {
        final Operation operation = new Operation(card, BigDecimal.ZERO, "V");
        card.getOperations().add(operation);
        return card.getBalance();
    }

}
