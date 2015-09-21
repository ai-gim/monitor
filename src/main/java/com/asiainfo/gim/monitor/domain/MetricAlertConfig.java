package com.asiainfo.gim.monitor.domain;

public class MetricAlertConfig extends AlertConfigBase
{
	// 告警阈值
	private float thresholdValue;
	// 阈值表达式符号
	private String thresholdSymbol;
	// 告警指标
	private String metric;
	// 持续时间
	private long keepTime;
	// 恢复时间
	private long recoverTime;

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

	public long getKeepTime()
	{
		return keepTime;
	}

	public void setKeepTime(long keepTime)
	{
		this.keepTime = keepTime;
	}

	public long getRecoverTime()
	{
		return recoverTime;
	}

	public void setRecoverTime(long recoverTime)
	{
		this.recoverTime = recoverTime;
	}

}
