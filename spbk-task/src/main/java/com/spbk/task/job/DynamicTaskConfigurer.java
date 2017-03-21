package com.spbk.task.job;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PreDestroy;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.spbk.task.model.TimingTask;
@Component
public class DynamicTaskConfigurer implements SchedulingConfigurer {
	
	private volatile ScheduledTaskRegistrar registrar;
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar registrar) {
		this.registrar = registrar;
	}
	
	public void refreshTasks(List<TimingTask> tasks){
		//取消已经删除的策略任务
		for (TimingTask tt : tasks) {
			//判断
			if(hasTask(tt.getTaskId())){
				DynamicTaskRunable t = new DynamicTaskRunable(tt.getTaskId());
				String expression = tt.getExpression();
				CronTask task = new CronTask(t, expression);
				registrar.addCronTask(task);
			}
		}
	}
	
	private boolean hasTask(Integer taskId){
		List<CronTask> taskList = registrar.getCronTaskList();
		for (CronTask cronTask : taskList) {
			if(cronTask.getRunnable() instanceof DynamicTaskRunable){
				DynamicTaskRunable r = (DynamicTaskRunable) cronTask.getRunnable();
				if(r.getTaskId().equals(taskId)){
					return true;
				}
			}
		}
		return false;
	}
	
	@PreDestroy
	public void destroy() {
		this.registrar.destroy();
	}
}
