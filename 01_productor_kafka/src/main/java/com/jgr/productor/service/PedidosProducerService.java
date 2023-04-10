package com.jgr.productor.service;

import com.jgr.productor.model.Pedido;

public interface PedidosProducerService {
	public void sendMessage(String topic ,Pedido pedido);

}
