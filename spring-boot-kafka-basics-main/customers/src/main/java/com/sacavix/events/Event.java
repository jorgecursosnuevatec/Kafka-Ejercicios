package com.sacavix.events;

import lombok.Data;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Instantiates a new event.
 * ESTA CLASE ES LO QUE SE ENVIA COMO MENSAJE, CONTIENE UNOS METADATOS
 * COMO SON EL ID,FECHA Y EL TIPO DE EVENTO ADEMAS DEL DATO EN SI DEFINIDO COMO GENERICO
 */
@Data
public abstract class Event <T> {
    
    /** The id. */
    private String id;
    
    /** The date. */
    private Date date;
    
    /** The type. definimos el tipo de evento*/
    private EventType type;
    
    /** The data. datos a enviar*/
    private T data;
}
