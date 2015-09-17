package com.asiainfo.gim.monitor.service;

import java.util.List;

import com.asiainfo.gim.monitor.dao.AlertDao;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.entity.Alert;

public class AlertService
{
	private AlertDao alertDao;

	public void setAlertDao(AlertDao alertDao)
	{
		this.alertDao = alertDao;
	}

	public void addAlert(Alert alert){
		alertDao.insertAlert(alert);
	}

	public Alert findAlertById(String id)
	{
		return alertDao.findAlertById(id);
	}

	public List<Alert> listAlerts(AlertQueryParam alertQueryParam)
	{
		return alertDao.listAlerts(alertQueryParam);
	}
	
	public Alert updateAlert(Alert alert){
		alertDao.updateAlert(alert);
		return alertDao.findAlertById(alert.getId());
	}
	
	public void deleteAlert(String id){
		alertDao.deleteAlert(id);
	}
}
