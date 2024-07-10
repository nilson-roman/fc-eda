package com.romansistemas.fcbalance.service.impl;

import com.romansistemas.fcbalance.entities.Balance;
import com.romansistemas.fcbalance.repositories.BalanceRepository;
import com.romansistemas.fcbalance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Override
    public Balance findByAccountId(String accountId) {
        return balanceRepository.findByAccountId(accountId);
    }
}
