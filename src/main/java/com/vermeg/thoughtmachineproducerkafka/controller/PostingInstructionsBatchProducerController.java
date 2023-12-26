    package com.vermeg.thoughtmachineproducerkafka.controller;

    import com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction.EventPostingInstruction;
    import com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction.PostingInstructionBatch;
    import com.vermeg.thoughtmachineproducerkafka.services.PostingInstructionBatchProducerService;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    /**
     * Controller for producing posting instruction batch-related Kafka events.
     */
    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1")
    public class PostingInstructionsBatchProducerController {

        private final PostingInstructionBatchProducerService postingInstructionBatchProducerService;

        /**
         * Handles a request to create a posting instruction batch and sends the event to Kafka.
         *
         * @param postingInstructionBatch The posting instruction batch to be created.
         * @return A response indicating the success of the operation.
         */

        @PostMapping("/PostingInstruction")
        public ResponseEntity<String> createPostingInstruction(@RequestBody PostingInstructionBatch postingInstructionBatch) {

            EventPostingInstruction eventPostingInstruction = EventPostingInstruction.builder()
                    .posting_instruction_batch(postingInstructionBatch)
                    .build();

            postingInstructionBatchProducerService.sendCreatePostingInstructionBatchEvent(eventPostingInstruction);

            String responseMessage = "PostingInstruction Created successfully";
            return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
        }


    }

