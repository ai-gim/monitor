package com.asiainfo.gim.monitor.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.entity.Alert;
import com.asiainfo.gim.monitor.service.AlertService;

public class AlertResource
{

	private AlertService alertMetricService;
	
	public AlertResource()
	{
		alertMetricService = SpringContext.getBean(AlertService.class);
	}
	
	@GET
	@Path("listAlertMetric")
	public List<Alert> listAlertMetric(){
		AlertQueryParam alertQueryParam = new AlertQueryParam();
		return alertMetricService.listAlertMetric(alertQueryParam);
	}
	
}
