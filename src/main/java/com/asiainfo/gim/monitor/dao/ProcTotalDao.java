package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

public interface ProcTotalDao
{
	public void insertProcTotal(Metric metric);
	
	public List<Metric> listProcTotal(MetricQueryParam metricQueryParam);
	
	public void deleteProcTotal(MetricDeleteParam metricDeleteParam);
}
