package com.romansistemas.fcbalance.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BalanceUpdatedEventPayload {

    private String id;
    private String accountIdFrom;
    private String accountIdTo;
    private Double balanceAccountIdFrom;
    private Double balanceAccountIdTo;

    public BalanceUpdatedEventPayload() { }

    public BalanceUpdatedEventPayload(String accountIdFrom, String accountIdTo,
                                      Double balanceAccountIdFrom, Double balanceAccountIdTo) {
        this.accountIdFrom = accountIdFrom;
        this.accountIdTo = accountIdTo;
        this.balanceAccountIdFrom = balanceAccountIdFrom;
        this.balanceAccountIdTo = balanceAccountIdTo;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAccountIdFrom() {
        return accountIdFrom;
    }
    public void setAccountIdFrom(String accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }
    public String getAccountIdTo() {
        return accountIdTo;
    }
    public void setAccountIdTo(String accountIdTo) {
        this.accountIdTo = accountIdTo;
    }
    public Double getBalanceAccountIdFrom() {
        return balanceAccountIdFrom;
    }
    public void setBalanceAccountIdFrom(Double balanceAccountIdFrom) {
        this.balanceAccountIdFrom = balanceAccountIdFrom;
    }
    public Double getBalanceAccountIdTo() {
        return balanceAccountIdTo;
    }
    public void setBalanceAccountIdTo(Double balanceAccountIdTo) {
        this.balanceAccountIdTo = balanceAccountIdTo;
    }
}
