package com.asiainfo.gim.monitor.domain.query;

public class AlertConfigQueryParam
{
	private int targetType;
	private String targetId;
	private int level;
	private String metric;

	public int getTargetType()
	{
		return targetType;
	}

	public void setTargetType(int targetType)
	{
		this.targetType = targetType;
	}

	public String getTargetId()
	{
		return targetId;
	}

	public void setTargetId(String targetId)
	{
		this.targetId = targetId;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int level)
	{
		this.level = level;
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
