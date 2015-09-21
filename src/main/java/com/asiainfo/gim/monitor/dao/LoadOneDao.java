package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface LoadOneDao
{
	public void insertLoadOne(Metric metric);
	
	public List<Metric> listLoadOne(MetricQueryParam metricQueryParam);
	
	public void deleteLoadOne(MetricDeleteParam metricDeleteParam);
}
