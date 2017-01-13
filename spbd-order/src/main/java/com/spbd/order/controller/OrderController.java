package com.spbd.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@RequestMapping("/hello")
	public Object hello(){
		return "hello spring boot";
	}
}
