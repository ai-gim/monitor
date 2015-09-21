package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface NetworkBytesOutDao
{
	public void insertNetworkBytesOut(Metric metric);
	
	public List<Metric> listNetworkBytesOut(MetricQueryParam metricQueryParam);
	
	public void deleteNetworkBytesOut(MetricDeleteParam metricDeleteParam);
}
