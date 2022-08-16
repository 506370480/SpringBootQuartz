package com.example.demo.service;


import com.example.demo.entity.JobAndTrigger;
import com.example.demo.entity.Task;
import com.github.pagehelper.PageInfo;
import org.quartz.SchedulerException;

public interface JobAndTriggerService {
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);

	void addTask(Task task) throws SchedulerException;
}
