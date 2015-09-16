package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;
import com.asiainfo.gim.monitor.entity.Alert;

public interface AlertDao
{

	public void insertAlertMetric(Alert alertMetric);
	
	public List<Alert> listAlertMetric(AlertQueryParam alertQueryParam);
}
