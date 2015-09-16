package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.entity.AlertConfigMetric;

public interface AlertConfigMetricDao
{
	
	public void insertAlertConfig(AlertConfigMetric alertConfig);
	
	public List<AlertConfigMetric> listAlertConfig(AlertConfigQueryParam alertConfigQueryParam);

}
