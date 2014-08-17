package com.ppol.atm.service.impl;

import com.ppol.atm.dao.CardsDao;
import com.ppol.atm.domain.Card;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Service
@Transactional
public class CardServiceImpl implements CardService {

    @Autowired
    private CardsDao cardsDao;

    @Override
    public Card getCard(final String cardNum) throws BusinessOperationException {
        final Card card = cardsDao.findByNum(cardNum);
        if (card == null) {
            throw new BusinessOperationException(String.format("Card [%s] is not registered", cardNum));
        }
        return card;
    }
}
