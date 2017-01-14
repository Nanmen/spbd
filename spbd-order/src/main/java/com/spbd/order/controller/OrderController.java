package com.spbd.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spbd.order.model.Order;
import com.spbd.order.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("/hello")
	public Object hello(){
		return "hello spring boot";
	}
	
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public Object addOrder(Order order){
		int result = orderService.addOrder(order);
		if(result > 0){
			return "添加成功";
		}
		return "添加失败";
	}
	
	@RequestMapping(value="/order",method=RequestMethod.PUT)
	public Object modifyOrder(Order order){
		int result = orderService.modifyOrder(order);
		if(result > 0){
			return "修改成功";
		}
		return "修改失败";
	}
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.GET)
	public Object getOrder(@PathVariable("id")Integer id){
		return orderService.getOrder(id);
	}
	
	@RequestMapping(value="order",method=RequestMethod.GET)
	public Object getOrderList(){
		return orderService.getOrderList();
	}
	
}
