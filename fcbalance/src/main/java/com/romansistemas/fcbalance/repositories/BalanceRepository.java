package com.romansistemas.fcbalance.repositories;

import com.romansistemas.fcbalance.entities.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String> {

    Balance findByAccountId(String accountId);
}
