package com.jgr.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jgr.productor.model.Pedido;
import com.jgr.productor.service.PedidosProducerService;



@RestController
public class PedidosProducerController {
	
	
	//definido en el properties
	@Value("${topic}")
	String topic;
	
	@Autowired
	PedidosProducerService pedidosProducerService;
	
	@PostMapping(value="pedido/{nombre}/{unidades}/{precio}")
	public void pedido(@PathVariable("nombre") String nombre ,
			@PathVariable("unidades") int unidades ,
			@PathVariable("precio") double precio) {
		Pedido pedido = new Pedido(nombre,unidades,precio);
		
		pedidosProducerService.sendMessage(topic, pedido);
		
		
	}
	
	
	

}
