package com.romansistemas.fcbalance.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romansistemas.fcbalance.entities.Balance;
import com.romansistemas.fcbalance.entities.BalanceUpdatedEvent;
import com.romansistemas.fcbalance.repositories.BalanceRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class BalanceUpdatedListener implements ConsumerListener {
    private static final Logger logger = LogManager.getLogger(BalanceUpdatedListener.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private BalanceRepository balanceRepository;

    @Override
    @Transactional
    @KafkaListener(topics = "balances", groupId = "balances-consumer-group")
    public void listen(String message) {
        try {
            BalanceUpdatedEvent balanceUpdateEvent = objectMapper.readValue(message, BalanceUpdatedEvent.class);
            logger.info("Received message from balance topic: " + balanceUpdateEvent);

            saveOrUpdateBalance(balanceUpdateEvent.getPayload().getAccountIdFrom(), balanceUpdateEvent.getPayload().getBalanceAccountIdFrom());
            saveOrUpdateBalance(balanceUpdateEvent.getPayload().getAccountIdTo(), balanceUpdateEvent.getPayload().getBalanceAccountIdTo());

            logger.info("Updated balances for account " + balanceUpdateEvent.getPayload().getAccountIdFrom() + " and " + balanceUpdateEvent.getPayload().getAccountIdTo() + " successfully");
        } catch (Exception e) {
            logger.error("Error processing message: " + e.getMessage());
        }
    }

    private void saveOrUpdateBalance(String accountId, double balance) {
        Balance existingBalance = balanceRepository.findByAccountId(accountId);
        if (existingBalance != null) {
            existingBalance.setBalance(balance);
            existingBalance.setUpdatedAt(ZonedDateTime.now());
            balanceRepository.save(existingBalance);
        } else {
            Balance newBalance = new Balance();
            newBalance.setId(UUID.randomUUID().toString());
            newBalance.setAccountId(accountId);
            newBalance.setBalance(balance);
            newBalance.setUpdatedAt(ZonedDateTime.now());
            balanceRepository.save(newBalance);
        }
    }
}
