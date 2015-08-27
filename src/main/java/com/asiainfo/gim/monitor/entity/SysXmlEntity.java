package com.asiainfo.gim.monitor.entity;

public class SysXmlEntity
{
	
	private String name;
	private String unit;
	private String group;
	private long dateTime;
	private String ip;
	private long tMax;
	
	public SysXmlEntity(){
		
	}
	
	public SysXmlEntity(String name, String unit, long dateTime, String ip, long tMax)
	{
		super();
		this.name = name;
		this.unit = unit;
		this.dateTime = dateTime;
		this.ip = ip;
		this.tMax = tMax;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	public String getGroup()
	{
		return group;
	}
	public void setGroup(String group)
	{
		this.group = group;
	}
	public long getDateTime()
	{
		return dateTime;
	}
	public void setDateTime(long dateTime)
	{
		this.dateTime = dateTime;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public long gettMax()
	{
		return tMax;
	}
	public void settMax(long tMax)
	{
		this.tMax = tMax;
	}
	
	
}
