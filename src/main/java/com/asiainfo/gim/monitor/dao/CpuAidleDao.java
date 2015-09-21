package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface CpuAidleDao
{

	public void insertCpuAidle(Metric metric);
	
	public List<Metric> listCpuAidle(MetricQueryParam metricQueryParam);
	
	public void deleteCpuAidle(MetricDeleteParam metricDeleteParam);
	
}
