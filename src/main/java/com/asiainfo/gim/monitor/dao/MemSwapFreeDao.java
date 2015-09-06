package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface MemSwapFreeDao
{

	public void insertMemSwapFree(Metric metric);
	
	public List<Metric> listMemSwapFree(MetricQueryParam metricQueryParam);
	
	public void deleteMemSwapFree(MetricDeleteParam metricDeleteParam);
}
