package com.asiainfo.gim.monitor.service;

import java.util.List;

import com.asiainfo.gim.monitor.dao.AlertDao;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.entity.Alert;

public class AlertService
{
	private AlertDao alertMetricDao;

	public void setAlertMetricDao(AlertDao alertMetricDao)
	{
		this.alertMetricDao = alertMetricDao;
	}

	public List<Alert> listAlertMetric(AlertQueryParam alertQueryParam){
		return alertMetricDao.listAlertMetric(alertQueryParam);
	}

}
