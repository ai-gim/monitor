package com.asiainfo.gim.monitor.api.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.entity.Alert;
import com.asiainfo.gim.monitor.service.AlertService;

@Path("/alerts")
@Produces(MediaType.APPLICATION_JSON)
public class AlertListResource
{

	private AlertService alertService;

	public AlertListResource()
	{
		alertService = SpringContext.getBean(AlertService.class);
	}

	@QueryParam("startTime")
	private long startTime;

	@QueryParam("endTime")
	private long endTime;

	@QueryParam("targetType")
	private int targetType;

	@QueryParam("targetId")
	private String targetId;

	@QueryParam("level")
	private int level;

	@QueryParam("status")
	private int status;

	@QueryParam("source")
	private String source;

	@GET
	public List<Alert> listAlertMetric()
	{
		AlertQueryParam alertQueryParam = new AlertQueryParam();
		alertQueryParam.setStartTime(new Date(startTime));
		alertQueryParam.setEndTime(new Date(endTime));
		alertQueryParam.setTargetType(targetType);
		alertQueryParam.setTargetId(targetId);
		alertQueryParam.setLevel(level);
		alertQueryParam.setStatus(status);
		alertQueryParam.setSource(source);
		return alertService.listAlerts(alertQueryParam);
	}

}
