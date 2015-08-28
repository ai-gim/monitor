package com.asiainfo.gim.monitor.task;

import java.util.List;

import javax.annotation.Resource;

import com.asiainfo.gim.monitor.entity.Host;
import com.asiainfo.gim.monitor.ganglia.GangliaFetchXml;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class CollectJob
{
	
	GangliaFetchXml gangliaFetchXml;
	GangliaXmlParser gangliaXmlParser;
	
	@Resource
	public void setGangliaFetchXml(GangliaFetchXml gangliaFetchXml)
	{
		this.gangliaFetchXml = gangliaFetchXml;
	}
	@Resource
	public void setGangliaXmlParser(GangliaXmlParser gangliaXmlParser)
	{
		this.gangliaXmlParser = gangliaXmlParser;
	}





	public void doCollect()
	{
		List<Host> list = gangliaXmlParser.doResolve(gangliaFetchXml.fetchGangliaXml());
		ObjectMapper om = new ObjectMapper();
		try
		{
			System.out.println(om.writeValueAsString(list));
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		System.out.println("parser end ................................");
	}
	
	

}
