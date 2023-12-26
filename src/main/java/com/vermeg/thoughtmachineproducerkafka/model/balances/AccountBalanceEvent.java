    package com.vermeg.thoughtmachineproducerkafka.model.balances;

    import lombok.AllArgsConstructor;
    import lombok.Builder;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.Instant;
    import java.time.format.DateTimeFormatter;
    import java.util.UUID;

    /**
     * Represents an event related to an account balance, including an associated balance object.
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class AccountBalanceEvent {
        @Builder.Default
        private String event_id = UUID.randomUUID().toString();
        @Builder.Default
        private String timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());

        private Balance balance;

    }
