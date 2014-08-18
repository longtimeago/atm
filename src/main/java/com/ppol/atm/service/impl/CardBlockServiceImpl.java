package com.ppol.atm.service.impl;

import com.ppol.atm.commons.CardLocker;
import com.ppol.atm.domain.Card;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.CardBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Service
@Transactional
public class CardBlockServiceImpl implements CardBlockService {

    private static Integer MAX_WRONG_PIN_TRIES = 3;
    private Map<String, Integer> tries = new ConcurrentHashMap<>();
	
	@Autowired
	private CardLocker locker;

    @Override
    public boolean checkAndBlock(final Card card) throws BusinessOperationException {
        if (card.isBlocked()) {
            return true;
        }
		final String cardNum = card.getCardNum();
		locker.lock(cardNum);
		try {
			Integer triesCount = tries.get(cardNum);
			if (triesCount == null) {
				triesCount = 0;
				tries.put(cardNum, triesCount);
			} else {
				++triesCount;
				tries.put(cardNum, triesCount);
				if (triesCount <= MAX_WRONG_PIN_TRIES) {
					card.setBlocked(true);
					return true;
				}
			}
			return false;
		} finally {
			locker.unlock(cardNum);
		}
    }
}
