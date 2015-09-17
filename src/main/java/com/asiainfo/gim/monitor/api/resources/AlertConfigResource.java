package com.asiainfo.gim.monitor.api.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.service.AlertConfigMetricService;

@Path("/alertConfigs")
@Produces(MediaType.APPLICATION_JSON)
public class AlertConfigResource
{

	private AlertConfigMetricService alertConfigService;

	public AlertConfigResource()
	{
		alertConfigService = SpringContext.getBean(AlertConfigMetricService.class);
	}

}
