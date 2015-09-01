package com.asiainfo.gim.monitor.api.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;
import com.asiainfo.gim.monitor.service.MonitorService;

/**
 * @author wangjy
 *
 */
@Path("/monitor")
@Produces(MediaType.APPLICATION_JSON)
public class MonitorResource
{
	private MonitorService monitorService;
	
	@QueryParam("startTime")
	private String startTime;
	
	@QueryParam("endTime")
	private String endTime;
	
	@QueryParam("ip")
	private String ip;
	
	@QueryParam("indexName")
	private String indexName;

	public MonitorResource()
	{
		monitorService = SpringContext.getBean(MonitorService.class);
	}
	
	
	@GET
	@Path("listMetric")
	public List<Metric> listMetric()
	{
		MonitorQueryParam monitorQueryParam = new MonitorQueryParam();
		monitorQueryParam.setStartTime(new Date(Long.parseLong(startTime)));
		monitorQueryParam.setEndTime(new Date(Long.parseLong(endTime)));
		monitorQueryParam.setIp(ip);
		monitorQueryParam.setIndexName(indexName);
		return monitorService.listMetric(monitorQueryParam);
	}
	
}
