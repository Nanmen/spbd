package com.spbd.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.spbd.order.model.Order;
import com.spbd.order.service.OrderService;
import com.spbd.order.vo.OrderVo;
import com.spbd.wsapi.user.IUserService;
import com.spbd.wsapi.user.response.UserResponse;

@RestController
public class OrderController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class); 
	@Autowired
	private OrderService orderService;
	
	@Reference(lazy=true)
	private IUserService iUserService;
	

	@RequestMapping("/hello")
	public Object hello(){
		return "hello spring boot";
	}
	
	@RequestMapping(value="/order",method=RequestMethod.POST)
	public Object addOrder(@RequestBody Order order){
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
		
		Order order = orderService.getOrder(id);
		if(order != null){
			OrderVo orderVo = new OrderVo();
			BeanUtils.copyProperties(order, orderVo);
			UserResponse userResponse = iUserService.getUserById(order.getUserId());
			orderVo.setUserInfo(userResponse);
			return orderVo;
		}
		return null;
	}
	
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public Object getOrderList(){
		return orderService.getOrderList();
	}
	
	
	@RequestMapping(value="/order/{id}",method=RequestMethod.DELETE)
	public Object deleteOrder(@PathVariable("id")Integer id){
		int result = orderService.deleteOrder(id);
		if(result > 0){
			return "删除成功";
		}
		return "删除失败";
	}
}
