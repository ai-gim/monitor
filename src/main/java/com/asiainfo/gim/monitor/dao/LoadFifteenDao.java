package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface LoadFifteenDao
{
	public void insertLoadFifteen(Metric metric);
	
	public List<Metric> listLoadFifteen(MetricQueryParam metricQueryParam);
	
	public void deleteLoadFifteen(MetricDeleteParam metricDeleteParam);

}
