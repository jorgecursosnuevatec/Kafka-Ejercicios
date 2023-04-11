package com.sacavix.entity;

import lombok.Data;


/**
 * Instantiates a new customer.
 * 
 */
@Data
public class Customer {
	
	/** The id. */
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
}
