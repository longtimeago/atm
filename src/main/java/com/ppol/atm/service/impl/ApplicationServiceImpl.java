package com.ppol.atm.service.impl;

import com.ppol.atm.domain.Card;
import com.ppol.atm.domain.Operation;
import com.ppol.atm.pl.model.CardInfo;
import com.ppol.atm.service.ApplicationService;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.CardBlockService;
import com.ppol.atm.service.CardService;
import com.ppol.atm.service.OperationService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private CardService cardService;

    @Autowired
    private OperationService operationService;

    @Autowired
    private CardBlockService cardBlockService;

    @Override
    public CardInfo getCard(final String cardName) throws BusinessOperationException {
        final Card card = cardService.getCard(cardName);
        return new CardInfo(card.getCardNum(), card.isBlocked());
    }

    @Override
    public BigDecimal getBalance(final String cardName) throws BusinessOperationException {
        final Card card = cardService.getCard(cardName);
        return operationService.viewBalance(card);
    }

    @Override
    public Operation withdraw(final String cardNum, final BigDecimal amount) throws BusinessOperationException {
        final Card card = cardService.getCard(cardNum);
        return operationService.withdraw(card, amount);
    }

    @Override
    public void checkPin(final String cardNum, final String pin) throws BusinessOperationException {
        final Card card = cardService.getCard(cardNum);
        if (cardBlockService.checkAndBlock(card)) {
            throw new BusinessOperationException("Card is blocked");
        }
        if (!card.getPin().equals(pin)) {
            throw new BusinessOperationException("Wrong pin");
        }
    }
}
