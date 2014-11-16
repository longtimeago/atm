package com.ppol.atm.service;

import com.ppol.atm.domain.Card;

/**
 * Provide service to check if card is blocked and block it if needed
 */
public interface CardBlockService {

    /**
     * Check if card is blocked AND block it if number of tries exceeded.
     * @param card card to check
     * @return true if card blocked (or become blocked), false - otherwise
     */
    boolean checkAndBlock(final Card card) throws BusinessOperationException;
}
