package com.asiainfo.gim.monitor.task;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.asiainfo.gim.common.amqp.rabbitmq.RabbitMQTemplate;
import com.asiainfo.gim.common.spring.SpringContext;
import com.asiainfo.gim.monitor.Constants;
import com.asiainfo.gim.monitor.dao.CpuAidleDao;
import com.asiainfo.gim.monitor.dao.CpuIdleDao;
import com.asiainfo.gim.monitor.dao.CpuNiceDao;
import com.asiainfo.gim.monitor.dao.CpuSpeedDao;
import com.asiainfo.gim.monitor.dao.CpuStealDao;
import com.asiainfo.gim.monitor.dao.CpuSystemDao;
import com.asiainfo.gim.monitor.dao.CpuUserDao;
import com.asiainfo.gim.monitor.dao.CpuWioDao;
import com.asiainfo.gim.monitor.dao.DiskFreeDao;
import com.asiainfo.gim.monitor.dao.DiskPartMaxUsedDao;
import com.asiainfo.gim.monitor.dao.DiskTotalDao;
import com.asiainfo.gim.monitor.dao.LoadFifteenDao;
import com.asiainfo.gim.monitor.dao.LoadFiveDao;
import com.asiainfo.gim.monitor.dao.LoadOneDao;
import com.asiainfo.gim.monitor.dao.MemBuffersDao;
import com.asiainfo.gim.monitor.dao.MemCachedDao;
import com.asiainfo.gim.monitor.dao.MemFreeDao;
import com.asiainfo.gim.monitor.dao.MemSharedDao;
import com.asiainfo.gim.monitor.dao.MemSwapFreeDao;
import com.asiainfo.gim.monitor.dao.MemSwapTotalDao;
import com.asiainfo.gim.monitor.dao.MemTotalDao;
import com.asiainfo.gim.monitor.dao.NetworkBytesInDao;
import com.asiainfo.gim.monitor.dao.NetworkBytesOutDao;
import com.asiainfo.gim.monitor.dao.NetworkPktsInDao;
import com.asiainfo.gim.monitor.dao.NetworkPktsOutDao;
import com.asiainfo.gim.monitor.dao.ProcRunDao;
import com.asiainfo.gim.monitor.dao.ProcTotalDao;
import com.asiainfo.gim.monitor.entity.Host;
import com.asiainfo.gim.monitor.entity.Metric;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlFetcher;
import com.asiainfo.gim.monitor.ganglia.GangliaXmlParser;

public class GangliaDataFetchJob
{

	private GangliaXmlFetcher gangliaXmlFetcher;
	private GangliaXmlParser gangliaXmlParser;

	private boolean report;

	private String ip;
	private int port;
	
	private CpuAidleDao cpuAidleDao;
	private CpuIdleDao cpuIdleDao;
	private CpuNiceDao cpuNiceDao;
	private CpuSpeedDao cpuSpeedDao;
	private CpuStealDao cpuStealDao;
	private CpuSystemDao cpuSystemDao;
	private CpuUserDao cpuUserDao;
	private CpuWioDao cpuWioDao;
	private DiskFreeDao diskFreeDao;
	private DiskPartMaxUsedDao diskPartMaxUsedDao;
	private DiskTotalDao diskTotalDao;
	private LoadFifteenDao loadFifteenDao;
	private LoadOneDao loadOneDao;
	private LoadFiveDao loadFiveDao;
	private MemBuffersDao memBuffersDao;
	private MemCachedDao memCachedDao;
	private MemFreeDao memFreeDao;
	private MemSharedDao memSharedDao;
	private MemSwapFreeDao memSwapFreeDao;
	private MemSwapTotalDao memSwapTotalDao;
	private MemTotalDao memTotalDao;
	private NetworkBytesInDao networkBytesInDao;
	private NetworkBytesOutDao networkBytesOutDao;
	private NetworkPktsInDao networkPktsInDao;
	private NetworkPktsOutDao networkPktsOutDao;
	private ProcRunDao procRunDao;
	private ProcTotalDao procTotalDao;

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
	
	@Resource
	public void setCpuAidleDao(CpuAidleDao cpuAidleDao)
	{
		this.cpuAidleDao = cpuAidleDao;
	}

	@Resource
	public void setCpuIdleDao(CpuIdleDao cpuIdleDao)
	{
		this.cpuIdleDao = cpuIdleDao;
	}

