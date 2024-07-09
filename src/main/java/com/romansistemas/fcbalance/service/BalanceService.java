package com.romansistemas.fcbalance.service;

import com.romansistemas.fcbalance.entities.Balance;

public interface BalanceService {

    Balance findByAccountId(String accountId);
}
