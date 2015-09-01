package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface MemBuffersDao
{
	public void insertMemBuffers(Metric metric);
	
	public List<Metric> listMemBuffers(MetricQueryParam metricQueryParam);
}
