package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface NetworkPktsInDao
{
	public void insertNetworkPktsIn(Metric metric);
	
	public List<Metric> listNetworkPktsIn(MetricQueryParam metricQueryParam);
	
	public void deleteNetworkPktsIn(MetricDeleteParam metricDeleteParam);
}
