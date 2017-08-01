package com.spbd.core.platform.mq.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MQMessageListener<T> implements MessageListener{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MQMessageListener.class);

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message message) {
		ObjectMessage objMsg = (ObjectMessage) message;
		try {
			boolean result = handleMessage((T) objMsg.getObject());
			if(result){				
				message.acknowledge();
			}
		} catch (JMSException e) {
			LOGGER.error(e.getMessage(),e);
		}
	}
	
	public abstract boolean handleMessage(T message);
}
