    package com.vermeg.thoughtmachineproducerkafka.controller;

    import com.vermeg.thoughtmachineproducerkafka.model.customers.Customer;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.CustomerDetails;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
    import com.vermeg.thoughtmachineproducerkafka.services.CustomerProducerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.time.Instant;
    import java.time.format.DateTimeFormatter;
    import java.util.UUID;

    /**
     * Controller for producing customer-related Kafka events.
     */
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1")
    public class ConsumerProducerController {

        private final CustomerProducerService customerProducerService;

        /**
         * Handles a request to create a customer and sends the customer creation event to Kafka.
         *
         * @param customerDetails The customer details to be used for creating the customer.
         * @return A response indicating the success of the operation.
         */
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

            customerProducerService.sendCreateCustomerEvent(eventCustomer);

            String responseMessage = "Customer Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }

        /**
         * Handles a request to update a customer and sends the customer update event to Kafka.
         *
         * @param customerId       The ID of the customer to be updated.
         * @param customerDetails  The updated customer details.
         * @return A response indicating the success of the operation.
         */
        @PutMapping("/updateCustomers/{customerId}")
        public ResponseEntity<String> updateCustomer(
                @PathVariable String customerId,
                @RequestBody CustomerDetails customerDetails) {

            String formattedTimestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

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

            customerProducerService.sendUpdateCustomerEvent(eventCustomer);

            String responseMessage = "Customer Updated successfully";
            return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
        }


    }

