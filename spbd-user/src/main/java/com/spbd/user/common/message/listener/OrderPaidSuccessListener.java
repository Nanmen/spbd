package com.spbd.user.common.message.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spbd.core.platform.mq.consumer.MQMessageListener;
import com.spbd.wsapi.order.message.OrderPaidSuccessMessage;

public class OrderPaidSuccessListener extends MQMessageListener<OrderPaidSuccessMessage>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderPaidSuccessListener.class);

	@Override
	public boolean handleMessage(OrderPaidSuccessMessage message) {
		LOGGER.info("received message is {}",message.getOrderId());
		return true;
	}
	

}
