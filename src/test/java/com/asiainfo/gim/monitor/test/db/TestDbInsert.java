package com.asiainfo.gim.monitor.test.db;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.gim.monitor.dao.CpuUserDao;
import com.asiainfo.gim.monitor.entity.Metric;
import com.asiainfo.gim.monitor.service.MonitorService;

public class TestDbInsert
{

	public static void main(String[] args)
	{
		// 初始化Spring
		String[] springConfigFiles = { "spring-base.xml", "spring-db.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfigFiles);
		MonitorService monitorService = (MonitorService) context.getBean(MonitorService.class);
		Metric metric = new Metric();
		metric.setIp("11.11.11.1");
		metric.setName("name");
		metric.setTime(new Date());
		metric.setUnit("单位");
		float r = 1.33f;
		metric.setValue(r);
		monitorService.insertCpuUsed(metric);
		
		System.err.println("end.....................");
	}
}
