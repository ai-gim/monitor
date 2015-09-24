package com.asiainfo.gim.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.dao.AlertConfigDao;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;

@Service
public class AlertConfigService
{
	private AlertConfigDao alertConfigDao;

	@Resource
	public void setAlertConfigDao(AlertConfigDao alertConfigDao)
	{
		this.alertConfigDao = alertConfigDao;
	}

	public void addAlertConfigDao(AlertConfig alertConfig)
	{
		alertConfigDao.insertAlertConfig(alertConfig);
	}

	public AlertConfig findAlertConfigById(int id)
	{
		return alertConfigDao.findAlertConfigById(id);
	}

	public List<AlertConfig> listAlertConfigs(AlertConfigQueryParam alertConfigQueryParam)
	{
		return alertConfigDao.listAlertConfigs(alertConfigQueryParam);
	}

	public AlertConfig updateAlertConfig(AlertConfig alertConfig)
	{
		alertConfigDao.updateAlertConfig(alertConfig);
		return alertConfigDao.findAlertConfigById(alertConfig.getId());
	}

	public void deleteAlertConfig(int id)
	{
		alertConfigDao.deleteAlertConfig(id);
	}

}
