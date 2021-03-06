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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.Constants.AlertStatus;
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

	private Map<String, Long> timeRecordMap = new HashMap<String, Long>();

	private ThreadLocal<String> targetIdTh = new ThreadLocal<String>();

	public void setAlertConfig(AlertConfig alertConfig)
	{
		this.alertConfig = alertConfig;
	}

	public void setTargetId(String targetId)
	{
		targetIdTh.set(targetId);
	}

	@Override
	public Alert doCheckAlert(Float value)
	{
		if (isOverThreshold(value) && findCurrentAlert() == null)
		{
			if (!timeRecordMap.containsKey(targetIdTh.get() + "-alert")
					|| timeRecordMap.get(targetIdTh.get() + "-alert") == 0)
			{
				timeRecordMap.put(targetIdTh.get() + "-alert", System.currentTimeMillis());
			}
			else if (System.currentTimeMillis() - timeRecordMap.get(targetIdTh.get() + "-alert") > NumberUtils
					.toInt(alertConfig.getProperties().get("keepTime")) * 1000 * 60)
			{
				Alert alert = new Alert();
				alert.setId(UUID.randomUUID().toString());
				alert.setLevel(alertConfig.getLevel());
				alert.setSource("AIOM");
				alert.setTime(Calendar.getInstance().getTime());
				alert.setTargetType(alertConfig.getTargetType());
				alert.setTargetId(targetIdTh.get());
				alert.setConfigId(alertConfig.getId());
				alert.setDescription(getDescription(value));
				return alert;
			}
		}
		else
		{
			timeRecordMap.put(targetIdTh.get() + "-alert", 0L);
		}

		return null;
	}

	public Alert doCheckConfirm(Float value)
	{
		Alert alert = findCurrentAlert();
		if (!isOverThreshold(value) && alert != null)
		{
			if (!timeRecordMap.containsKey(targetIdTh.get() + "-recover")
					|| timeRecordMap.get(targetIdTh.get() + "-recover") == 0)
			{
				timeRecordMap.put(targetIdTh.get() + "-recover", System.currentTimeMillis());
			}
			if (System.currentTimeMillis() - timeRecordMap.get(targetIdTh.get() + "-recover") > NumberUtils
					.toInt(alertConfig.getProperties().get("recoverTime")))
			{
				return alert;
			}
		}
		else
		{
			timeRecordMap.put(targetIdTh.get() + "-recover", 0L);
		}
		return null;
	}

	private boolean isOverThreshold(float value)
	{
		if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "1")
				&& value > NumberUtils.toInt(alertConfig.getProperties().get("thresholdValue")))
		{
			return true;
		}
		else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "3")
				&& value < NumberUtils.toInt(alertConfig.getProperties().get("thresholdValue")))
		{
			return true;
		}
		else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "2")
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
		alertQueryParam.setTargetId(targetIdTh.get());
		alertQueryParam.setStatus(AlertStatus.NEW);

		List<Alert> alerts = alertService.listAlerts(alertQueryParam);
		return alerts.size() > 0 ? alerts.get(0) : null;
	}

	public String getDescription(float value)
	{
		if (StringUtils.equals(alertConfig.getProperties().get("metric"), "cpu_usage"))
		{
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "1"))
			{
				return "CPU使用率超过 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "3"))
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
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "1"))
			{
				return "内存使用率超过 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "3"))
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
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "1"))
			{
				return "磁盘使用率超过 " + alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "3"))
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
			if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "1"))
			{
				return alertConfig.getProperties().get("metric") + "超过"
						+ alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else if (StringUtils.equals(alertConfig.getProperties().get("thresholdSymbol"), "3"))
			{
				return alertConfig.getProperties().get("metric") + "低于"
						+ alertConfig.getProperties().get("thresholdValue") + "%";
			}
			else
			{
				return alertConfig.getProperties().get("metric") + "等于"
						+ alertConfig.getProperties().get("thresholdValue") + "%";
			}
		}
	}
}
