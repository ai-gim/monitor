package com.asiainfo.gim.monitor.entity;

import java.util.Date;

public class Alert
{

	private int id;
	private Date time;
	private int targetType;
	private String targetId;
	private int level;
	private int status;
	private String source;
	private String description;
	private String properties;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getProperties()
	{
		return properties;
	}

	public void setProperties(String properties)
	{
		this.properties = properties;
	}

}
