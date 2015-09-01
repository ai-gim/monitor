package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface DiskTotalDao
{
	public void insertDiskTotal(Metric metric);
	
	public List<Metric> listDiskTotal(MetricQueryParam metricQueryParam);
}
