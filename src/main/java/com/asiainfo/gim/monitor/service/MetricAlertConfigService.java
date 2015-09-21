package com.asiainfo.gim.monitor.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.dao.MetricAlertConfigDao;
import com.asiainfo.gim.monitor.domain.MetricAlertConfig;

@Service
public class MetricAlertConfigService
{
	private MetricAlertConfigDao metricAlertConfigDao;

	@Resource
	public void setAlertConfigMetricDao(MetricAlertConfigDao metricAlertConfigDao)
	{
		this.metricAlertConfigDao = metricAlertConfigDao;
	}

	public void addMetricAlertConfig(MetricAlertConfig metricAlertConfig)
	{
		metricAlertConfigDao.insertMetricAlertConfig(metricAlertConfig);
	}

	public MetricAlertConfig getAlertMetricConfigById(String id)
	{
		return metricAlertConfigDao.findMetricAlertConfigById(id);
	}

	public List<MetricAlertConfig> listMetricAlertConfigs()
	{
		return metricAlertConfigDao.listMetricAlertConfigs();
	}

	public MetricAlertConfig updateMetricAlertConfig(MetricAlertConfig metricAlertConfig)
	{
		metricAlertConfigDao.updateMetricAlertConfig(metricAlertConfig);
		return metricAlertConfigDao.findMetricAlertConfigById(metricAlertConfig.getId());
	}

	public void deleteMetricAlertConfig(String id)
	{
		metricAlertConfigDao.deleteMetricAlertConfig(id);
	}

}
