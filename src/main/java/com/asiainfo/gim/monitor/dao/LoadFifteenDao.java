package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface LoadFifteenDao
{
	public void insertLoadFifteen(Metric metric);
	
	public List<Metric> listLoadFifteen(MonitorQueryParam monitorQueryParam);

}
