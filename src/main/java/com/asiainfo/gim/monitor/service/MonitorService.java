package com.asiainfo.gim.monitor.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.dao.CpuUserDao;
import com.asiainfo.gim.monitor.entity.Metric;

@Service
public class MonitorService
{
	CpuUserDao cpuUsedDao;

	@Resource
	public void setCpuUsedDao(CpuUserDao cpuUsedDao)
	{
		this.cpuUsedDao = cpuUsedDao;
	}
	
	
	public void insertCpuUsed(Metric metric){
		cpuUsedDao.insertCpuUser(metric);
	}
	
}
