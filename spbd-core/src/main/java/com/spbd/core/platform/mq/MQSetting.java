package com.spbd.core.platform.mq;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class MQSetting {
	
	public static final String CONSUMER_PRIFIX = "Consumer.";
	// 虚拟主题
	public static final String VIRTUAL_TOPIC_PREFIX = "VirtualTopic.";

	private MQType mqType = MQType.ACTIVEMQ;
	@Value("${spring.activemq.broker-url}")
	private String url;
	@Value("${spring.activemq.user}")
	private String userName;
	@Value("${spring.activemq.password}")
	private String password;
	
	private Map<String,Object> extra = new HashMap<String,Object>();
	
	public MQSetting() {
		
	}
	
	public MQType getMqType() {
		return mqType;
	}
	
	public void setMqType(MQType mqType) {
		this.mqType = mqType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getExtra() {
		return extra;
	}

	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
	
	public void put(String key,Object value){
		this.extra.put(key, value);
	}
	
	public Object get(String key){
		return this.extra.get(key);
	}
}
