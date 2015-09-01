package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface NetworkBytesOutDao
{
	public void insertNetworkBytesOut(Metric metric);
	
	public List<Metric> listNetworkBytesOut(MonitorQueryParam monitorQueryParam);
}
