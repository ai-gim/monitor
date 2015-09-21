package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface NetworkPktsOutDao
{
	public void insertNetworkPktsOut(Metric metric);
	
	public List<Metric> listNetworkPktsOut(MetricQueryParam metricQueryParam);
	
	public void deleteNetworkPktsOut(MetricDeleteParam metricDeleteParam);
}
