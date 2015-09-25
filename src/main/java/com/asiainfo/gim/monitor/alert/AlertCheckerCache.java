/**   
 * @Title: AlertCheckerCache.java 
 * @Package com.asiainfo.gim.monitor.alert.checker 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年9月18日 上午10:25:29 
 * @version V1.0   
 */
package com.asiainfo.gim.monitor.alert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.asiainfo.gim.client.ClientContext;
import com.asiainfo.gim.client.server_manage.api.ServerApi;
import com.asiainfo.gim.client.server_manage.domain.Server;
import com.asiainfo.gim.monitor.Constants;
import com.asiainfo.gim.monitor.Constants.AlertConfigType;
import com.asiainfo.gim.monitor.alert.checker.AlertChecker;
import com.asiainfo.gim.monitor.alert.checker.MetricAlertChecker;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.service.AlertConfigService;

/**
 * @author zhangli
 *
 */
@Component
public class AlertCheckerCache implements InitializingBean
{
	private Map<String, AlertChecker<? extends Object>> alertCheckerMap;
	private AlertConfigService alertConfigService;
	private ServerApi serverApi;

	@Resource
	public void setAlertConfigService(AlertConfigService alertConfigService)
	{
		this.alertConfigService = alertConfigService;
	}

	@Resource
	public void setServerApi(ServerApi serverApi)
	{
		this.serverApi = serverApi;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		alertCheckerMap = new ConcurrentHashMap<String, AlertChecker<? extends Object>>();

		AlertConfigQueryParam alertConfigQueryParam = new AlertConfigQueryParam();
		alertConfigQueryParam.setType(AlertConfigType.METRIC_ALERT_CONFIG);
		List<AlertConfig> alertConfigs = alertConfigService.listAlertConfigs(alertConfigQueryParam);
		
		for(AlertConfig alertConfig: alertConfigs)
		{
			if(alertConfig.getType() == AlertConfigType.METRIC_ALERT_CONFIG)
			{
				// 度量指标告警
				initMetricAlertCheckers(alertConfig);
			}
		}
	}

	public void initMetricAlertCheckers(AlertConfig alertConfig)
	{
		ClientContext.setToken(Constants.INTERNAL_TOKEN);
		List<Server> servers = serverApi.listServers();

		if (StringUtils.isEmpty(alertConfig.getTargetId()))
		{
			for (Server server : servers)
			{
				AlertConfig alertConfigClone = new AlertConfig();
				BeanUtils.copyProperties(alertConfig, alertConfigClone);
				alertConfigClone.setTargetId(server.getId());

				MetricAlertChecker alertChecker = new MetricAlertChecker();
				alertChecker.setAlertConfig(alertConfigClone);

				alertCheckerMap.put("metric-" + alertConfig.getTargetType() + server.getId()
						+ alertConfig.getProperties().get("metric"), alertChecker);
			}
		}
		else
		{
			MetricAlertChecker alertChecker = new MetricAlertChecker();
			alertChecker.setAlertConfig(alertConfig);

			alertCheckerMap.put("metric-" + alertConfig.getTargetType() + alertConfig.getTargetId()
					+ alertConfig.getProperties().get("metric"), alertChecker);
		}
	}

	public AlertChecker<? extends Object> get(String key)
	{
		return alertCheckerMap.get(key);
	}

	public void put(String key, AlertChecker<? extends Object> alertChecker)
	{
		alertCheckerMap.put(key, alertChecker);
	}
}
