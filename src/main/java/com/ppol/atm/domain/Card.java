package com.ppol.atm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Entity
@Table(name = "cards")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    @Column(name = "card_num")
    private String cardNum;

    @Column(name = "balance")
    private BigDecimal balance;

    @Basic
    @Column(name = "blocked", columnDefinition = "BIT", length = 1)
    private boolean isBlocked;

    @Column(name="pin", length = 4)
    private String pin;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="card_id")
    private Set<Operation> operations;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(final String cardNum) {
        this.cardNum = cardNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(final boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public String getPin() {
        return pin;
    }

    public void setPin(final String pin) {
        this.pin = pin;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(final Set<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Card card = (Card) o;

        if (id != card.id) return false;
        if (isBlocked != card.isBlocked) return false;
        if (!balance.equals(card.balance)) return false;
        if (!cardNum.equals(card.cardNum)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Card{" +
            "id=" + id +
            ", cardNum='" + cardNum + '\'' +
            ", balance=" + balance +
            ", isBlocked=" + isBlocked +
            '}';
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + cardNum.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + (isBlocked ? 1 : 0);
        return result;
    }
}
