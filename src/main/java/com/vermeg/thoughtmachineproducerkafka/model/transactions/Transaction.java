    package com.vermeg.thoughtmachineproducerkafka.model.transactions;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.math.BigDecimal;
    import java.time.Instant;
    import java.time.format.DateTimeFormatter;
    import java.util.Date;
    import java.util.UUID;


    /**
     * Represents a financial transaction, including ID, balance ID, amount, sender, receiver, timestamp, and status.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Transaction {

        private String id = UUID.randomUUID().toString();
        private String balance_id;
        private BigDecimal amount;
        private String toAccount;

        private String fromAccount;

        public  String timestamp= DateTimeFormatter.ISO_INSTANT.format(Instant.now());

        public String status = "CREATED";

    }
