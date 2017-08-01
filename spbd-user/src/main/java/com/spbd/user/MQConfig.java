package com.spbd.user;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.spbd.core.platform.mq.DefaultMQConfig;
import com.spbd.core.platform.mq.MQTopic;
import com.spbd.core.platform.mq.consumer.MQConsumeSpec;
import com.spbd.user.common.message.listener.OrderPaidSuccessListener;
@Configuration
public class MQConfig extends DefaultMQConfig{

	@Override
	public void registryConsumer(List<MQConsumeSpec> consumeSpecs) {
		consumeSpecs.add(new MQConsumeSpec(MQTopic.ORDER, OrderPaidSuccessListener.class));
		
	}
	
	@Override
	protected String appName() {
		return "ORDER";
	}

}
