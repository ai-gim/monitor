package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;

public interface ProcRunDao
{
	public void insertProcRun(Metric metric);
	
	public List<Metric> listProcRun(MetricQueryParam metricQueryParam);
	
	public void deleteProcRun(MetricDeleteParam metricDeleteParam);

}
