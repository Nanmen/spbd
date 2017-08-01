package com.spbd.core.platform.mq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.spbd.core.platform.SpringObjectFactory;
import com.spbd.core.platform.mq.consumer.MQConsumeSpec;
import com.spbd.core.platform.mq.consumer.MQConsumerBuilder;
import com.spbd.core.platform.mq.producer.MQProducerBuilder;

public abstract class DefaultMQConfig implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;

	private SpringObjectFactory springObjectFactory;
	@Bean
	public MQClient mqClient() throws Exception{
		return new MQClient(new MQProducerBuilder(springObjectFactory).buildeMQProducer(mqSetting()));
	}
	
	@Bean
	public MQSetting mqSetting(){
		MQSetting setting = new MQSetting();
//		Environment env = applicationContext.getEnvironment();
//		setting.setMqType(MQType.ACTIVEMQ);
//		setting.setUrl(env.getRequiredProperty(""));
//		setting.setUserName("admin");
//		setting.setPassword("admin");
		return setting;
	}
	
	@Bean
	public MQConsumerBuilder mqConsumerBuilder() throws Exception{
		List<MQConsumeSpec> consumeSpecs = new ArrayList<MQConsumeSpec>();
		registryConsumer(consumeSpecs);
		MQConsumerBuilder  builder = new MQConsumerBuilder(appName(), mqSetting(), consumeSpecs);
		return builder;
	}
	
	public abstract void registryConsumer(List<MQConsumeSpec> consumeSpecs);
	
	protected String appName() {
		return null;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.applicationContext = context;
		this.springObjectFactory = context.getBean(SpringObjectFactory.class);
	}
}
