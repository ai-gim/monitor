package com.asiainfo.gim.monitor.task;

import java.util.List;

import javax.annotation.Resource;

import com.asiainfo.gim.monitor.entity.Host;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlFetcher;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlParser;

public class GangliaDataFetchJob
{

	private GangliaXmlFetcher gangliaXmlFetcher;
	private GangliaXmlParser gangliaXmlParser;

	private boolean report;

	private String ip;
	private int port;

	@Resource
	public void setGangliaFetchXml(GangliaXmlFetcher gangliaXmlFetcher)
	{
		this.gangliaXmlFetcher = gangliaXmlFetcher;
	}

	@Resource
	public void setGangliaXmlParser(GangliaXmlParser gangliaXmlParser)
	{
		this.gangliaXmlParser = gangliaXmlParser;
	}

	public void setReport(boolean report)
	{
		this.report = report;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public void doCollect()
	{
		String xml = gangliaXmlFetcher.fetchGangliaXml(ip, port);
		if (xml != null)
		{
			List<Host> hosts = gangliaXmlParser.doResolve(xml);

			// 保存数据
			saveData(hosts);

			// 上报数据
			if (report)
			{
				reportData(hosts);
			}
		}
	}

	private void saveData(List<Host> hosts)
	{

	}

	private void reportData(List<Host> hosts)
	{
		
	}
}
