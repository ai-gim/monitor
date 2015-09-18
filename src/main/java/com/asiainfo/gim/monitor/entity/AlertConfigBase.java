package com.asiainfo.gim.monitor.entity;

public class AlertConfigBase
{
	private String id;
	private Integer targetType;
	private String targetId;
	// 告警级别
	private Integer level;
	// 告警类型(metric, heartbeat)
	private Integer type;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTargetId()
	{
		return targetId;
	}

	public void setTargetId(String targetId)
	{
		this.targetId = targetId;
	}

	public Integer getTargetType()
	{
		return targetType;
	}

	public void setTargetType(Integer targetType)
	{
		this.targetType = targetType;
	}

	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer level)
	{
		this.level = level;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

}
