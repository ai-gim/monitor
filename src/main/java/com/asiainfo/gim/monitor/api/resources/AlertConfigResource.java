package com.asiainfo.gim.monitor.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.entity.AlertConfigMetric;
import com.asiainfo.gim.monitor.service.AlertConfigService;

public class AlertConfigResource
{

	private AlertConfigService alertConfigService;

	public AlertConfigResource()
	{
		alertConfigService = SpringContext.getBean(AlertConfigService.class);
	}
	
	@GET
	@Path("listAlertConfig")
	public List<AlertConfigMetric> listAlertConfig(){
		AlertConfigQueryParam alertConfigQueryParam = new AlertConfigQueryParam();
		return alertConfigService.listAlertConfig(alertConfigQueryParam);
	}
}
