package com.sacavix.service;

import org.springframework.stereotype.Service;

import com.sacavix.entity.Customer;


/**
 * The Class CustomerService.
 */
@Service
public class CustomerService {
	
	/** The customer events service. */
	private final CustomerEventsService customerEventsService;

	/**
	 * Instantiates a new customer service.
	 *
	 * @param customerEventsService the customer events service
	 */
	public CustomerService(CustomerEventsService customerEventsService) {
		super();
		this.customerEventsService = customerEventsService;
	}

	/**
	 * Save.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	public Customer save(Customer customer) {
		System.out.println("Creado en  CustomerService->" + customer);
		this.customerEventsService.publish(customer);
		return customer;
		
	}

}
