package com.spbd.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderStartup {
	public static void main( String[] args) {
		SpringApplication application = new SpringApplication(OrderStartup.class);
		application.run(args);
    }
}
