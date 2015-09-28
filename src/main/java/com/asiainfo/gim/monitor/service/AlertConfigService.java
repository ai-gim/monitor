package com.asiainfo.gim.monitor.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.alert.AlertDriver;
import com.asiainfo.gim.monitor.dao.AlertConfigDao;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;

@Service
public class AlertConfigService
{
	private AlertConfigDao alertConfigDao;
	private AlertDriver alertDriver;

	@Resource
	public void setAlertConfigDao(AlertConfigDao alertConfigDao)
	{
		this.alertConfigDao = alertConfigDao;
	}

	@Resource
	public void setAlertDriver(AlertDriver alertDriver)
	{
		this.alertDriver = alertDriver;
	}

	public AlertConfig addAlertConfig(AlertConfig alertConfig)
	{
		if (StringUtils.isEmpty(alertConfig.getId()))
		{
			alertConfig.setId(UUID.randomUUID().toString());
		}
		alertConfigDao.insertAlertConfig(alertConfig);
		alertDriver.initAlertChecker(alertConfig);
		return alertConfig;
	}

	public AlertConfig findAlertConfigById(String id)
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
		alertDriver.initAlertChecker(alertConfig);
		return alertConfigDao.findAlertConfigById(alertConfig.getId());
	}

	public void deleteAlertConfig(String id)
	{
		alertDriver.removeAlertChecker(id);
		alertConfigDao.deleteAlertConfig(id);
	}

}
