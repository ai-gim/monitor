package com.asiainfo.gim.monitor.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.AlertConfig;
import com.asiainfo.gim.monitor.domain.query.AlertConfigQueryParam;
import com.asiainfo.gim.monitor.service.AlertConfigService;

@Path("/alertconfigs")
@Produces(MediaType.APPLICATION_JSON)
public class AlertConfigListResource
{

	private AlertConfigService alertConfigService;

	public AlertConfigListResource()
	{
		alertConfigService = SpringContext.getBean(AlertConfigService.class);
	}

	@QueryParam("targetType")
	Integer targetType;

	@QueryParam("targetId")
	String targetId;

	@QueryParam("level")
	Integer level;
	
	@QueryParam("type")
	Integer type;

	@GET
	public List<AlertConfig> getAlertConfig()
	{
		AlertConfigQueryParam alertConfigQueryParam = new AlertConfigQueryParam();
		alertConfigQueryParam.setTargetType(targetType);
		alertConfigQueryParam.setTargetId(targetId);
		alertConfigQueryParam.setLevel(level);
		alertConfigQueryParam.setType(type);
		List<AlertConfig> alertConfigList = alertConfigService.listAlertConfigs(alertConfigQueryParam);
		return alertConfigList;
	}

}
