package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface NetworkBytesInDao
{
	public void insertNetworkBytesIn(Metric metric);
	
	public List<Metric> listNetworkBytesIn(MetricQueryParam metricQueryParam);
	
	public void deleteNetworkBytesIn(MetricDeleteParam metricDeleteParam);
}
