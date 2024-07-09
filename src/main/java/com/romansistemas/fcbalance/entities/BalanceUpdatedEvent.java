package com.romansistemas.fcbalance.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceUpdatedEvent {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Payload")
    private BalanceUpdatedEventPayload payload;

    public BalanceUpdatedEvent() { }

    public BalanceUpdatedEvent(String name, BalanceUpdatedEventPayload payload) {
        this.name = name;
        this.payload = payload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BalanceUpdatedEventPayload getPayload() {
        return payload;
    }

    public void setPayload(BalanceUpdatedEventPayload payload) {
        this.payload = payload;
    }
}