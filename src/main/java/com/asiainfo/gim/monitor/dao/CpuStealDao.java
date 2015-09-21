package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface CpuStealDao
{
	public void insertCpuSteal(Metric metric);
	
	public List<Metric> listCpuSteal(MetricQueryParam metricQueryParam);
	
	public void deleteCpuSteal(MetricDeleteParam metricDeleteParam);

}
