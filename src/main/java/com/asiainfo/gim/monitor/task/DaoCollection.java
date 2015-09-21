package com.asiainfo.gim.monitor.task;

import javax.annotation.Resource;

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

public class DaoCollection
{

	protected CpuAidleDao cpuAidleDao;
	protected CpuIdleDao cpuIdleDao;
	protected CpuNiceDao cpuNiceDao;
	protected CpuSpeedDao cpuSpeedDao;
	protected CpuStealDao cpuStealDao;
	protected CpuSystemDao cpuSystemDao;
	protected CpuUserDao cpuUserDao;
	protected CpuWioDao cpuWioDao;
	protected DiskFreeDao diskFreeDao;
	protected DiskPartMaxUsedDao diskPartMaxUsedDao;
	protected DiskTotalDao diskTotalDao;
	protected LoadFifteenDao loadFifteenDao;
	protected LoadOneDao loadOneDao;
	protected LoadFiveDao loadFiveDao;
	protected MemBuffersDao memBuffersDao;
	protected MemCachedDao memCachedDao;
	protected MemFreeDao memFreeDao;
	protected MemSharedDao memSharedDao;
	protected MemSwapFreeDao memSwapFreeDao;
	protected MemSwapTotalDao memSwapTotalDao;
	protected MemTotalDao memTotalDao;
	protected NetworkBytesInDao networkBytesInDao;
	protected NetworkBytesOutDao networkBytesOutDao;
	protected NetworkPktsInDao networkPktsInDao;
	protected NetworkPktsOutDao networkPktsOutDao;
	protected ProcRunDao procRunDao;
	protected ProcTotalDao procTotalDao;

	
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
}
