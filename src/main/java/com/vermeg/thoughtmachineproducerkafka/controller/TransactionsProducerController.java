    package com.vermeg.thoughtmachineproducerkafka.controller;

    import com.vermeg.thoughtmachineproducerkafka.model.transactions.Transaction;
    import com.vermeg.thoughtmachineproducerkafka.model.transactions.TransactionEvent;
    import com.vermeg.thoughtmachineproducerkafka.services.TransactionProducerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    /**
     * Controller for producing transaction-related Kafka events.
     */
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1")
    public class TransactionsProducerController {

        private final TransactionProducerService transactionProducerService;


        /**
         * Handles a request to create a transaction and sends the transaction event to Kafka.
         *
         * @param transaction The transaction to be created.
         * @return A response indicating the success of the operation.
         */

        @PostMapping("/createTransaction")
        public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {

            TransactionEvent transactionEvent = TransactionEvent.builder()
                    .transaction(transaction)
                    .build();

            transactionProducerService.sendCreateTransactionEvent(transactionEvent);

            String responseMessage = "Transaction Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

    }

