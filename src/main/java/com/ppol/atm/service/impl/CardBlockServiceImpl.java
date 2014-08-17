package com.ppol.atm.service.impl;

import com.ppol.atm.domain.Card;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.CardBlockService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Service
@Transactional
public class CardBlockServiceImpl implements CardBlockService {

    private static Integer MAX_WRONG_PIN_TRIES = 3;
    private Map<String, Integer> tries = new ConcurrentHashMap<>();

    @Override
    public boolean checkAndBlock(final Card card) throws BusinessOperationException {
        if (card.isBlocked()) {
            return true;
        }
        Integer triesCount = tries.get(card.getCardNum());
        if (triesCount == null) {
            triesCount = 0;
        }
        if (triesCount <= MAX_WRONG_PIN_TRIES) {
            tries.put(card.getCardNum(), ++triesCount);
            return false;
        }
        card.setBlocked(true);
        return true;
    }
}
