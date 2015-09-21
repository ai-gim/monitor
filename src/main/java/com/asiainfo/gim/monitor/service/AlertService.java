package com.asiainfo.gim.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.alert.CurrentAlertCache;
import com.asiainfo.gim.monitor.dao.AlertDao;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;

@Service
public class AlertService
{
	private AlertDao alertDao;
	private CurrentAlertCache currentAlertCache;

	@Resource
	public void setCurrentAlertCache(CurrentAlertCache currentAlertCache)
	{
		this.currentAlertCache = currentAlertCache;
	}

	@Resource
	public void setAlertDao(AlertDao alertDao)
	{
		this.alertDao = alertDao;
	}

	public void addAlert(Alert alert)
	{
		alert.setStatus(0);
		alertDao.insertAlert(alert);
		currentAlertCache.put(alert);
	}

	public Alert findAlertById(String id)
	{
		return alertDao.findAlertById(id);
	}

	public List<Alert> listAlerts(AlertQueryParam alertQueryParam)
	{
		return alertDao.listAlerts(alertQueryParam);
	}

	public Alert updateAlert(Alert alert)
	{
		alertDao.updateAlert(alert);
		return alertDao.findAlertById(alert.getId());
	}

	public void deleteAlert(String id)
	{
		alertDao.deleteAlert(id);
	}
}
