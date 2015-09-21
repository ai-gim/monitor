package com.asiainfo.gim.monitor.dao;


import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface CpuUserDao
{

	public void insertCpuUser(Metric metric);
	
	public List<Metric> listCpuUser(MetricQueryParam metricQueryParam);
	
	public void deleteCpuUser(MetricDeleteParam metricDeleteParam);
}
