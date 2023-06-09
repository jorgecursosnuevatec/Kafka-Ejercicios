package com.sacavix.service;

import com.sacavix.events.CustomerCreatedEvent;
import com.sacavix.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/** The Constant log. */
@Slf4j
@Component
public class
CustomerEventsService {

	/**
	 * Consumer.
	 *
	 * @param event the event
	 */
	@KafkaListener(
			topics = "${topic.customer.name:customers}",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(CustomerCreatedEvent.class)) {
			CustomerCreatedEvent customerCreatedEvent = (CustomerCreatedEvent) event;
			log.info("Recibido en CustomerEventsService creado evento .... with Id={}, data={}",
					customerCreatedEvent.getId(),
					customerCreatedEvent.getData().toString());
			
			log.info("Datos del evento-> Id={} ,Date={} , Type={}",
					event.getId(),
					event.getDate(),
					event.getType());
			
			
			
		}

	}
	
	

}
