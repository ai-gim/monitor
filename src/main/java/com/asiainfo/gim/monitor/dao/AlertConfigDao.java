package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;

public interface AlertConfigDao
{

	public void insertAlertConfig(AlertConfig alertConfig);

	public List<AlertConfig> listAlertConfigs(AlertConfigQueryParam alertConfigParam);

	public AlertConfig findAlertConfigById(String id);

	public void updateAlertConfig(AlertConfig alertConfig);

	public void deleteAlertConfig(String id);

}
