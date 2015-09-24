package com.asiainfo.gim.monitor.api.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
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
	private Long startTime;

	@QueryParam("endTime")
	private Long endTime;

	@QueryParam("targetType")
	private Integer targetType;

	@QueryParam("targetId")
	private String targetId;

	@QueryParam("level")
	private Integer level;

	@QueryParam("status")
	private Integer status;

	@QueryParam("source")
	private String source;
	
	@QueryParam("start")
	private int start;
	
	@QueryParam("limit")
	private int limit;

	@GET
	public List<Alert> listAlertMetric()
	{
		AlertQueryParam alertQueryParam = new AlertQueryParam();
		if (startTime != null)
		{
			alertQueryParam.setStartTime(new Date(startTime));
		}
		if (endTime != null)
		{
			alertQueryParam.setEndTime(new Date(endTime));
		}
		alertQueryParam.setTargetType(targetType);
		alertQueryParam.setTargetId(targetId);
		alertQueryParam.setLevel(level);
		alertQueryParam.setStatus(status);
		alertQueryParam.setSource(source);
		alertQueryParam.setStart(start);
		alertQueryParam.setLimit(limit);
		return alertService.listAlerts(alertQueryParam);
	}

}
