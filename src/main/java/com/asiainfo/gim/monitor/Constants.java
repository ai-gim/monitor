package com.asiainfo.gim.monitor;

public interface Constants
{
	public static interface RabbitMQ
	{
		public static final String SERVER_REPORT_QUEUE = "server_report_queue";
		public static final String SERVER_REPORT_EXCHANGE = "server_report_exchange";
		public static final String SERVER_REPORT_ROUTINGKEY = "server_report";
	}
}
