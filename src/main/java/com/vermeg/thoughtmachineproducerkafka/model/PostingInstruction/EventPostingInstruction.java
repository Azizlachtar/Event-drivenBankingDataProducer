package com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction;


import com.vermeg.thoughtmachineproducerkafka.model.customers.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Represents an event related to posting instructions, including a posting instruction batch and technical metadata.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventPostingInstruction {
    private PostingInstructionBatch posting_instruction_batch;
    @Builder.Default
    private String technical_metadata= DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    @Builder.Default
    private String eventId= UUID.randomUUID().toString();
}
