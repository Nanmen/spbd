package com.spbd.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spbd.order.mapper.OrderMapper;
import com.spbd.order.model.Order;

@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	public int addOrder(Order order){
		return orderMapper.insertSelective(order);
	}
	
	public Order getOrder(int id){
		return orderMapper.selectByPrimaryKey(id);
	}
	public List<Order> getOrderList(){
		return orderMapper.getOrderList();
	}
	
	public int modifyOrder(Order order){
		return orderMapper.updateByPrimaryKeySelective(order);
	}
	
	public int deleteOrder(int id){
		return orderMapper.deleteByPrimaryKey(id);
	}
	
}
