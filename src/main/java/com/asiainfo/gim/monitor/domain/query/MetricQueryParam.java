package com.asiainfo.gim.monitor.domain.query;

import java.util.Date;

public class MetricQueryParam
{

	private String ip;
	private Date startTime;
	private Date endTime;
	private String metricName;
	
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public String getMetricName()
	{
		return metricName;
	}
	public void setMetricName(String metricName)
	{
		this.metricName = metricName;
	}
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
	
}
