/**   
* @Title: CurrentAlertCache.java 
* @Package com.asiainfo.gim.monitor.alert 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhangli
* @date 2015年9月18日 上午11:29:36 
* @version V1.0   
*/
package com.asiainfo.gim.monitor.alert;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.asiainfo.gim.monitor.domain.Alert;

/**
 * @author zhangli
 *
 */
@Component
public class CurrentAlertCache implements InitializingBean
{
	private Map<String, Alert> currentAlertMap;

	@Override
	public void afterPropertiesSet() throws Exception
	{
		currentAlertMap = new ConcurrentHashMap<String, Alert>();
	}

	public Alert get(String id)
	{
		return currentAlertMap.get(id);
	}
	
	public void put(Alert alert)
	{
		currentAlertMap.put(alert.getId(), alert);
	}
	
	public void evict(String id)
	{
		currentAlertMap.remove(id);
	}
}
