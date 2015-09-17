package com.asiainfo.gim.monitor.service;

import java.util.ArrayList;
import java.util.List;

import com.asiainfo.gim.monitor.dao.AlertConfigMetricDao;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.entity.AlertConfigBase;

public class AlertConfigService
{
	private AlertConfigMetricDao alertConfigDao;

	public void setAlertConfigDao(AlertConfigMetricDao alertConfigDao)
	{
		this.alertConfigDao = alertConfigDao;
	}

	public AlertConfigBase insertAlertConfig(AlertConfigBase alertConfigBase)
	{
		return new AlertConfigBase();
	}

	public List<AlertConfigBase> listAlertConfig(AlertConfigQueryParam alertConfigQueryParam)
	{
		return new ArrayList<AlertConfigBase>();
	}

	public void updateAlertConfig(AlertConfigBase alertConfigBase)
	{

	}

	public void deleteAlertConfig(String id)
	{

	}

}
