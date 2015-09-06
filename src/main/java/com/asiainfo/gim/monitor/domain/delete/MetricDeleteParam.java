package com.asiainfo.gim.monitor.domain.delete;

import java.util.Date;

public class MetricDeleteParam
{

	private String ip;
	private Date startTime;
	private Date endTime;
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
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
