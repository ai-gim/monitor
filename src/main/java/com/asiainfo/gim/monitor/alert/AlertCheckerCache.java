/**   
 * @Title: AlertCheckerCache.java 
 * @Package com.asiainfo.gim.monitor.alert.checker 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年9月18日 上午10:25:29 
 * @version V1.0   
 */
package com.asiainfo.gim.monitor.alert;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.asiainfo.gim.monitor.alert.checker.AlertChecker;

/**
 * @author zhangli
 *
 */
@Component
public class AlertCheckerCache
{
	private Map<String, AlertChecker<? extends Object>> alertCheckerMap = new HashMap<String, AlertChecker<? extends Object>>();

	public AlertChecker<? extends Object> get(String key)
	{
		return alertCheckerMap.get(key);
	}

	public void put(String key, AlertChecker<? extends Object> alertChecker)
	{
		alertCheckerMap.put(key, alertChecker);
	}

	public void evict(String key)
	{
		alertCheckerMap.remove(key);
	}
}
