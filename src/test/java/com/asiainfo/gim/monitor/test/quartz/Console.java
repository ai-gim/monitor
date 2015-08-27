package com.asiainfo.gim.monitor.test.quartz;

public class Console
{

	public static void main(String[] args) throws Exception
	{
		String jobName = "这就是我的job";
		String triggerName = "这就是我的trigger";
		QuartzManager.addJob(jobName, triggerName, "0/1 * * * * ?");
		Thread.sleep(5000);

		System.err.println("变了！！！！！！！！！！！！！！！！");

		QuartzManager.modifyJob(triggerName, "*/10 * * * * ?");
	}

}
