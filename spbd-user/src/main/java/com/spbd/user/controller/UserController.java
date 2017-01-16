package com.spbd.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spbd.wsapi.order.IOrderService;

@RequestMapping("/user")
@RestController
public class UserController {
	@Reference
	private IOrderService orderService;
	
	@RequestMapping("/order/{id}")
	public Object hello(@PathVariable("id")Integer id){
		return orderService.getOrderById(id);
	}

}
