package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface CpuNiceDao
{
	public void insertCpuNice(Metric metric);

	public List<Metric> listCpuNice(MetricQueryParam metricQueryParam);
	
	public void deleteCpuNice(MetricDeleteParam metricDeleteParam);
}
