package com.ppol.atm.dao;

import com.ppol.atm.domain.Card;

public interface CardsDao {

    Card findByNum(String num);
}
