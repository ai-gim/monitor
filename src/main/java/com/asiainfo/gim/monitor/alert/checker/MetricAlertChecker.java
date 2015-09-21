/**   
 * @Title: MetricAlertChecker.java 
 * @Package com.asiainfo.gim.monitor.alert 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年9月18日 上午9:35:39 
 * @version V1.0   
 */
package com.asiainfo.gim.monitor.alert.checker;

import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.alert.CurrentAlertCache;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.MetricAlertConfig;

/**
 * @author zhangli
 *
 */
public class MetricAlertChecker extends AlertChecker<Float>
{
	private MetricAlertConfig alertConfig;
	
	
	private String currentAlertId;
	private long firstRecordTime;

	public void setAlertConfig(MetricAlertConfig alertConfig)
	{
		this.alertConfig = alertConfig;
	}

	@Override
	public Alert doCheckAlert(Float value)
	{
		CurrentAlertCache alertCache = (CurrentAlertCache)SpringContext.getBean("currentAlertCache");
		if(StringUtils.isEmpty(currentAlertId) || alertCache.get(currentAlertId) == null)
		{
			if(isOverThreshold(value))
			{
				if(firstRecordTime == 0)
				{
					firstRecordTime = System.currentTimeMillis();
				}
				else if(System.currentTimeMillis() - firstRecordTime > alertConfig.getKeepTime() * 1000)
				{
					Alert alert = new Alert();
					alert.setId(UUID.randomUUID().toString());
					alert.setLevel(alertConfig.getLevel());
					alert.setSource("AIOM");
					alert.setTime(Calendar.getInstance().getTime());
					alert.setTargetType(alertConfig.getTargetType());
					alert.setTargetId(alertConfig.getTargetId());
					return alert;
				}
			}
			else
			{
				firstRecordTime = 0;
			}
		}
		
		return null;
	}
	
	public String doCheckConfirm(Float value)
	{
		CurrentAlertCache alertCache = (CurrentAlertCache)SpringContext.getBean("currentAlertCache");
		if(StringUtils.isNotEmpty(currentAlertId) && alertCache.get(currentAlertId) != null)
		{
			if(!isOverThreshold(value))
			{
				if(System.currentTimeMillis() - firstRecordTime > alertConfig.getKeepTime())
				{
					return currentAlertId;
				}
			}
			else
			{
				firstRecordTime = 0;
			}
		}
		return null;
	}
	
	private boolean isOverThreshold(float value)
	{
		if(StringUtils.equals(alertConfig.getThresholdSymbol(), ">") && value > alertConfig.getThresholdValue())
		{
			return true;
		}
		else if(StringUtils.equals(alertConfig.getThresholdSymbol(), "<") && value < alertConfig.getThresholdValue())
		{
			return true;
		}
		else if(StringUtils.equals(alertConfig.getThresholdSymbol(), "=") && value == alertConfig.getThresholdValue())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
