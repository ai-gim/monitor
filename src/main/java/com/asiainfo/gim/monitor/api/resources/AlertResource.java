package com.asiainfo.gim.monitor.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.rest.exception.ValidationException;
import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.service.AlertService;

@Path("/alerts")
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

	public Alert getAlert()
	{
		return alertService.findAlertById(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addAlert(Alert alert)
	{
		if (alert == null)
		{
			throw new ValidationException();
		}
		alertService.addAlert(alert);
	}

	@PUT
	@Path("{id}")
	public void updateAlert(Alert alert)
	{
		if (alert == null)
		{
			throw new ValidationException();
		}
		alertService.confirmAlert(alert);
	}

	@DELETE
	@Path("{id}")
	public void deleteAlert()
	{
		alertService.deleteAlert(id);
	}

}
