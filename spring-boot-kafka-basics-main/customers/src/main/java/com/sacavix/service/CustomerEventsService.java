package com.sacavix.service;

import com.sacavix.events.CustomerCreatedEvent;
import com.sacavix.events.Event;
import com.sacavix.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.sacavix.entity.Customer;

import java.util.Date;
import java.util.UUID;


/**
 * The Class CustomerEventsService.
 * DESDE AQUI ENVIAMOS EL EVENTO
 */
@Component
public class CustomerEventsService {
	
	/** The producer. */
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	/** The topic customer. */
	@Value("${topic.customer.name:customers}")
	private String topicCustomer;
	
	/**
	 * Publish.
	 * creamos el objeto que vamos a enviar
	 *
	 * @param customer the customer
	 */
	public void publish(Customer customer) {

		CustomerCreatedEvent created = new CustomerCreatedEvent();
		created.setData(customer);
		created.setId(UUID.randomUUID().toString());//immutable universally unique identifier (UUID)
		created.setType(EventType.CREATED);
		created.setDate(new Date());

		this.producer.send(topicCustomer, created); //SE ENVIA UN TOPICO Y EL OBJETO CREADO
	}
	
	

}
