package com.vermeg.thoughtmachineproducerkafka.config;

import com.vermeg.thoughtmachineproducerkafka.model.customers.EventCustomer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration class for Kafka Producer settings.
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * Creates a Kafka producer factory for producing EventCustomer messages.
     *
     * @return The Kafka producer factory.
     */
    @Bean
    public ProducerFactory<String, EventCustomer> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapServers);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class); // Use JsonSerializer for EventMessage
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Creates a KafkaTemplate for producing EventCustomer messages.
     *
     * @return The KafkaTemplate instance.
     */
    @Bean
    public KafkaTemplate<String, EventCustomer> kafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());
    }
}
