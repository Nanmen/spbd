package com.spbd.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.spbd.core.web.filter.AuthFilter;

//@ImportResource({"classpath:dubbo/dubbo-config.xml"})
@SpringBootApplication
public class OrderStartup {
	public static void main( String[] args) {
		SpringApplication application = new SpringApplication(OrderStartup.class);
		application.run(args);
    }
	
	@Bean
	public FilterRegistrationBean authFilter(){
		AuthFilter authFilter = new AuthFilter();
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(authFilter);
		List<String> urlPatterns=new ArrayList<String>();
		urlPatterns.add("/*");
		filterRegistrationBean.setUrlPatterns(urlPatterns);
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
		
	} 
}
