package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface DiskFreeDao
{
	public void insertDiskFree(Metric metric);
	
	public List<Metric> listDiskFree(MetricQueryParam metricQueryParam);
	
	public void deleteDiskFree(MetricDeleteParam metricDeleteParam);
}
