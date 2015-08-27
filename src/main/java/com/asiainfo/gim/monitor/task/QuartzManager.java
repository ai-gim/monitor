package com.asiainfo.gim.monitor.task;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

import com.asiainfo.gim.monitor.task.CollectJob;

public class QuartzManager
{
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	private static String jobGroup = "monitorJobGroup";
	
	public static void addJob(String jobName, String triggerName, String timeExpression){
		try
		{
			Scheduler scheduler = schedulerFactory.getScheduler();
			JobDetail jobDetail = JobBuilder.newJob(CollectJob.class).withIdentity(jobName, jobGroup).build();
			CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, jobGroup).
					withSchedule(CronScheduleBuilder.cronSchedule(timeExpression)).build();
			scheduler.scheduleJob(jobDetail, trigger);
			scheduler.start();
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void modifyJob(String triggerName, String newExpression){
		try
		{
			TriggerKey triggerKey = new TriggerKey(triggerName, jobGroup);
			Scheduler scheduler = schedulerFactory.getScheduler();
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if(trigger == null){
				return;
			}
			String oldTimeExpression = trigger.getCronExpression();
			if(!newExpression.equals(oldTimeExpression)){
				CronTrigger newTrigger = trigger.getTriggerBuilder().withSchedule(CronScheduleBuilder.
						cronSchedule(newExpression)).build();
				scheduler.rescheduleJob(triggerKey, newTrigger);
			}
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}
}
