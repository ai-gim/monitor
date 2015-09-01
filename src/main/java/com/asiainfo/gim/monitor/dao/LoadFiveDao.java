package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface LoadFiveDao
{
	public void insertLoadFive(Metric metric);
	
	public List<Metric> listLoadFive(MonitorQueryParam monitorQueryParam);
}
