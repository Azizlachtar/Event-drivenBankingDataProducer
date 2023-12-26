    package com.vermeg.thoughtmachineproducerkafka.controller;

    import com.vermeg.thoughtmachineproducerkafka.model.accounts.AccountEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.created.AccountCreatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.updated.AccountUpdatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.services.AccountProducerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    /**
     * Controller for producing account-related Kafka events.
     */
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1")
    public class AccountProducerController {

        private final AccountProducerService accountProducerService;
        /**
         * Handles a request to create an account and sends the account creation event to Kafka.
         *
         * @param accountCreatedEvent The account creation event to be sent.
         * @return A response indicating the success of the operation.
         */

         @PostMapping("/createAccount")
        public ResponseEntity<String> createAccount(@RequestBody AccountCreatedEvent accountCreatedEvent) {

            AccountEvent<AccountCreatedEvent> event = AccountEvent.<AccountCreatedEvent>builder()
                    .account_created(accountCreatedEvent)
                    .build();

             accountProducerService.sendCreateAccountEvent2(event);

            String responseMessage = "account Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        /**
         * Handles a request to update an account and sends the account update event to Kafka.
         *
         * @param accountUpdatedEvent The account update event to be sent.
         * @return A response indicating the success of the operation.
         */
        @PostMapping("/updateAccount")
        public ResponseEntity<String> updateAccount(@RequestBody AccountUpdatedEvent accountUpdatedEvent) {

            AccountEvent<AccountUpdatedEvent> event = AccountEvent.<AccountUpdatedEvent>builder()
                    .account_update_updated(accountUpdatedEvent)
                    .build();

            accountProducerService.sendUpdateAccountEvent2(event);

            String responseMessage = "account updated successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

    }

