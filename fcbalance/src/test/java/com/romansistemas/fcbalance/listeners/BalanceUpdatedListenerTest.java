package com.romansistemas.fcbalance.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.romansistemas.fcbalance.entities.Balance;
import com.romansistemas.fcbalance.entities.BalanceUpdatedEvent;
import com.romansistemas.fcbalance.entities.BalanceUpdatedEventPayload;
import com.romansistemas.fcbalance.repositories.BalanceRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BalanceUpdatedListenerTest {

    private static final String ACCOUNT_ID_FROM = "8a04ab4e-c59f-4463-8f12-4d9db69ad3c4";
    private static final String BALANCE_ACCOUNT_ID_FROM = "26915a58-51af-465f-aa6f-ab11ec49b3b4";
    private static final Double INITIAL_BALANCE_ACCOUNT_ID_FROM = 200.0;
    private static final String ACCOUNT_ID_TO = "ad69f578-9634-4652-8ad2-3a81c4dfa6a3";
    private static final String BALANCE_ACCOUNT_ID_TO = "d10621f6-f9f0-4483-b4a3-566fc171cee8";
    private static final Double INITIAL_BALANCE_ACCOUNT_ID_TO = 100.0;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private BalanceRepository balanceRepository;
    @InjectMocks
    private BalanceUpdatedListener balanceUpdatedListener;
    private BalanceUpdatedEvent event;

    @BeforeEach
    void setUp() {
        balanceRepository = mock(BalanceRepository.class);
        balanceUpdatedListener = new BalanceUpdatedListener();
        MockitoAnnotations.openMocks(this);

        event = eventFactory();

        Balance balanceFrom = new Balance();
        balanceFrom.setId(BALANCE_ACCOUNT_ID_FROM);
        balanceFrom.setAccountId(ACCOUNT_ID_FROM);
        balanceFrom.setBalance(INITIAL_BALANCE_ACCOUNT_ID_FROM);

        Balance balanceTo = new Balance();
        balanceTo.setId(BALANCE_ACCOUNT_ID_TO);
        balanceTo.setAccountId(ACCOUNT_ID_TO);
        balanceTo.setBalance(INITIAL_BALANCE_ACCOUNT_ID_TO);

        when(balanceRepository.findByAccountId(ACCOUNT_ID_FROM)).thenReturn(balanceFrom);
        when(balanceRepository.findByAccountId(ACCOUNT_ID_TO)).thenReturn(balanceTo);

    }

    @Test
    public void testListen() throws Exception {
        String message = objectMapper.writeValueAsString(event);

        balanceUpdatedListener.listen(message);

        ArgumentCaptor<Balance> balanceCaptor = ArgumentCaptor.forClass(Balance.class);
        verify(balanceRepository, times(2)).save(balanceCaptor.capture());

        Balance capturedBalanceFrom = balanceCaptor.getAllValues().get(0);
        assertEquals(100.0, capturedBalanceFrom.getBalance());
        assertEquals(ACCOUNT_ID_FROM, capturedBalanceFrom.getAccountId());

        Balance capturedBalanceTo = balanceCaptor.getAllValues().get(1);
        assertEquals(200.0, capturedBalanceTo.getBalance());
        assertEquals(ACCOUNT_ID_TO, capturedBalanceTo.getAccountId());
    }

    private BalanceUpdatedEvent eventFactory() {
        BalanceUpdatedEvent event = new BalanceUpdatedEvent();
        BalanceUpdatedEventPayload payload = new BalanceUpdatedEventPayload();
        payload.setAccountIdFrom(ACCOUNT_ID_FROM);
        payload.setBalanceAccountIdFrom(100.0);
        payload.setAccountIdTo(ACCOUNT_ID_TO);
        payload.setBalanceAccountIdTo(200.0);

        event.setName("Update balance event");
        event.setPayload(payload);
        return event;
    }
}
