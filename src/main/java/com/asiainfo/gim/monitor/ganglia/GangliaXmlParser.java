package com.asiainfo.gim.monitor.ganglia;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.asiainfo.gim.monitor.entity.SysXmlEntity;

public class GangliaXmlParser
{
	//集群信息
	public final static String cluster = "CLUSTER";
	public final static String localtime = "LOCALTIME";
	public final static String ip = "IP";
	public final static String hostTMax = "TMAX";
	
	//指标信息
	public final static String indexName = "NAME";
	public final static String indexValue = "VAL";
	public final static String indexUnit = "UNITS";
	
	
	
	public static List<SysXmlEntity> doResolve(String xmlStr){
		
			SAXReader saxReader = new SAXReader();
			Document document;
			try
			{
				document = saxReader.read(new ByteArrayInputStream(xmlStr.getBytes()));
				Element root = document.getRootElement();
				Element clusterELement = root.element(cluster);
				Attribute localtimeAttr = clusterELement.attribute(localtime);
				// 当前时间
			    long localtime = Long.parseLong(localtimeAttr.getValue()) * 1000;
			    List<SysXmlEntity> resultList = new ArrayList<SysXmlEntity>();
			    for(Iterator iteratorRoot = clusterELement.elementIterator(); iteratorRoot.hasNext();){
			    	Element hostELement = (Element) iteratorRoot.next();
			    	//ip
			    	String hostIp = hostELement.attributeValue(ip);
			    	//此主机采集超时时间
			    	long hostTimeout = Long.parseLong(hostELement.attributeValue(hostTMax))*1000;
			    	for(Iterator metricData = hostELement.elementIterator(); metricData.hasNext();){
			    		Element metricElement = (Element) metricData.next();
			    		SysXmlEntity entity = new SysXmlEntity(metricElement.attributeValue(indexName), 
			    				metricElement.attributeValue(indexUnit), 
			    				localtime, hostIp, hostTimeout);
			    		resultList.add(entity);
			    	}
			    }
			    return resultList;
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
			return new ArrayList<SysXmlEntity>(); 
	}

}

