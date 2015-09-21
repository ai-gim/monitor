package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface MemTotalDao
{

	public void insertMemTotal(Metric metric);
	
	public List<Metric> listMemTotal(MetricQueryParam metricQueryParam);
	
	public void deleteMemTotal(MetricDeleteParam metricDeleteParam);
}
