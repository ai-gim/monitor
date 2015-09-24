package com.asiainfo.gim.monitor.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.common.rest.exception.ValidationException;
import com.asiainfo.gim.common.spring.SpringContext;
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public AlertConfig getAlertConfig(@QueryParam("id") Integer id)
	{
		if (id == null)
		{
			throw new ValidationException();
		}
		AlertConfig alertConfig = alertConfigService.findAlertConfigById(id);
		return alertConfig;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public AlertConfig addAlertConfig(AlertConfig alertConfig)
	{
		if (StringUtils.isBlank(alertConfig.getTargetId()) || StringUtils.isBlank(alertConfig.getProperties())
				|| alertConfig.getTargetType() == null || alertConfig.getType() == null)
		{
			throw new ValidationException();
		}
		alertConfigService.addAlertConfigDao(alertConfig);
		return alertConfig;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public AlertConfig updateAlertConfig(AlertConfig alertConfig)
	{
		if (StringUtils.isBlank(alertConfig.getTargetId()) || StringUtils.isBlank(alertConfig.getProperties())
				|| alertConfig.getTargetType() == null || alertConfig.getType() == null || alertConfig.getId() == null)
		{
			throw new ValidationException();
		}
		alertConfigService.updateAlertConfig(alertConfig);
		return alertConfig;
	}

	@DELETE
	@Path("{id}")
	public void deleteAlertConfig(@PathParam("id") int id)
	{
//		if (id == null)
//		{
//			throw new ValidationException();
//		}
		alertConfigService.deleteAlertConfig(id);
	}

}
