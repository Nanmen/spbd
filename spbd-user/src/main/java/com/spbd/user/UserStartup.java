package com.spbd.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:dubbo/dubbo-config.xml"})
@SpringBootApplication
public class UserStartup {
	public static void main( String[] args) {
		SpringApplication application = new SpringApplication(UserStartup.class);
		application.run(args);
    }
}
