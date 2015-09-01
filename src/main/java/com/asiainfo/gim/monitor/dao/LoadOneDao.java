package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface LoadOneDao
{
	public void insertLoadOne(Metric metric);
	
	public List<Metric> listLoadOne(MetricQueryParam metricQueryParam);
}
