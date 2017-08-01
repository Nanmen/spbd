package com.spbd.core.platform.mq.consumer;

import javax.jms.MessageListener;

import com.spbd.core.platform.mq.MQTopic;

public class MQConsumeSpec {

	private MQTopic mqTopic;
	
	private Class<? extends MessageListener> messageListenerCls;
	
	public MQConsumeSpec() {

	}

	public MQConsumeSpec(MQTopic mqTopic, Class<? extends MessageListener> messageListenerCls) {
		this.mqTopic = mqTopic;
		this.messageListenerCls = messageListenerCls;
	}



	public MQTopic getMqTopic() {
		return mqTopic;
	}

	public void setMqTopic(MQTopic mqTopic) {
		this.mqTopic = mqTopic;
	}

	public Class<? extends MessageListener> getMessageListenerCls() {
		return messageListenerCls;
	}

	public void setMessageListenerCls(Class<? extends MessageListener> messageListenerCls) {
		this.messageListenerCls = messageListenerCls;
	}
	
}
