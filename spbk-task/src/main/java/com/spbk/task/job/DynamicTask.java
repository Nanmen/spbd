package com.spbk.task.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.spbk.task.model.TimingTask;

@Component
public class DynamicTask {
	
	private final static Logger LOGGER =Logger.getLogger(DynamicTaskRunable.class);
	@Autowired
	private DynamicTaskConfigurer dynamicTaskConfigurer;

	@Scheduled(cron="0/30 * * * * ?")
	public void loadTasks(){
		LOGGER.info("DynamicTask 正在执行......");
		//从数据库查询
		List<TimingTask> tasks = new ArrayList<TimingTask>();
		dynamicTaskConfigurer.refreshTasks(tasks);
	}
}
