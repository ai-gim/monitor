package com.asiainfo.gim.monitor.ganglia;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

import com.asiainfo.gim.monitor.entity.Host;
import com.asiainfo.gim.monitor.entity.Metric;
@Component
public class GangliaXmlParser
{

	public List<Host> doResolve(String xmlStr)
	{
		List<Host> hostList = new ArrayList<Host>();
		SAXReader saxReader = new SAXReader();
		Document document = null;

		try
		{
			document = saxReader.read(new ByteArrayInputStream(xmlStr.getBytes()));
		}
		catch (DocumentException e)
		{
		}

		Element clusterELement = document.getRootElement().element("CLUSTER");
		long time = NumberUtils.toLong(clusterELement.attributeValue("LOCALTIME"));

		// ...
		for (Element element : (List<Element>) clusterELement.elements("HOST"))
		{
			hostList.add(parseHost(element, time));
		}

		return hostList;
	}

	private Host parseHost(Element hostElement, long time)
	{
		Host host = new Host();
		host.setIp(hostElement.attributeValue("IP"));
		host.setLocation(hostElement.attributeValue("LOCATION"));
		host.setName(hostElement.attributeValue("NAME"));
		host.setReportTime(new Date(NumberUtils.toLong(hostElement.attributeValue("REPORTED"))));
		Map<String, Metric> map = new HashMap<String, Metric>();
		for (Element element : (List<Element>) hostElement.elements("METRIC"))
		{
			Metric metric = parseMetric(element, host, time);
			map.put(metric.getName(), metric);
		}
		host.setMetricMap(map);
		return host;
	}

	private Metric parseMetric(Element metricElement, Host host, long time)
	{
		Metric metric = new Metric();
		metric.setIp(host.getIp());
		metric.setName(metricElement.attributeValue("NAME"));
		long tn = NumberUtils.toLong(metricElement.attributeValue("TN"));
		metric.setTime(new Date(time - tn));
		metric.setUnit(metricElement.attributeValue("UNITS"));
		metric.setValue(convertValue(metricElement.attributeValue("VAL"), metricElement.attributeValue("TYPE")));
		return metric;
	}
	
	private Object convertValue(String value, String type)
	{
		if(StringUtils.equals(type, "string"))
		{
			return value;
		}
		else if(StringUtils.equals(type, "float"))
		{
			return NumberUtils.toFloat(value);
		}
		else if(StringUtils.equals(type, "uint32"))
		{
			return value;
		}
		else if(StringUtils.equals(type, "double"))
		{
			return NumberUtils.toFloat(value);
		}
		else if(StringUtils.equals(type, "uint16"))
		{
			return value;
		}
		return new Object();
	}
}