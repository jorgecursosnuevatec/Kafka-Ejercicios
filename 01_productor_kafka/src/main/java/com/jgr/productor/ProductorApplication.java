package com.jgr.productor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * The Class ProductorApplication.
 * Productor para pruebas kafka
 * 
 * CUIDADO CON LAS VERSIONES, EN EL POM PONER 2.6.3
 */
@SpringBootApplication(scanBasePackages= {"com.jgr.productor.service","com.jgr.productor.controller"})
public class ProductorApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductorApplication.class, args);
	}

}
