package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Task;
import com.example.demo.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobAndTriggerMapper;
import com.example.demo.entity.JobAndTrigger;
import com.example.demo.service.JobAndTriggerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


@Service
public class JobAndTriggerImpl implements JobAndTriggerService {
	int i = 1;

	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;
	
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
		PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
		return page;
	}

	@Override
	public void addTask(Task task) throws SchedulerException {
		SchedulerFactory schedFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedFactory.getScheduler();

		JobDetail jobDetail = newJob(HelloJob.class)
				.withIdentity("myJob", "group1")
				.build();

		CronTrigger trigger = newTrigger().withIdentity("trigger"+i, "group1")
				.withSchedule(CronScheduleBuilder.cronSchedule(task.getCronExpression())).usingJobData("type",task.getType()).build();

		i++;
		scheduler.scheduleJob(jobDetail, trigger);
	}

}