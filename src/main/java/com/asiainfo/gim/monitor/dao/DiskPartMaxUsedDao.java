package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface DiskPartMaxUsedDao
{

	public void insertDiskPartMaxUsed(Metric metric);
	
	public List<Metric> listDiskPartMaxUsed(MetricQueryParam metricQueryParam);
}
