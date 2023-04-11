package com.sacavix.events;

import com.sacavix.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new customer created event.
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
