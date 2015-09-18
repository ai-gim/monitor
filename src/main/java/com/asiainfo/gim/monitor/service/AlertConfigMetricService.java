package com.asiainfo.gim.monitor.service;

import java.util.List;

import com.asiainfo.gim.monitor.dao.AlertConfigMetricDao;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.entity.AlertConfigMetric;

public class AlertConfigMetricService
{
	private AlertConfigMetricDao alertConfigMetricDao;

	public void setAlertConfigMetricDao(AlertConfigMetricDao alertConfigMetricDao)
	{
		this.alertConfigMetricDao = alertConfigMetricDao;
	}

	public void addAlertConfigMetric(AlertConfigMetric alertConfigMetric)
	{
		alertConfigMetricDao.insertAlertMetricConfig(alertConfigMetric);
	}

	public AlertConfigMetric getAlertConfigMetricById(String id)
	{
		return alertConfigMetricDao.findAlertMetricConfigById(id);
	}

	public List<AlertConfigMetric> getAlertConfigMetrics(AlertConfigQueryParam alertConfigQueryParam)
	{
		return alertConfigMetricDao.listAlertMetricConfigs(alertConfigQueryParam);
	}

	public AlertConfigMetric updateAlertConfigMetric(AlertConfigMetric alertConfigMetric)
	{
		alertConfigMetricDao.updateAlertMetricConfig(alertConfigMetric);
		return alertConfigMetricDao.findAlertMetricConfigById(alertConfigMetric.getId());
	}

	public void deleteAlertConfigMetric(String id)
	{
		alertConfigMetricDao.deleteAlertMetricConfig(id);
	}

}
