package com.romansistemas.fcbalance.controller;

import com.romansistemas.fcbalance.dto.BalanceDTO;
import com.romansistemas.fcbalance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balances")
public class BalanceController {

    @Autowired
    private BalanceService balanceService;


    @GetMapping(value = "/{accountId}")
    public ResponseEntity<BalanceDTO> getBalance(@PathVariable(name = "accountId")  String accountId) {
        BalanceDTO balance = BalanceDTO.fromEntityToDTO(balanceService.findByAccountId(accountId));

        if (balance == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(balance);
    }
}
