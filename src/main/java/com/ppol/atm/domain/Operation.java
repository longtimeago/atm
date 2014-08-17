package com.ppol.atm.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by ppolishchuk on 8/16/14.
 */
@Entity
@Table(name = "operations")
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "oper_code", length = 1)
    private String operationCode;

    @Column(name = "dtm")
    private Date operationTimestamp = new Date();

    @ManyToOne
    private Card card;

    public Operation() {
    }

    public Operation(final Card card, final BigDecimal amount, final String operationCode) {
        this.card = card;
        this.amount = amount;
        this.operationCode = operationCode;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(final String operationCode) {
        this.operationCode = operationCode;
    }

    public Date getOperationTimestamp() {
        return operationTimestamp;
    }

    public void setOperationTimestamp(final Date operationTimestamp) {
        this.operationTimestamp = operationTimestamp;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(final Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Operation operation = (Operation) o;

        if (id != operation.id) return false;
        if (!amount.equals(operation.amount)) return false;
        if (!operationCode.equals(operation.operationCode)) return false;
        if (!operationTimestamp.equals(operation.operationTimestamp))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + amount.hashCode();
        result = 31 * result + operationCode.hashCode();
        result = 31 * result + operationTimestamp.hashCode();
        return result;
    }
}
