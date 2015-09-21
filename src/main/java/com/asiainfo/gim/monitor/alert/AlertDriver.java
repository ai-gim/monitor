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

import org.springframework.stereotype.Service;

import com.asiainfo.gim.client.ClientContext;
import com.asiainfo.gim.client.server_manage.api.ServerApi;
import com.asiainfo.gim.client.server_manage.domain.Server;
import com.asiainfo.gim.monitor.Constants;
import com.asiainfo.gim.monitor.alert.checker.MetricAlertChecker;
import com.asiainfo.gim.monitor.domain.Host;
import com.asiainfo.gim.monitor.domain.Metric;

/**
 * @author zhangli
 *
 */
@Service
public class AlertDriver
{
	private ServerApi serverApi;
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

			if (host.getMetrics().containsKey("cpu_idle"))
			{
				Metric metric = host.getMetrics().get("cpu_idle");
				if (metric.getTn() < 20)
				{
					String key = "metric-1" + server.getId() + "cpu_usage";
					Float value = (Float)metric.getValue();
					if(alertCheckerCache.get(key) != null)
					{
						MetricAlertChecker alertChecker = (MetricAlertChecker)alertCheckerCache.get(key);
						alertChecker.check(100 - value);
					}
				}
			}
		}
	}
}
