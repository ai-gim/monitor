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
import com.asiainfo.gim.monitor.alert.checker.AlertChecker;
import com.asiainfo.gim.monitor.alert.checker.MetricAlertChecker;
import com.asiainfo.gim.monitor.domain.MetricAlertConfig;
import com.asiainfo.gim.monitor.service.MetricAlertConfigService;

/**
 * @author zhangli
 *
 */
@Component
public class AlertCheckerCache implements InitializingBean
{
	private Map<String, AlertChecker<? extends Object>> alertCheckerMap;
	private MetricAlertConfigService metricAlertConfigService;
	private ServerApi serverApi;

	@Resource
	public void setMetricAlertConfigService(MetricAlertConfigService metricAlertConfigService)
	{
		this.metricAlertConfigService = metricAlertConfigService;
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

		// 度量指标告警
		initMetricAlertCheckers();
	}

	public void initMetricAlertCheckers()
	{
		ClientContext.setToken(Constants.INTERNAL_TOKEN);
		List<Server> servers = serverApi.listServers();
		List<MetricAlertConfig> alertConfigs = metricAlertConfigService.listMetricAlertConfigs();

		for (MetricAlertConfig alertConfig : alertConfigs)
		{
			if (StringUtils.isEmpty(alertConfig.getTargetId()))
			{
				for (Server server : servers)
				{
					MetricAlertConfig alertConfigClone = new MetricAlertConfig();
					BeanUtils.copyProperties(alertConfig, alertConfigClone);
					alertConfigClone.setTargetId(server.getId());

					MetricAlertChecker alertChecker = new MetricAlertChecker();
					alertChecker.setAlertConfig(alertConfigClone);

					alertCheckerMap.put(
							"metric-" + alertConfig.getTargetType() + server.getId() + alertConfig.getMetric(),
							alertChecker);
				}
			}
			else
			{
				MetricAlertChecker alertChecker = new MetricAlertChecker();
				alertChecker.setAlertConfig(alertConfig);

				alertCheckerMap.put(
						"metric-" + alertConfig.getTargetType() + alertConfig.getTargetId() + alertConfig.getMetric(),
						alertChecker);
			}
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
