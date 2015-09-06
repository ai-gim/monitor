package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface MemSwapTotalDao
{

	public void insertMemSwapTotal(Metric metric);
	
	public List<Metric> listMemSwapTotal(MetricQueryParam metricQueryParam);
	
	public void deleteMemSwapTotal(MetricDeleteParam metricDeleteParam);
}
