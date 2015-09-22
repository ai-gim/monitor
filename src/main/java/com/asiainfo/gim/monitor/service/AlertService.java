package com.asiainfo.gim.monitor.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.Constants.AlertStatus;
import com.asiainfo.gim.monitor.dao.AlertDao;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;

@Service
public class AlertService
{
	private AlertDao alertDao;

	@Resource
	public void setAlertDao(AlertDao alertDao)
	{
		this.alertDao = alertDao;
	}

	public void addAlert(Alert alert)
	{
		alert.setStatus(0);
		if(StringUtils.isEmpty(alert.getId()))
		{
			alert.setId(UUID.randomUUID().toString());
		}
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
	
	public void confirmAlert(Alert alert)
	{
		alert.setStatus(AlertStatus.CONFIRMED);
		alertDao.updateAlert(alert);
	}

	public void deleteAlert(String id)
	{
		alertDao.deleteAlert(id);
	}
}
