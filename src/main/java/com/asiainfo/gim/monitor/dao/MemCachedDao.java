package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface MemCachedDao
{
	public void insertMemCached(Metric metric);
	
	public List<Metric> listMemCached(MetricQueryParam metricQueryParam);

}
