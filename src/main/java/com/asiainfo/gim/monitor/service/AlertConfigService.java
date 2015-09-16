package com.asiainfo.gim.monitor.service;

import java.util.List;

import com.asiainfo.gim.monitor.dao.AlertConfigMetricDao;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.entity.AlertConfigMetric;

public class AlertConfigService
{
	private AlertConfigMetricDao alertConfigDao;

	public void setAlertConfigDao(AlertConfigMetricDao alertConfigDao)
	{
		this.alertConfigDao = alertConfigDao;
	}
	
	public List<AlertConfigMetric> listAlertConfig(AlertConfigQueryParam alertConfigQueryParam){
		return alertConfigDao.listAlertConfig(alertConfigQueryParam);
	}

}
