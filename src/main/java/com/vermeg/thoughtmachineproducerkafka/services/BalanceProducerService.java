    package com.vermeg.thoughtmachineproducerkafka.services;

    import com.vermeg.thoughtmachineproducerkafka.model.balances.AccountBalanceEvent;
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
     * Service for producing balance-related Kafka events.
     */
    @Service
    @RequiredArgsConstructor
    public class BalanceProducerService {

        private static final Logger LOGGER= LoggerFactory.getLogger(BalanceProducerService.class);

        private final NewTopic createBalanceTopic;

        private final KafkaTemplate<String, EventCustomer> kafkaTemplate;

        /**
         * Sends a create balance event to the Kafka topic.
         *
         * @param event The account balance event to be sent.
         */

        public void sendCreateBalanceEvent(AccountBalanceEvent event){
            LOGGER.info(String.format("Balance message => %s",event.toString()));
            LOGGER.info(String.format("Balance Topic => %s",createBalanceTopic.name()));


            Message<AccountBalanceEvent> message= MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, createBalanceTopic.name())
                    .build();

            kafkaTemplate.send(message);

        }



    }


