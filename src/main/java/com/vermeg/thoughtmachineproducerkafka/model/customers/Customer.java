    package com.vermeg.thoughtmachineproducerkafka.model.customers;



    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    /**
     * Represents a customer entity with their unique ID, status, and customer details.
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Customer {

        private String id;
        private String status;
        private CustomerDetails customer_details;
    }
