package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface CpuIdleDao
{
	public void insertCpuIdle(Metric metric);

	public List<Metric> listCpuIdle(MetricQueryParam metricQueryParam);
	
	public void deleteCpuIdle(MetricDeleteParam metricDeleteParam);
}
