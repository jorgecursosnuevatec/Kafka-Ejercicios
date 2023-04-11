package com.sacavix.config;

import java.util.HashMap;
import java.util.Map;

import com.sacavix.events.Event;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

// TODO: Auto-generated Javadoc
/**
 * The Class KafkaProducerConfig.
 * 
 * CONFIGURACION DEL PRODUCTOR
 */
@Configuration
public class KafkaProducerConfig {
	
	/** The bootstrap address. */
	private final String bootstrapAddress = "localhost:9092";
	
    /**
     * Producer factory.
     * DEVUELVE UN OBJETO CON LA KEY Y EL VALUE DEL MENSAJE
     * ES EL PRODUCTOR DE KAFKA
     *
     * @return the producer factory
     */
    @Bean
    public ProducerFactory<String, Event<?>> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
          ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          bootstrapAddress);//DIRECCION DEL BUS DE MENSAJES DE KAFKA
        configProps.put(
          ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, 
          StringSerializer.class); //LLAVE CON LA QUE VAMOS A SERIALIZAR
        configProps.put(
        	      ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, 
        	      JsonSerializer.class); //CONFIGURACION DEL OBJETO QUE VAMOS A SERIALIZAR
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Kafka template.
     * ESTA CLASE PERMITE UTILIZAR LOS METODOS ,LOS ENVIA CON SEND
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<String, Event<?>> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
