/*
    package com.vermeg.thoughtmachineproducerkafka.controller;

    import com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction.EventPostingInstruction;
    import com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction.PostingInstructionBatch;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.created.AccountCreatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.updated.AccountUpdatedEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.balances.AccountBalanceEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.balances.Balance;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.Customer;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.CustomerDetails;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
    import com.vermeg.thoughtmachineproducerkafka.model.accounts.AccountEvent;
    import com.vermeg.thoughtmachineproducerkafka.model.transactions.Transaction;
    import com.vermeg.thoughtmachineproducerkafka.model.transactions.TransactionEvent;
    import com.vermeg.thoughtmachineproducerkafka.services.ProducerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.time.Instant;
    import java.time.format.DateTimeFormatter;
    import java.util.UUID;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1")
    public class ProducerController {

        private final ProducerService producerService;

        @PostMapping("/createCustomers")
        public ResponseEntity<String> createCustomer(@RequestBody CustomerDetails customerDetails) {

            Instant instant = Instant.now();
            String formattedTimestamp = DateTimeFormatter.ISO_INSTANT.format(instant);

            Customer customer= Customer.builder()
                    .id(UUID.randomUUID().toString())
                    .status("CUSTOMER_STATUS_CREATED")
                    .customer_details(customerDetails)
                    .build();

            EventCustomer eventCustomer = EventCustomer.builder()
                    .customer(customer)
                    .technical_metadata(formattedTimestamp)
                    .eventId(UUID.randomUUID().toString())
                    .build();

            producerService.sendCreateCustomerEvent(eventCustomer);

            String responseMessage = "Customer Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        @PutMapping("/updateCustomers/{customerId}")
        public ResponseEntity<String> updateCustomer(
                @PathVariable String customerId,
                @RequestBody CustomerDetails customerDetails) {

            Instant instant = Instant.now();
            String formattedTimestamp = DateTimeFormatter.ISO_INSTANT.format(instant);

            Customer updatedCustomer = Customer.builder()
                    .id(customerId)
                    .status("CUSTOMER_STATUS_UPDATED")
                    .customer_details(customerDetails)
                    .build();

            EventCustomer eventCustomer = EventCustomer.builder()
                    .customer(updatedCustomer)
                    .technical_metadata(formattedTimestamp)
                    .eventId(UUID.randomUUID().toString())
                    .build();

            producerService.sendUpdateCustomerEvent(eventCustomer);

            String responseMessage = "Customer Updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        }


         @PostMapping("/createAccount")
        public ResponseEntity<String> createAccount(@RequestBody AccountCreatedEvent accountCreatedEvent) {

            AccountEvent<AccountCreatedEvent> event = AccountEvent.<AccountCreatedEvent>builder()
                    .account_created(accountCreatedEvent)
                    .build();

            producerService.sendCreateAccountEvent2(event);

            String responseMessage = "account Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        @PostMapping("/updateAccount")
        public ResponseEntity<String> updateAccount(@RequestBody AccountUpdatedEvent accountUpdatedEvent) {

            AccountEvent<AccountUpdatedEvent> event = AccountEvent.<AccountUpdatedEvent>builder()
                    .account_update_updated(accountUpdatedEvent)
                    .build();

            producerService.sendUpdateAccountEvent2(event);

            String responseMessage = "account updated successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        @PostMapping("/createBalance")
        public ResponseEntity<String> createBalance(@RequestBody Balance balance) {

            AccountBalanceEvent accountBalanceEvent = AccountBalanceEvent.builder()
                    .balance(balance)
                    .build();

            producerService.sendCreateBalanceEvent(accountBalanceEvent);

            String responseMessage = "Balance Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        @PostMapping("/createTransaction")
        public ResponseEntity<String> createTransaction(@RequestBody Transaction transaction) {

            TransactionEvent transactionEvent = TransactionEvent.builder()
                    .transaction(transaction)
                    .build();

            producerService.sendCreateTransactionEvent(transactionEvent);

            String responseMessage = "Transaction Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        @PostMapping("/PostingInstruction")
        public ResponseEntity<String> createPostingInstruction(@RequestBody PostingInstructionBatch postingInstructionBatch) {

            EventPostingInstruction eventPostingInstruction = EventPostingInstruction.builder()
                    .posting_instruction_batch(postingInstructionBatch)
                    .build();

            producerService.sendCreatePostingInstructionBatchEvent(eventPostingInstruction);

            String responseMessage = "PostingInstruction Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

         */
/* @PostMapping("/createAccount")
        public ResponseEntity<String> createAccount(@RequestBody AccountCreated accountCreated) {

            EventAccountCreate event = EventAccountCreate.builder()
                    .account_created(accountCreated)
                    .build();

            producerService.sendCreateAccountEvent(event);

            String responseMessage = "account Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }


        @PostMapping("/updateAccount")
        public ResponseEntity<String> updateAccount(@RequestBody AccountUpdateUpdated accountUpdateUpdated) {

            EventAccountUpdate event = EventAccountUpdate.builder()
                    .account_update_updated(accountUpdateUpdated)
                    .build();

            producerService.sendUpdateAccountEvent(event);

            String responseMessage = "account updated successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }*//*

    }

*/
