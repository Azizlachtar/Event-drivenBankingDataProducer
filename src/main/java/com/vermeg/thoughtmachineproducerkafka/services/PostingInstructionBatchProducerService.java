    package com.vermeg.thoughtmachineproducerkafka.services;

    import com.vermeg.thoughtmachineproducerkafka.model.PostingInstruction.EventPostingInstruction;
    import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
    import lombok.RequiredArgsConstructor;
    import org.apache.kafka.clients.admin.NewTopic;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.kafka.core.KafkaTemplate;
    import org.springframework.kafka.support.KafkaHeaders;
    import org.springframework.messaging.Message;
    import org.springframework.messaging.support.MessageBuilder;
    import org.springframework.stereotype.Service;
    /**
     * Service for producing posting instruction batch-related Kafka events.
     */
    @Service
    @RequiredArgsConstructor
    public class PostingInstructionBatchProducerService {

        private static final Logger LOGGER= LoggerFactory.getLogger(PostingInstructionBatchProducerService.class);

        private final NewTopic createPostingInstructionBatchTopic;

        private final KafkaTemplate<String, EventCustomer> kafkaTemplate;


        /**
         * Sends a create posting instruction batch event to the Kafka topic.
         *
         * @param event The posting instruction batch event to be sent.
         */
        public void sendCreatePostingInstructionBatchEvent(EventPostingInstruction event){
            LOGGER.info(String.format("PostingInstructionBatch message => %s",event.toString()));
            LOGGER.info(String.format("PostingInstructionBatch Topic => %s",createPostingInstructionBatchTopic.name()));


            Message<EventPostingInstruction> message= MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, createPostingInstructionBatchTopic.name())
                    .build();

            kafkaTemplate.send(message);

        }


    }


