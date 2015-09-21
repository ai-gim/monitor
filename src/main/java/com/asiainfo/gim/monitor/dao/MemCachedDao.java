package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface MemCachedDao
{
	public void insertMemCached(Metric metric);
	
	public List<Metric> listMemCached(MetricQueryParam metricQueryParam);
	
	public void deleteMemCached(MetricDeleteParam metricDeleteParam);

}
