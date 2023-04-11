package com.sacavix.events;

import com.sacavix.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Instantiates a new customer created event.
 * hereda de event y le pasamos un objeto customer porque event tiene un generico
 */
@Data

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = true)
public class CustomerCreatedEvent extends Event<Customer> {

}
