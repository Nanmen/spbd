package com.spbd.core.platform.mq;

import java.io.Serializable;

public class MQSendResult implements Serializable{

	private static final long serialVersionUID = -2947920963638783891L;
	
	private boolean success;
	
	public MQSendResult() {

	}
	
	public MQSendResult(boolean success) {
		this.success = success;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
