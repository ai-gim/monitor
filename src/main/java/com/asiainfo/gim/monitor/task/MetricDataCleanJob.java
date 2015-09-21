package com.asiainfo.gim.monitor.task;

import java.util.Date;

import com.asiainfo.gim.monitor.domain.delete.MetricDeleteParam;

public class MetricDataCleanJob extends DaoCollection
{

	//历史数据保留的天数（以天为单位）
	private long keepDuration;
	
	public void setKeepDuration(long keepDuration)
	{
		this.keepDuration = keepDuration;
	}

	public void doClean(){
		deleteGangliaMetric();
	}
	
	private void deleteGangliaMetric(){
		MetricDeleteParam metricDeleteParam = new MetricDeleteParam();
		long currectTime = new Date().getTime();
		long targetTime = currectTime - keepDuration*24*3600*1000;
		metricDeleteParam.setStartTime(new Date(targetTime));
		
		cpuAidleDao.deleteCpuAidle(metricDeleteParam);
		cpuIdleDao.deleteCpuIdle(metricDeleteParam);
		cpuNiceDao.deleteCpuNice(metricDeleteParam);
		cpuSpeedDao.deleteCpuSpeed(metricDeleteParam);
		cpuStealDao.deleteCpuSteal(metricDeleteParam);
		cpuSystemDao.deleteCpuSystem(metricDeleteParam);
		cpuUserDao.deleteCpuUser(metricDeleteParam);
		cpuWioDao.deleteCpuWio(metricDeleteParam);
		diskFreeDao.deleteDiskFree(metricDeleteParam);
		diskPartMaxUsedDao.deleteDiskPartMaxUsed(metricDeleteParam);
		diskTotalDao.deleteDiskTotal(metricDeleteParam);
		loadFifteenDao.deleteLoadFifteen(metricDeleteParam);
		loadOneDao.deleteLoadOne(metricDeleteParam);
		loadFiveDao.deleteLoadFive(metricDeleteParam);
		memBuffersDao.deleteMemBuffers(metricDeleteParam);
		memCachedDao.deleteMemCached(metricDeleteParam);
		memFreeDao.deleteMemFree(metricDeleteParam);
		memSharedDao.deleteMemShared(metricDeleteParam);
		memSwapFreeDao.deleteMemSwapFree(metricDeleteParam);
		memSwapTotalDao.deleteMemSwapTotal(metricDeleteParam);
		memTotalDao.deleteMemTotal(metricDeleteParam);
		networkBytesInDao.deleteNetworkBytesIn(metricDeleteParam);
		networkBytesOutDao.deleteNetworkBytesOut(metricDeleteParam);
		networkPktsInDao.deleteNetworkPktsIn(metricDeleteParam);
		networkPktsOutDao.deleteNetworkPktsOut(metricDeleteParam);
		procRunDao.deleteProcRun(metricDeleteParam);
		procTotalDao.deleteProcTotal(metricDeleteParam);
	}
}
