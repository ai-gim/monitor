package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface LoadFiveDao
{
	public void insertLoadFive(Metric metric);
	
	public List<Metric> listLoadFive(MetricQueryParam metricQueryParam);
	
	public void deleteLoadFive(MetricDeleteParam metricDeleteParam);
}
