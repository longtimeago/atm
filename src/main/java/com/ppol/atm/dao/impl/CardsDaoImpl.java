package com.ppol.atm.dao.impl;

import com.ppol.atm.dao.CardsDao;
import com.ppol.atm.domain.Card;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Repository
public class CardsDaoImpl implements CardsDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Card findByNum(final String num) {
        final Criteria criteria = getSession().createCriteria(Card.class);
        criteria.add(Restrictions.eq("cardNum", num));
        final List<Card> cards = criteria.list();
        return cards.isEmpty() ? null : cards.get(0);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
