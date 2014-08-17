package com.ppol.atm.dao;

import com.ppol.atm.domain.Card;

/**
 * Created by ppolishchuk on 8/16/14.
 */
public interface CardsDao {

    Card findByNum(String num);
}
