package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface CpuIdleDao
{
	public void insertCpuIdle(Metric metric);

	public List<Metric> listCpuIdle(MonitorQueryParam monitorQueryParam);
}
