package com.spbd.order.ws;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spbd.order.model.Order;
import com.spbd.order.service.OrderService;
import com.spbd.wsapi.order.IOrderService;
import com.spbd.wsapi.order.response.OrderResponse;
@Service
public class OrderWSService implements IOrderService{
	@Autowired
	private OrderService orderService; 

	@Override
	public OrderResponse getOrderById(Integer id) {
		Order order = orderService.getOrder(id);
		if(order != null){
			OrderResponse orderResponse = new OrderResponse();
			BeanUtils.copyProperties(order, orderResponse);
			return orderResponse;
		}
		return null;
	}

}
