package com.asiainfo.gim.monitor.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.api.validator.AlertConfigValidator;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.service.AlertConfigService;

@Path("/alertconfig")
@Produces(MediaType.APPLICATION_JSON)
public class AlertConfigResource
{

	private AlertConfigService alertConfigService;

	public AlertConfigResource()
	{
		alertConfigService = SpringContext.getBean(AlertConfigService.class);
	}

	@PathParam("id")
	private int id;

	@GET
	@Path("{id}")
	public AlertConfig getAlertConfig()
	{
		AlertConfig alertConfig = alertConfigService.findAlertConfigById(id);
		return alertConfig;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public AlertConfig addAlertConfig(@AlertConfigValidator AlertConfig alertConfig)
	{
		alertConfigService.addAlertConfigDao(alertConfig);
		return alertConfig;
	}

	@PUT
	@Path("{id}")
	public AlertConfig updateAlertConfig(@AlertConfigValidator AlertConfig alertConfig)
	{
		alertConfig.setId(id);
		alertConfigService.updateAlertConfig(alertConfig);
		return alertConfig;
	}

	@DELETE
	@Path("{id}")
	public void deleteAlertConfig()
	{
		alertConfigService.deleteAlertConfig(id);
	}

}