	@Resource
	public void setCpuNiceDao(CpuNiceDao cpuNiceDao)
	{
		this.cpuNiceDao = cpuNiceDao;
	}

	@Resource
	public void setCpuSpeedDao(CpuSpeedDao cpuSpeedDao)
	{
		this.cpuSpeedDao = cpuSpeedDao;
	}

	@Resource
	public void setCpuStealDao(CpuStealDao cpuStealDao)
	{
		this.cpuStealDao = cpuStealDao;
	}

	@Resource
	public void setCpuSystemDao(CpuSystemDao cpuSystemDao)
	{
		this.cpuSystemDao = cpuSystemDao;
	}

	@Resource
	public void setCpuUserDao(CpuUserDao cpuUserDao)
	{
		this.cpuUserDao = cpuUserDao;
	}

	@Resource
	public void setCpuWioDao(CpuWioDao cpuWioDao)
	{
		this.cpuWioDao = cpuWioDao;
	}

	@Resource
	public void setDiskFreeDao(DiskFreeDao diskFreeDao)
	{
		this.diskFreeDao = diskFreeDao;
	}

	@Resource
	public void setDiskPartMaxUsedDao(DiskPartMaxUsedDao diskPartMaxUsedDao)
	{
		this.diskPartMaxUsedDao = diskPartMaxUsedDao;
	}

	@Resource
	public void setDiskTotalDao(DiskTotalDao diskTotalDao)
	{
		this.diskTotalDao = diskTotalDao;
	}

	@Resource
	public void setLoadFifteenDao(LoadFifteenDao loadFifteenDao)
	{
		this.loadFifteenDao = loadFifteenDao;
	}

	@Resource
	public void setLoadOneDao(LoadOneDao loadOneDao)
	{
		this.loadOneDao = loadOneDao;
	}

	@Resource
	public void setLoadFiveDao(LoadFiveDao loadFiveDao)
	{
		this.loadFiveDao = loadFiveDao;
	}

	@Resource
	public void setMemBuffersDao(MemBuffersDao memBuffersDao)
	{
		this.memBuffersDao = memBuffersDao;
	}

	@Resource
	public void setMemCachedDao(MemCachedDao memCachedDao)
	{
		this.memCachedDao = memCachedDao;
	}

	@Resource
	public void setMemFreeDao(MemFreeDao memFreeDao)
	{
		this.memFreeDao = memFreeDao;
	}

	@Resource
	public void setMemSharedDao(MemSharedDao memSharedDao)
	{
		this.memSharedDao = memSharedDao;
	}

	@Resource
	public void setMemSwapFreeDao(MemSwapFreeDao memSwapFreeDao)
	{
		this.memSwapFreeDao = memSwapFreeDao;
	}

	@Resource
	public void setMemSwapTotalDao(MemSwapTotalDao memSwapTotalDao)
	{
		this.memSwapTotalDao = memSwapTotalDao;
	}

	@Resource
	public void setMemTotalDao(MemTotalDao memTotalDao)
	{
		this.memTotalDao = memTotalDao;
	}

	@Resource
	public void setNetworkBytesInDao(NetworkBytesInDao networkBytesInDao)
	{
		this.networkBytesInDao = networkBytesInDao;
	}

	@Resource
	public void setNetworkBytesOutDao(NetworkBytesOutDao networkBytesOutDao)
	{
		this.networkBytesOutDao = networkBytesOutDao;
	}

	@Resource
	public void setNetworkPktsInDao(NetworkPktsInDao networkPktsInDao)
	{
		this.networkPktsInDao = networkPktsInDao;
	}

	@Resource
	public void setNetworkPktsOutDao(NetworkPktsOutDao networkPktsOutDao)
	{
		this.networkPktsOutDao = networkPktsOutDao;
	}

	@Resource
	public void setProcRunDao(ProcRunDao procRunDao)
	{
		this.procRunDao = procRunDao;
	}

	@Resource
	public void setProcTotalDao(ProcTotalDao procTotalDao)
	{
		this.procTotalDao = procTotalDao;
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
		if (metric.getTn() >= 20)
		{
			return;
		}
		
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
			rabbitMQTemplate.send(Constants.RabbitMQ.SERVER_REPORT_EXCHANGE, "", host);
		}
	}
}
