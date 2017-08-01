package com.spbd.core.platform.mq;

import java.io.Serializable;

import org.springframework.beans.factory.DisposableBean;

import com.spbd.core.platform.mq.producer.MQProducer;

public class MQClient implements DisposableBean{
	
	private MQProducer mqProducer;
	
	public MQClient(MQProducer mqProducer) {
		this.mqProducer = mqProducer;
	}
	
	public MQSendResult sendMessage(MQTopic topic, Serializable msg){
		return mqProducer.sendMessage(topic, msg);
	}

	@Override
	public void destroy() throws Exception {
		mqProducer.destory();
	}
}
