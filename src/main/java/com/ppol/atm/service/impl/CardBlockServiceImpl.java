package com.ppol.atm.service.impl;

import com.ppol.atm.domain.Card;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.CardBlockService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CardBlockServiceImpl implements CardBlockService {

    private static Integer MAX_WRONG_PIN_TRIES = 3;
    private ConcurrentMap<String, AtomicInteger> tries = new ConcurrentHashMap<>();

    @Override
    public boolean checkAndBlock(final Card card) throws BusinessOperationException {
        if (card.isBlocked()) {
            return true;
        }

        final Lock lock = new ReentrantLock();
        final AtomicInteger newTriesCount = new AtomicInteger(0);
        final AtomicInteger triesCount = tries.putIfAbsent(card.getCardNum(), newTriesCount);
        lock.lock();
        try {
            if (triesCount == null) {
                newTriesCount.incrementAndGet();
            } else {
                int currentCount = triesCount.incrementAndGet();
                if (currentCount <= MAX_WRONG_PIN_TRIES) {
                    card.setBlocked(true);
                    return true;
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
