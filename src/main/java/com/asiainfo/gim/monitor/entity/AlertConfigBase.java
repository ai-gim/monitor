package com.asiainfo.gim.monitor.entity;

public class AlertConfigBase
{
	private int id;
	private int targetType;
	private String targetId;
	// 持续时间
	private long keepTime;
	// 恢复时间
	private long recoverTime;
	// 告警级别
	private int level;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
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
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	
	
}
