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
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.MetricAlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.service.AlertService;

/**
 * @author zhangli
 *
 */
public class MetricAlertChecker extends AlertChecker<Float>
{
	private MetricAlertConfig alertConfig;

	private long recordTimeAlert;
	private long recordTimeRecover;

	public void setAlertConfig(MetricAlertConfig alertConfig)
	{
		this.alertConfig = alertConfig;
	}

	@Override
	public Alert doCheckAlert(Float value)
	{
		if(isOverThreshold(value) && findCurrentAlert() == null)
		{
			if(recordTimeAlert == 0)
			{
				recordTimeAlert = System.currentTimeMillis();
			}
			else if(System.currentTimeMillis() - recordTimeAlert > alertConfig.getKeepTime() * 1000)
			{
				Alert alert = new Alert();
				alert.setId(UUID.randomUUID().toString());
				alert.setLevel(alertConfig.getLevel());
				alert.setSource("AIOM");
				alert.setTime(Calendar.getInstance().getTime());
				alert.setTargetType(alertConfig.getTargetType());
				alert.setTargetId(alertConfig.getTargetId());
				alert.setConfigId(alertConfig.getId());
				alert.setDescription(getDescription(value));
				return alert;
			}
		}
		else
		{
			recordTimeAlert = 0;
		}
		
		return null;
	}

	public String doCheckConfirm(Float value)
	{
		Alert alert = findCurrentAlert();
		if (!isOverThreshold(value) && alert != null)
		{
			if (System.currentTimeMillis() - recordTimeRecover > alertConfig.getRecoverTime())
			{
				return alert.getId();
			}
		}
		else
		{
			recordTimeRecover = 0;
		}
		return null;
	}

	private boolean isOverThreshold(float value)
	{
		if (StringUtils.equals(alertConfig.getThresholdSymbol(), ">") && value > alertConfig.getThresholdValue())
		{
			return true;
		}
		else if (StringUtils.equals(alertConfig.getThresholdSymbol(), "<") && value < alertConfig.getThresholdValue())
		{
			return true;
		}
		else if (StringUtils.equals(alertConfig.getThresholdSymbol(), "=") && value == alertConfig.getThresholdValue())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private Alert findCurrentAlert()
	{
		AlertService alertService = (AlertService) SpringContext.getBean("alertService");
		AlertQueryParam alertQueryParam = new AlertQueryParam();
		alertQueryParam.setConfigId(alertConfig.getId());
		alertQueryParam.setTargetType(alertConfig.getTargetType());
		alertQueryParam.setTargetId(alertConfig.getTargetId());

		List<Alert> alerts = alertService.listAlerts(alertQueryParam);
		return alerts.size() > 0 ? alerts.get(0) : null;
	}
	
	public String getDescription(float value)
	{
		if(StringUtils.equals(alertConfig.getMetric(), "cpu_usage"))
		{
			if(StringUtils.equals(alertConfig.getThresholdSymbol(), ">"))
			{
				return "CPU使用率超过 " + value + "%";
			}
			else if(StringUtils.equals(alertConfig.getThresholdSymbol(), "<"))
			{
				return "CPU使用率低于 " + value + "%";
			}
			else
			{
				return "CPU使用率等于 " + value + "%";
			}
		}
		else
		{
			if(StringUtils.equals(alertConfig.getThresholdSymbol(), ">"))
			{
				return alertConfig.getMetric() + "超过" + value + "%";
			}
			else if(StringUtils.equals(alertConfig.getThresholdSymbol(), "<"))
			{
				return alertConfig.getMetric() + "低于" + value + "%";
			}
			else
			{
				return alertConfig.getMetric() + "等于" + value + "%";
			}
		}
	}
}
