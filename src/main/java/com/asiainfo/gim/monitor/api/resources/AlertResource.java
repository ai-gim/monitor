package com.asiainfo.gim.monitor.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.common.rest.exception.ResourceNotFoundException;
import com.asiainfo.gim.common.rest.exception.ValidationException;
import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.AlertAction;
import com.asiainfo.gim.monitor.service.AlertService;

@Path("/alert")
@Produces(MediaType.APPLICATION_JSON)
public class AlertResource
{
	private AlertService alertService;

	public AlertResource()
	{
		alertService = SpringContext.getBean(AlertService.class);
	}

	@PathParam("id")
	private String id;

	@GET
	@Path("{id}")
	public Alert getAlert()
	{
		return alertService.findAlertById(id);
	}

	@PUT
	@Path("{id}/action")
	public void confirmAlert(AlertAction alertAction)
	{
		if (alertAction == null)
		{
			throw new ValidationException();
		}
		
		Alert alert = alertService.findAlertById(id);
		if (alert == null)
		{
			throw new ResourceNotFoundException();
		}
		
		if (StringUtils.equals(alertAction.getAction(), "confirm"))
		{
			alertService.confirmAlert(alert);
		}
		
	}
	
	@DELETE
	@Path("{id}")
	public void deleteAlert()
	{
		alertService.deleteAlert(id);
	}

}
