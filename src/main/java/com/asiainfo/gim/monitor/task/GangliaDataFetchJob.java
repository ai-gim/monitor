package com.asiainfo.gim.monitor.task;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.asiainfo.gim.common.amqp.rabbitmq.RabbitMQTemplate;
import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.Constants;
import com.asiainfo.gim.monitor.base.DaoCollection;
import com.asiainfo.gim.monitor.entity.Host;
import com.asiainfo.gim.monitor.entity.Metric;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlFetcher;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlParser;

public class GangliaDataFetchJob extends DaoCollection
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
		for(Host host : hosts){
			Map<String, Metric> metricMap = host.getMetrics();
			Set<String> set = metricMap.keySet();
			for(String meticName : set){
				saveMetricByName(metricMap.get(meticName));
			}
		}
	}
	
	private void saveMetricByName(Metric metric){
		String metricName = metric.getName();
		if("cpu_aidle".equalsIgnoreCase(metricName)){
			cpuAidleDao.insertCpuAidle(metric);
		}else if("cpu_idle".equalsIgnoreCase(metricName)){
			cpuIdleDao.insertCpuIdle(metric);
		}else if("cpu_nice".equalsIgnoreCase(metricName)){
			cpuNiceDao.insertCpuNice(metric);
		}else if("cpu_speed".equalsIgnoreCase(metricName)){
			cpuSpeedDao.insertCpuSpeed(metric);
		}else if("cpu_steal".equalsIgnoreCase(metricName)){
			cpuStealDao.insertCpuSteal(metric);
		}else if("cpu_system".equalsIgnoreCase(metricName)){
			cpuSystemDao.insertCpuSystem(metric);
		}else if("cpu_user".equalsIgnoreCase(metricName)){
			cpuUserDao.insertCpuUser(metric);
		}else if("cpu_wio".equalsIgnoreCase(metricName)){
			cpuWioDao.insertCpuWio(metric);
		}else if("disk_free".equalsIgnoreCase(metricName)){
			diskFreeDao.insertDiskFree(metric);
		}else if("part_max_used".equalsIgnoreCase(metricName)){
			diskPartMaxUsedDao.insertDiskPartMaxUsed(metric);
		}else if("disk_total".equalsIgnoreCase(metricName)){
			diskTotalDao.insertDiskTotal(metric);
		}else if("load_fifteen".equalsIgnoreCase(metricName)){
			loadFifteenDao.insertLoadFifteen(metric);
		}else if("load_one".equalsIgnoreCase(metricName)){
			loadOneDao.insertLoadOne(metric);
		}else if("load_five".equalsIgnoreCase(metricName)){
			loadFiveDao.insertLoadFive(metric);
		}else if("mem_buffers".equalsIgnoreCase(metricName)){
			memBuffersDao.insertMemBuffers(metric);
		}else if("mem_cached".equalsIgnoreCase(metricName)){
			memCachedDao.insertMemCached(metric);
		}else if("mem_free".equalsIgnoreCase(metricName)){
			memFreeDao.insertMemFree(metric);
		}else if("mem_shared".equalsIgnoreCase(metricName)){
			memSharedDao.insertMemShared(metric);
		}else if("swap_free".equalsIgnoreCase(metricName)){
			memSwapFreeDao.insertMemSwapFree(metric);
		}else if("swap_total".equalsIgnoreCase(metricName)){
			memSwapTotalDao.insertMemSwapTotal(metric);
		}else if("mem_total".equalsIgnoreCase(metricName)){
			memTotalDao.insertMemTotal(metric);
		}else if("bytes_in".equalsIgnoreCase(metricName)){
			networkBytesInDao.insertNetworkBytesIn(metric);
		}else if("bytes_out".equalsIgnoreCase(metricName)){
			networkBytesOutDao.insertNetworkBytesOut(metric);
		}else if("pkts_in".equalsIgnoreCase(metricName)){
			networkPktsInDao.insertNetworkPktsIn(metric);
		}else if("pkts_out".equalsIgnoreCase(metricName)){
			networkPktsOutDao.insertNetworkPktsOut(metric);
		}else if("proc_run".equalsIgnoreCase(metricName)){
			procRunDao.insertProcRun(metric);
		}else if("proc_total".equalsIgnoreCase(metricName)){
			procTotalDao.insertProcTotal(metric);
		}else{
			
		}
	}

	private void reportData(List<Host> hosts)
	{
		RabbitMQTemplate rabbitMQTemplate = (RabbitMQTemplate) SpringContext.getBean("rabbitMQTemplate");
		for (Host host : hosts)
		{
			rabbitMQTemplate.send(Constants.RabbitMQ.SERVER_REPORT_EXCHANGE, Constants.RabbitMQ.SERVER_REPORT_ROUTINGKEY, host);
		}
	}
}
