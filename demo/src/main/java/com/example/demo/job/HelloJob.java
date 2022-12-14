package com.example.demo.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;   
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
public class HelloJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);  
     
    public HelloJob() {  
          
    }  
     
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Job执行时间: " + new SimpleDateFormat("hh:mm:ss").format(new Date()) +"  "+context.getTrigger().toString()+"type: "+context.getMergedJobDataMap().get("type"));
    }  
}  
