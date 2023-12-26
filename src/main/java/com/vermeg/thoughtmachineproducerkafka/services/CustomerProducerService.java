    package com.vermeg.thoughtmachineproducerkafka.services;

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
     * Service for producing customer-related Kafka events.
     */
    @Service
    @RequiredArgsConstructor
    public class CustomerProducerService {

        private static final Logger LOGGER= LoggerFactory.getLogger(CustomerProducerService.class);

        private final NewTopic createCustomerTopic;
        private final NewTopic updateCustomerTopic;

        private final KafkaTemplate<String, EventCustomer> kafkaTemplate;

        /**
         * Sends a create customer event to the Kafka topic.
         *
         * @param event The customer event to be sent.
         */
        public void sendCreateCustomerEvent(EventCustomer event){
            LOGGER.info(String.format("Customer message => %s",event.toString()));
            LOGGER.info(String.format("Customer Topic => %s",createCustomerTopic.name()));


            Message<EventCustomer> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, createCustomerTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }

        /**
         * Sends an update customer event to the Kafka topic.
         *
         * @param event The customer event to be sent.
         */


        public void sendUpdateCustomerEvent(EventCustomer event){
            LOGGER.info(String.format("Customer message => %s",event.toString()));
            LOGGER.info(String.format("Customer Topic => %s",updateCustomerTopic.name()));

            Message<EventCustomer> message= MessageBuilder
                    .withPayload(event) // message body
                    .setHeader(KafkaHeaders.TOPIC, updateCustomerTopic.name())
                    .build();
            kafkaTemplate.send(message);

        }



    }


