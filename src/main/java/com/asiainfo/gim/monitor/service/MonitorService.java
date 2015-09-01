package com.asiainfo.gim.monitor.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asiainfo.gim.monitor.dao.CpuAidleDao;
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
import com.asiainfo.gim.monitor.domain.query.MonitorQueryParam;
import com.asiainfo.gim.monitor.entity.Metric;

@Service
public class MonitorService
{
	CpuAidleDao cpuAidleDao;
	CpuNiceDao cpuNiceDao;
	CpuSpeedDao cpuSpeedDao;
	CpuStealDao cpuStealDao;
	CpuSystemDao cpuSystemDao;
	CpuUserDao cpuUserDao;
	CpuWioDao cpuWioDao;
	
	DiskFreeDao diskFreeDao;
	DiskPartMaxUsedDao diskPartMaxUsedDao;
	DiskTotalDao diskTotalDao;
	
	LoadFifteenDao loadFifteenDao;
	LoadFiveDao loadFiveDao;
	LoadOneDao loadOneDao;
	
	MemBuffersDao memBuffersDao;
	MemCachedDao memCachedDao;
	MemFreeDao memFreeDao;
	MemSharedDao memSharedDao;
	MemSwapFreeDao memSwapFreeDao;
	MemSwapTotalDao memSwapTotalDao;
	MemTotalDao memTotalDao;
	
	NetworkBytesInDao networkBytesInDao;
	NetworkBytesOutDao networkBytesOutDao;
	NetworkPktsInDao networkPktsInDao;
	NetworkPktsOutDao networkPktsOutDao;
	
	ProcRunDao procRunDao;
	ProcTotalDao procTotalDao;

	
	@Resource
	public void setCpuAidleDao(CpuAidleDao cpuAidleDao)
	{
		this.cpuAidleDao = cpuAidleDao;
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
	public void setLoadFiveDao(LoadFiveDao loadFiveDao)
	{
		this.loadFiveDao = loadFiveDao;
	}
	
	@Resource
	public void setLoadOneDao(LoadOneDao loadOneDao)
	{
		this.loadOneDao = loadOneDao;
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

	public List<Metric> listMetric(MonitorQueryParam monitorQueryParam){
		String indexName = monitorQueryParam.getIndexName();
		List<Metric> resultList= null;
		if(indexName.equals("cpu_aidle")){
			resultList = cpuAidleDao.listCpuAidle(monitorQueryParam);
		}else if(indexName.equals("cpu_nice")){
			resultList = cpuNiceDao.listCpuNice(monitorQueryParam);
		}else if(indexName.equals("cpu_speed")){
			resultList = cpuSpeedDao.listCpuSpeed(monitorQueryParam);
		}else if(indexName.equals("cpu_steal")){
			resultList = cpuStealDao.listCpuSteal(monitorQueryParam);
		}else if(indexName.equals("cpu_system")){
			resultList = cpuSystemDao.listCpuSystem(monitorQueryParam);
		}else if(indexName.equals("cpu_user")){
			resultList = cpuUserDao.listCpuUser(monitorQueryParam);
		}else if(indexName.equals("cpu_wio")){
			resultList = cpuWioDao.listCpuWio(monitorQueryParam);
		}else if(indexName.equals("disk_free")){
			resultList = diskFreeDao.listDiskFree(monitorQueryParam);
		}else if(indexName.equals("part_max_used")){
			resultList = diskPartMaxUsedDao.listDiskPartMaxUsed(monitorQueryParam);
		}else if(indexName.equals("disk_total")){
			resultList = diskTotalDao.listDiskTotal(monitorQueryParam);
		}else if(indexName.equals("load_fifteen")){
			resultList = loadFifteenDao.listLoadFifteen(monitorQueryParam);
		}else if(indexName.equals("load_five")){
			resultList = loadFiveDao.listLoadFive(monitorQueryParam);
		}else if(indexName.equals("load_one")){
			resultList = loadOneDao.listLoadOne(monitorQueryParam);
		}else if(indexName.equals("mem_buffers")){
			resultList = memBuffersDao.listMemBuffers(monitorQueryParam);
		}else if(indexName.equals("mem_cached")){
			resultList = memCachedDao.listMemCached(monitorQueryParam);
		}else if(indexName.equals("mem_free")){
			resultList = memFreeDao.listMemFree(monitorQueryParam);
		}else if(indexName.equals("mem_shared")){
			resultList = memSharedDao.listMemShared(monitorQueryParam);
		}else if(indexName.equals("swap_free")){
			resultList = memSwapFreeDao.listMemSwapFree(monitorQueryParam);
		}else if(indexName.equals("swap_total")){
			resultList = memSwapTotalDao.listMemSwapTotal(monitorQueryParam);
		}else if(indexName.equals("mem_total")){
			resultList = memTotalDao.listMemTotal(monitorQueryParam);
		}else if(indexName.equals("bytes_in")){
			resultList = networkBytesInDao.listNetworkBytesIn(monitorQueryParam);
		}else if(indexName.equals("bytes_out")){
			resultList = networkBytesOutDao.listNetworkBytesOut(monitorQueryParam);
		}else if(indexName.equals("pkts_in")){
			resultList = networkPktsInDao.listNetworkPktsIn(monitorQueryParam);
		}else if(indexName.equals("pkts_out")){
			resultList = networkPktsOutDao.listNetworkPktsOut(monitorQueryParam);
		}else if(indexName.equals("proc_run")){
			resultList = procRunDao.listProcRun(monitorQueryParam);
		}else if(indexName.equals("proc_total")){
			resultList = procTotalDao.listProcTotal(monitorQueryParam);
		}else{
			resultList = new ArrayList<Metric>();
		}
		return resultList;
	}
	
}
