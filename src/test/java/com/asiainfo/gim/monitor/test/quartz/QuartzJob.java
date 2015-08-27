package com.asiainfo.gim.monitor.test.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job
{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		System.out.println("jobName=" + context.getJobDetail().getKey().getName() + "   " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		.format(new Date()) + "★★★★★★★★★★★");
	}

	
}
