package com.spbk.task.job;

public class DynamicTaskRunable implements Runnable{
	
	private Integer taskId;
	
	public DynamicTaskRunable(Integer taskId) {
		this.taskId = taskId;
	}
	@Override
	public void run() {
		
	}

	public Integer getTaskId() {
		return taskId;
	}
}
