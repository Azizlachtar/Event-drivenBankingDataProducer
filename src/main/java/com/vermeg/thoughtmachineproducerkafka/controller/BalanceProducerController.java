package com.vermeg.thoughtmachineproducerkafka.controller;

import com.vermeg.thoughtmachineproducerkafka.model.balances.AccountBalanceEvent;
import com.vermeg.thoughtmachineproducerkafka.model.balances.Balance;
import com.vermeg.thoughtmachineproducerkafka.services.BalanceProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for producing balance-related Kafka events.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class BalanceProducerController {

    private final BalanceProducerService balanceProducerService;


    /**
     * Handles a request to create a balance and sends the balance creation event to Kafka.
     *
     * @param balance The balance to be created.
     * @return A response indicating the success of the operation.
     */
    @PostMapping("/createBalance")
    public ResponseEntity<String> createBalance(@RequestBody Balance balance) {

        AccountBalanceEvent accountBalanceEvent = AccountBalanceEvent.builder()
                .balance(balance)
                .build();

        balanceProducerService.sendCreateBalanceEvent(accountBalanceEvent);

        String responseMessage = "Balance Created successfully";
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }

}

