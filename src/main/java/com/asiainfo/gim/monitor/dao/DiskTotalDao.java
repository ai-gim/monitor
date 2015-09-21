package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface DiskTotalDao
{
	public void insertDiskTotal(Metric metric);
	
	public List<Metric> listDiskTotal(MetricQueryParam metricQueryParam);
	
	public void deleteDiskTotal(MetricDeleteParam metricDeleteParam);
}
