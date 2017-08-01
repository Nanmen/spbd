package com.spbd.core.platform.mq.producer;


import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spbd.core.platform.SpringObjectFactory;
import com.spbd.core.platform.mq.MQSendResult;
import com.spbd.core.platform.mq.MQSetting;
import com.spbd.core.platform.mq.MQTopic;

public class ActiveMQProducer implements MQProducer{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ActiveMQProducer.class);
	@Autowired
	private SpringObjectFactory springObjectFactory;
	private Connection connection;
	
	public ActiveMQProducer(Connection connection) {
		this.connection = connection;
	}
	

	@Override
	public MQSendResult sendMessage(MQTopic topic, Serializable msg) {
		MQSendResult result = new MQSendResult();
		try {
			String topciName = MQSetting.VIRTUAL_TOPIC_PREFIX.concat(topic.name());
			//持久化
			Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
			String topicBeanName = "topic-"+topciName;
			Destination destination = springObjectFactory.getNullableBean(topicBeanName, ActiveMQTopic.class);
			if(destination == null){
				destination = new ActiveMQTopic(topciName);
				springObjectFactory.initializeBean(topicBeanName, destination);
			}
			MessageProducer producer = session.createProducer(destination);
			Message message = session.createObjectMessage(msg);
			producer.send(message);
			session.commit();
			result.setSuccess(true);
		} catch (JMSException e) {
			LOGGER.error(e.getMessage(),e);
		}
		return result;
	}
	
	@Override
	public void destory() throws Exception {
		this.connection.close();
	}

}
