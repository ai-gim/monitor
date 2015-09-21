package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface CpuSystemDao
{

	public void insertCpuSystem(Metric metric);
	
	public List<Metric> listCpuSystem(MetricQueryParam metricQueryParam);
	
	public void deleteCpuSystem(MetricDeleteParam metricDeleteParam);
}
