package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.MetricAlertConfig;

public interface MetricAlertConfigDao
{

	public void insertMetricAlertConfig(MetricAlertConfig metricAlertConfig);

	public List<MetricAlertConfig> listMetricAlertConfigs();

	public MetricAlertConfig findMetricAlertConfigById(String id);

	public void updateMetricAlertConfig(MetricAlertConfig metricAlertConfig);

	public void deleteMetricAlertConfig(String id);

}
