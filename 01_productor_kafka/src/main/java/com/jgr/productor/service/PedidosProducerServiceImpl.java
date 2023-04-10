package com.jgr.productor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.jgr.productor.model.Pedido;

/**
 * The Class KafkaProducerImpl. capa de servicio del productor de kafka enviamos
 * el pedido
 */
@Service
public class PedidosProducerServiceImpl implements PedidosProducerService {

	@Autowired
	KafkaTemplate kafkaTemplate;

	/**
	 * Send message.
	 *
	 * @param topic  the topic
	 * @param pedido the pedido
	 */
	@Override
	public void sendMessage(String topico, Pedido pedido) {
		
		//el ListenableFuture permite controlar el proceso,si ha ido ok o ko

		ListenableFuture<SendResult<String, Pedido>> future = kafkaTemplate.send(topico, pedido);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Pedido>>() {
			@Override
			public void onSuccess(SendResult<String, Pedido> result) {
				System.out.println("Enviado->".concat(result.getProducerRecord().value().getProducto())
						.concat(" al topic->").concat(result.getRecordMetadata().topic()));

			}

			@Override
			public void onFailure(Throwable ex) {
				ex.printStackTrace();

			}
		});

	}
}
