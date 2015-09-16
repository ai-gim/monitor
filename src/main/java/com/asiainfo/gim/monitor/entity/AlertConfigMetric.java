package com.asiainfo.gim.monitor.entity;

public class AlertConfigMetric extends AlertConfigBase
{
	// 告警阈值
	private float thresholdValue;
	// 阈值表达式符号
	private String thresholdSymbol;
	// 告警指标
	private String metric;

	public float getThresholdValue()
	{
		return thresholdValue;
	}

	public void setThresholdValue(float thresholdValue)
	{
		this.thresholdValue = thresholdValue;
	}

	public String getThresholdSymbol()
	{
		return thresholdSymbol;
	}

	public void setThresholdSymbol(String thresholdSymbol)
	{
		this.thresholdSymbol = thresholdSymbol;
	}

	public String getMetric()
	{
		return metric;
	}

	public void setMetric(String metric)
	{
		this.metric = metric;
	}

}
