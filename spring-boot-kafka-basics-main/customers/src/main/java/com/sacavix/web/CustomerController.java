package com.sacavix.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sacavix.entity.Customer;
import com.sacavix.service.CustomerService;


/**
 * The Class CustomerController.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	/** The customer service. */
	private final CustomerService customerService;

	/**
	 * Instantiates a new customer controller.
	 *
	 * @param customerService the customer service
	 */
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	/**
	 * Save.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	@PostMapping
	public Customer save(@RequestBody Customer customer) {
		return this.customerService.save(customer);
	}
	

}
