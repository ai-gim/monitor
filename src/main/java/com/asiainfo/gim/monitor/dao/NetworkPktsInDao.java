package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface NetworkPktsInDao
{
	public void insertNetworkPktsIn(Metric metric);
	
	public List<Metric> listNetworkPktsIn(MonitorQueryParam monitorQueryParam);
}
