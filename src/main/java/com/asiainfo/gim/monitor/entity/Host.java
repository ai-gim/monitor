package com.asiainfo.gim.monitor.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Host
{
	
	private Map<String, Metric> metricMap;
	private String name;
	private String ip;
	private Date reportTime;
	private String location;
	
	public Map<String, Metric> getMetricMap()
	{
		return metricMap;
	}
	public void setMetricMap(Map<String, Metric> metricMap)
	{
		this.metricMap = metricMap;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public Date getReportTime()
	{
		return reportTime;
	}
	public void setReportTime(Date reportTime)
	{
		this.reportTime = reportTime;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	
	
	
}