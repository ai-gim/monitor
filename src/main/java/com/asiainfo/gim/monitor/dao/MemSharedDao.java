package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface MemSharedDao
{
	public void insertMemShared(Metric metric);
	
	public List<Metric> listMemShared(MetricQueryParam metricQueryParam);
	
	public void deleteMemShared(MetricDeleteParam metricDeleteParam);
}
