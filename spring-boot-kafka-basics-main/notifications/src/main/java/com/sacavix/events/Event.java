package com.sacavix.events;

import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * Event
 * 
 * clase espejo de la que tiene el productor
 *

 */
@ToString

/**
 * Instantiates a new event.
 */
@Data
public abstract class Event <T> {
    
    /** The id. */
    private String id;
    
    /** The date. */
    private Date date;
    
    /** The type. */
    private EventType type;
    
    /** The data. */
    private T data;
}
