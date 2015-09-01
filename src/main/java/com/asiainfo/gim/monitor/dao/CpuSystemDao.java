package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface CpuSystemDao
{

	public void insertCpuSystem(Metric metric);
	
	public List<Metric> listCpuSystem(MonitorQueryParam monitorQueryParam);
}
