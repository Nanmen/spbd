package com.spbd.wsapi.order;

import com.spbd.wsapi.order.response.OrderResponse;

public interface IOrderService {

	
	public OrderResponse getOrderById(Integer id);
	
}
