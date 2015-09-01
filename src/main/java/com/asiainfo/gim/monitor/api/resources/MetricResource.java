package com.asiainfo.gim.monitor.api.resources;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.common.rest.exception.ValidationException;
import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.domain.query.MetricQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;
import com.asiainfo.gim.monitor.service.MetricService;

/**
 * @author wangjy
 *
 */
@Path("/metric")
@Produces(MediaType.APPLICATION_JSON)
public class MetricResource
{
	private MetricService monitorService;
	
	@QueryParam("startTime")
	private Date startTime;
	
	@QueryParam("endTime")
	private Date endTime;
	
	@QueryParam("ip")
	private String ip;
	
	@QueryParam("MetricName")
	private String MetricName;

	public MetricResource()
	{
		monitorService = SpringContext.getBean(MetricService.class);
	}
	
	
	@GET
	@Path("listMetric")
	public List<Metric> listMetric()
	{
		MetricQueryParam monitorQueryParam = new MetricQueryParam();
		if(StringUtils.isEmpty(MetricName) || startTime == null || endTime == null){
			throw new ValidationException("illegal parameter");
		}
		monitorQueryParam.setStartTime(startTime);
		monitorQueryParam.setEndTime(endTime);
		monitorQueryParam.setIp(ip);
		monitorQueryParam.setMetricName(MetricName);
		return monitorService.listMetric(monitorQueryParam);
	}
	
}
