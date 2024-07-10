package com.romansistemas.fcbalance.dto;

import com.romansistemas.fcbalance.entities.Balance;

public class BalanceDTO {

    public String id;
    public String accountId;
    public double balance;

    public static BalanceDTO fromEntityToDTO(Balance balance) {
        if (balance == null) {
            return null;
        }

        BalanceDTO balanceDTO = new BalanceDTO();
        balanceDTO.id = balance.getId();
        balanceDTO.accountId = balance.getAccountId();
        balanceDTO.balance = balance.getBalance();
        return balanceDTO;
    }
}
