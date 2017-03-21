package com.spbk.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@ImportResource({"classpath:dubbo/dubbo-config.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})  	
@SpringBootApplication
@EnableScheduling
public class TaskStartup {
	public static void main( String[] args) {
		SpringApplication application = new SpringApplication(TaskStartup.class);
		application.run(args);
    }
}
