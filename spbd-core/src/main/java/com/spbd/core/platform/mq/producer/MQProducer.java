package com.spbd.core.platform.mq.producer;

import java.io.Serializable;

import com.spbd.core.platform.mq.MQSendResult;
import com.spbd.core.platform.mq.MQTopic;

public interface MQProducer {

	MQSendResult sendMessage(MQTopic topic, Serializable msg);
	
	void destory() throws Exception;
	
}
