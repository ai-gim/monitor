package com.asiainfo.gim.monitor.api.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.entity.AlertConfigBase;
import com.asiainfo.gim.monitor.service.AlertConfigService;

@Path("/alertConfigs")
@Produces(MediaType.APPLICATION_JSON)
public class AlertConfigResource
{

	private AlertConfigService alertConfigService;

	public AlertConfigResource()
	{
		alertConfigService = SpringContext.getBean(AlertConfigService.class);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public AlertConfigBase insertAlertConfig(AlertConfigBase alertConfigBase)
	{
		return alertConfigService.insertAlertConfig(alertConfigBase);
	}
}
