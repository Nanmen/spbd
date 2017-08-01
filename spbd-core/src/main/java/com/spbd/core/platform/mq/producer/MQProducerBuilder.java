package com.spbd.core.platform.mq.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.spbd.core.platform.SpringObjectFactory;
import com.spbd.core.platform.mq.MQSetting;
import com.spbd.core.platform.mq.MQType;

public class MQProducerBuilder {
	
	private SpringObjectFactory springObjectFactory;
	
	
	public MQProducerBuilder(SpringObjectFactory springObjectFactory) {
		this.springObjectFactory = springObjectFactory;
	}
	
	public MQProducer buildeMQProducer(MQSetting mqSetting) throws Exception{
		if(MQType.ACTIVEMQ == mqSetting.getMqType()){
			return buildActiveMQProducer(mqSetting);
		}
		return null;
	}
	
	private ActiveMQProducer buildActiveMQProducer(MQSetting mqSetting) throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(mqSetting.getUserName(),mqSetting.getPassword(),mqSetting.getUrl());  
		Connection connection =  connectionFactory.createConnection(); 
		connection.start();
		ActiveMQProducer producer = new ActiveMQProducer(connection);
		springObjectFactory.initializeBean(producer);
		return producer;
	}
}
