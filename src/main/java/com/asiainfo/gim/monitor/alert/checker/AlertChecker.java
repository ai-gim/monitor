/**   
 * @Title: AlertChecker.java 
 * @Package com.asiainfo.gim.monitor.alert 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年9月18日 上午9:35:22 
 * @version V1.0   
 */
package com.asiainfo.gim.monitor.alert.checker;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.Constants.AlertStatus;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.service.AlertService;

/**
 * @author zhangli
 *
 */
public abstract class AlertChecker<T>
{
	public void check(T obj)
	{
		Alert alert = doCheckAlert(obj);
		if (alert != null)
		{
			sendAlert(alert);
		}

		String currentAlertId = doCheckConfirm(obj);
		if (currentAlertId != null)
		{

		}
	}

	public void sendAlert(Alert alert)
	{
		AlertService alertService = (AlertService)SpringContext.getBean("alertService");
		
		alert.setStatus(AlertStatus.NEW);
		alertService.addAlert(alert);
	}

	public void confirmAlert(Alert alert)
	{
		System.out.println(alert);
	}

	public abstract Alert doCheckAlert(T obj);

	public abstract String doCheckConfirm(T obj);
}
