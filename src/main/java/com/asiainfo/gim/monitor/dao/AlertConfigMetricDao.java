package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.entity.AlertConfigMetric;

public interface AlertConfigMetricDao
{

	public void insertAlertMetricConfig(AlertConfigMetric alertConfigMetric);

	public List<AlertConfigMetric> listAlertMetricConfigs(AlertConfigQueryParam alertConfigQueryParam);

	public AlertConfigMetric findAlertMetricConfigById(String id);

	public void updateAlertMetricConfig(AlertConfigMetric alertConfigMetric);

	public void deleteAlertMetricConfig(String id);

}
