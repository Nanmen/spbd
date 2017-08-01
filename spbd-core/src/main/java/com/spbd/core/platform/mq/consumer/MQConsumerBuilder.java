package com.spbd.core.platform.mq.consumer;

import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.spbd.core.platform.SpringObjectFactory;
import com.spbd.core.platform.mq.MQSetting;

public class MQConsumerBuilder implements InitializingBean{
	
	private String appName;
	
	private MQSetting mqSetting;
	
	private List<MQConsumeSpec> consumeSpecs;
	@Autowired
	private SpringObjectFactory springFactory;
	
	public MQConsumerBuilder(String appName,MQSetting mqSetting,List<MQConsumeSpec> consumeSpecs) {
		this.appName = appName;
		this.mqSetting = mqSetting;
		this.consumeSpecs = consumeSpecs;
	}
	
	public void buildConsumers() throws Exception{
		for (MQConsumeSpec mqConsumeSpec : consumeSpecs) {
			buildActiveMQConsumer(mqConsumeSpec);
		}
	}
	
	private void buildActiveMQConsumer(MQConsumeSpec consumeSpec) throws Exception{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(mqSetting.getUserName(),mqSetting.getPassword(),mqSetting.getUrl());  
		Connection connection =  connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(MQSetting.CONSUMER_PRIFIX.concat(appName).concat(".").concat(MQSetting.VIRTUAL_TOPIC_PREFIX).concat(consumeSpec.getMqTopic().name()));
		MessageConsumer consumer = session.createConsumer(destination);
		consumer.setMessageListener(springFactory.getOrCreateBean(consumeSpec.getMessageListenerCls()));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		buildConsumers();
		
	}
}
