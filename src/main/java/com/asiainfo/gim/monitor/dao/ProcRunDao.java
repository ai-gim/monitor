package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface ProcRunDao
{
	public void insertProcRun(Metric metric);
	
	public List<Metric> listProcRun(MonitorQueryParam monitorQueryParam);

}
