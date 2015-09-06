package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface CpuSpeedDao
{

	public void insertCpuSpeed(Metric metric);
	
	public List<Metric> listCpuSpeed(MetricQueryParam metricQueryParam);
	
	public void deleteCpuSpeed(MetricDeleteParam metricDeleteParam);
}
