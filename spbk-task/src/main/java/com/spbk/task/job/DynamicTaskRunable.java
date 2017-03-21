package com.spbk.task.job;

import org.apache.log4j.Logger;

public class DynamicTaskRunable implements Runnable{
	
	private final static Logger LOGGER =Logger.getLogger(DynamicTaskRunable.class);
	
	private Integer taskId;
	
	public DynamicTaskRunable(Integer taskId) {
		this.taskId = taskId;
	}
	@Override
	public void run() {
		LOGGER.info("DynamicTaskRunable is running, taskId："+taskId);
	}

	public Integer getTaskId() {
		return taskId;
	}
}
