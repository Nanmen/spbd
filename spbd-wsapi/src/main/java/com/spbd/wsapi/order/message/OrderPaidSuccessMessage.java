package com.spbd.wsapi.order.message;

import java.io.Serializable;

public class OrderPaidSuccessMessage implements Serializable{

	private static final long serialVersionUID = 2499712510253757383L;
	
	private Integer orderId;
	
	public OrderPaidSuccessMessage(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}
	

}
