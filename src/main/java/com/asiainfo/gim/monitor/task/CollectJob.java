package com.asiainfo.gim.monitor.task;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.asiainfo.gim.monitor.entity.SysXmlEntity;
import com.asiainfo.gim.monitor.ganglia.GangliaFetchXml;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlParser;


public class CollectJob implements Job
{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
//		List<SysXmlEntity> list = GangliaXmlParser.doResolve(GangliaFetchXml.fetchGangliaXml());
		System.out.println("quartz job");
	}

}
