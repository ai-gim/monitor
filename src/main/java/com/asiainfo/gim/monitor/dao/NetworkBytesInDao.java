package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface NetworkBytesInDao
{
	public void insertNetworkBytesIn(Metric metric);
	
	public List<Metric> listNetworkBytesIn(MonitorQueryParam monitorQueryParam);
}
