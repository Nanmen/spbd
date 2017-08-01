package com.spbd.order;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.spbd.core.platform.mq.DefaultMQConfig;
import com.spbd.core.platform.mq.consumer.MQConsumeSpec;
@Configuration
public class MQConfig extends DefaultMQConfig{

	@Override
	public void registryConsumer(List<MQConsumeSpec> consumeSpecs) {
//		consumeSpecs.add(new MQConsumeSpec(MQTopic.PRODUCT, messageListenerCls))
		
	}
	
	@Override
	protected String appName() {
		return "ORDER";
	}

}
