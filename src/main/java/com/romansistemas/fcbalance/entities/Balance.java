package com.romansistemas.fcbalance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.ZonedDateTime;

@Entity
@Table(name = "balances")
public class Balance {

    @Id
    private String id;
    private String accountId;
    private double balance;
    private ZonedDateTime updatedAt;

    public Balance() { }

    public Balance(String id, String clientId, double balance, ZonedDateTime updatedAt) {
        this.id = id;
        this.accountId = clientId;
        this.balance = balance;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
