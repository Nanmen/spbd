package com.spbd.core.platform;

import org.springframework.context.annotation.Bean;

public class DefaultAppConfig {

	@Bean
	public SpringObjectFactory springObjectFactory(){
		return new SpringObjectFactory();
	}
}
