package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface DiskPartMaxUsedDao
{

	public void insertDiskPartMaxUsed(Metric metric);
	
	public List<Metric> listDiskPartMaxUsed(MetricQueryParam metricQueryParam);
	
	public void deleteDiskPartMaxUsed(MetricDeleteParam metricDeleteParam);
}
