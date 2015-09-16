package com.asiainfo.gim.monitor.domain.query;

import java.util.Date;

public class AlertQueryParam
{
	private Date startTime;
	private Date endTime;
	// 设备类型
	private int targetType;
	// 设备ID
	private String targetId;
	// 告警级别
	private int level;
	// 告警状态（是否确认状态）
	private int status;
	// 告警来源
	private String source;

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

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

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}

}
