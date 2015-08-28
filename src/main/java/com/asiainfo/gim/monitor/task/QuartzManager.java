package com.asiainfo.gim.monitor.task;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzManager
{
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	private static String jobGroup = "monitorJobGroup";
	
	
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
