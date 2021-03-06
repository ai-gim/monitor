package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface MemBuffersDao
{
	public void insertMemBuffers(Metric metric);
	
	public List<Metric> listMemBuffers(MetricQueryParam metricQueryParam);
	
	public void deleteMemBuffers(MetricDeleteParam metricDeleteParam);
}
