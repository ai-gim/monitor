package com.asiainfo.gim.monitor.dao;

import java.util.List;

import com.asiainfo.gim.monitor.domain.Alert;
import com.asiainfo.gim.monitor.domain.query.AlertQueryParam;

public interface AlertDao
{

	public void insertAlert(Alert alert);

	public List<Alert> listAlerts(AlertQueryParam alertQueryParam);

	public Alert findAlertById(String id);

	public void updateAlert(Alert alert);

	public void deleteAlert(String id);
}
