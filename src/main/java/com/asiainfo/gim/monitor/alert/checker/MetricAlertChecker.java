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
import org.apache.commons.lang.math.NumberUtils;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.service.AlertService;

/**
 * @author zhangli
 *
 */
public class MetricAlertChecker extends AlertChecker<Float>
{
	private AlertConfig alertConfig;

	private long recordTimeAlert;
	private long recordTimeRecover;

	public void setAlertConfig(AlertConfig alertConfig)
	{
		this.alertConfig = alertConfig;
	}

	@Override
	public Alert doCheckAlert(Float value)
	{
		if (isOverThreshold(value) && findCurrentAlert() == null)
		{
			if (recordTimeAlert == 0)
			{
				recordTimeAlert = System.currentTimeMillis();
			}
			else if (System.currentTimeMillis() - recordTimeAlert > NumberUtils.toInt(alertConfig.getProperties().get(
					"keepTime")) * 1000)
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

	public Alert doCheckConfirm(Float value)
	{
		Alert alert = findCurrentAlert();
		if (!isOverThreshold(value) && alert != null)
		{
			if (System.currentTimeMillis() - recordTimeRecover > NumberUtils.toInt(alertConfig.getProperties().get(
					"recoverTime")))
			{
				return alert;
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
		if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), ">")
				&& value > NumberUtils.toInt(alertConfig.getProperties().get("thresholdValue")))
		{
			return true;
		}
		else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "<")
				&& value < NumberUtils.toInt(alertConfig.getProperties().get("thresholdValue")))
		{
			return true;
		}
		else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "=")
				&& value == NumberUtils.toInt(alertConfig.getProperties().get("thresholdValue")))
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
		if (StringUtils.equals(alertConfig.getProperties().get("metric"), "cpu_usage"))
		{
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), ">"))
			{
				return "CPU使用率超过 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "<"))
			{
				return "CPU使用率低于 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else
			{
				return "CPU使用率等于 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
		}
		else if (StringUtils.equals(alertConfig.getProperties().get("metric"), "mem_usage"))
		{
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), ">"))
			{
				return "内存使用率超过 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "<"))
			{
				return "内存使用率低于 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else
			{
				return "内存使用率等于 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
		}
		else if (StringUtils.equals(alertConfig.getProperties().get("metric"), "disk_usage"))
		{
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), ">"))
			{
				return "磁盘使用率超过 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "<"))
			{
				return "磁盘使用率低于 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else
			{
				return "磁盘使用率等于 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
		}
		else
		{
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), ">"))
			{
				return alertConfig.getProperties().get("metric") + "超过" + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "<"))
			{
				return alertConfig.getProperties().get("metric") + "低于" + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else
			{
				return alertConfig.getProperties().get("metric") + "等于" + alertConfig.getProperties().get("thresholdValue") + "%";
			}
		}
	}
}
