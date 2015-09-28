/**   
 * @Title: AlertDriver.java 
 * @Package com.asiainfo.gim.monitor.alert 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年9月18日 下午2:36:01 
 * @version V1.0   
 */
package com.asiainfo.gim.monitor.alert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.asiainfo.gim.client.ClientContext;
import com.asiainfo.gim.client.server_manage.api.ServerApi;
import com.asiainfo.gim.client.server_manage.domain.Server;
import com.asiainfo.gim.monitor.Constants;
import com.asiainfo.gim.monitor.Constants.AlertType;
import com.asiainfo.gim.monitor.Constants.ResourceType;
import com.asiainfo.gim.monitor.alert.checker.MetricAlertChecker;
import com.asiainfo.gim.monitor.dao.AlertConfigDao;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.Host;
import com.asiainfo.gim.monitor.domain.Metric;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;

/**
 * @author zhangli
 *
 */
@Service
public class AlertDriver implements InitializingBean
{
	private ServerApi serverApi;
	private AlertConfigDao alertConfigDao;
	private AlertCheckerCache alertCheckerCache;

	@Resource
	public void setServerApi(ServerApi serverApi)
	{
		this.serverApi = serverApi;
	}

	@Resource
	public void setAlertCheckerCache(AlertCheckerCache alertCheckerCache)
	{
		this.alertCheckerCache = alertCheckerCache;
	}

	@Resource
	public void setAlertConfigDao(AlertConfigDao alertConfigDao)
	{
		this.alertConfigDao = alertConfigDao;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		AlertConfigQueryParam alertConfigQueryParam = new AlertConfigQueryParam();
		alertConfigQueryParam.setType(AlertType.METRIC_ALERT);
		List<AlertConfig> alertConfigs = alertConfigDao.listAlertConfigs(alertConfigQueryParam);

		for (AlertConfig alertConfig : alertConfigs)
		{
			initAlertChecker(alertConfig);
		}
	}

	public void initAlertChecker(AlertConfig alertConfig)
	{
		if (alertConfig.getType() == AlertType.METRIC_ALERT)
		{
			MetricAlertChecker alertChecker = new MetricAlertChecker();
			alertChecker.setAlertConfig(alertConfig);
			if (StringUtils.isEmpty(alertConfig.getTargetId()))
			{
				alertCheckerCache.put(
						"metric-" + alertConfig.getTargetType() + alertConfig.getProperties().get("metric"),
						alertChecker);
			}
			else
			{
				alertCheckerCache.put("metric-" + alertConfig.getTargetType() + alertConfig.getTargetId()
						+ alertConfig.getProperties().get("metric"), alertChecker);
			}
		}
	}

	public void removeAlertChecker(String alertConfigId)
	{
		AlertConfig alertConfig = alertConfigDao.findAlertConfigById(alertConfigId);
		if (alertConfig.getType() == AlertType.METRIC_ALERT)
		{
			if (StringUtils.isEmpty(alertConfig.getTargetId()))
			{
				alertCheckerCache.evict("metric-" + alertConfig.getTargetType()
						+ alertConfig.getProperties().get("metric"));
			}
			else
			{
				alertCheckerCache.evict("metric-" + alertConfig.getTargetType() + alertConfig.getTargetId()
						+ alertConfig.getProperties().get("metric"));
			}
		}
	}

	public void checkMetricAlert(List<Host> hosts)
	{
		ClientContext.setToken(Constants.INTERNAL_TOKEN);

		Map<String, Server> serverMap = new HashMap<String, Server>();
		for (Server server : serverApi.listServers())
		{
			serverMap.put(server.getIp(), server);
		}

		for (Host host : hosts)
		{
			Server server = serverMap.get(host.getIp());

			// cpu使用率
			if (host.getMetrics().containsKey("cpu_idle"))
			{
				Metric metric = host.getMetrics().get("cpu_idle");
				if (metric.getTn() < 20)
				{
					MetricAlertChecker alertChecker = getMetricAlertChecker(server.getId(), "cpu_usage");
					if (alertChecker != null)
					{
						Float value = (Float) metric.getValue();
						alertChecker.setTargetId(server.getId());
						alertChecker.check(100 - value);
					}
				}
			}

			// 内存使用率
			if (host.getMetrics().containsKey("mem_total") && host.getMetrics().containsKey("mem_free"))
			{
				Metric memTotalMetric = host.getMetrics().get("mem_total");
				Metric memFreeMetric = host.getMetrics().get("mem_free");
				if (memFreeMetric.getTn() < 20)
				{
					MetricAlertChecker alertChecker = getMetricAlertChecker(server.getId(), "mem_usage");
					if (alertChecker != null)
					{
						Float memTotal = (Float) memTotalMetric.getValue();
						Float memFree = (Float) memFreeMetric.getValue();
						Float value = (memTotal - memFree) * 100 / memTotal;
						
						alertChecker.setTargetId(server.getId());
						alertChecker.check(value);
					}
				}
			}

			// 磁盘使用率
			if (host.getMetrics().containsKey("disk_total") && host.getMetrics().containsKey("disk_free"))
			{
				Metric diskTotalMetric = host.getMetrics().get("disk_total");
				Metric diskFreeMetric = host.getMetrics().get("disk_free");
				if (diskFreeMetric != null && diskTotalMetric != null && diskFreeMetric.getTn() < 20)
				{
					MetricAlertChecker alertChecker = getMetricAlertChecker(server.getId(), "disk_usage");
					if (alertChecker != null)
					{
						Float diskTotal = (Float) diskTotalMetric.getValue();
						Float diskFree = (Float) diskFreeMetric.getValue();
						Float value = (diskTotal - diskFree) * 100 / diskTotal;
						
						alertChecker.setTargetId(server.getId());
						alertChecker.check(value);
					}
				}
			}
		}
	}

	private MetricAlertChecker getMetricAlertChecker(String serverId, String metric)
	{
		String key1 = "metric-" + ResourceType.SERVER + serverId + metric;
		String key2 = "metric-" + ResourceType.SERVER + metric;

		MetricAlertChecker alertChecker = null;
		if (alertCheckerCache.get(key1) != null)
		{
			alertChecker = (MetricAlertChecker) alertCheckerCache.get(key1);
		}
		else if (alertCheckerCache.get(key2) != null)
		{
			alertChecker = (MetricAlertChecker) alertCheckerCache.get(key2);
		}

		return alertChecker;
	}
}
