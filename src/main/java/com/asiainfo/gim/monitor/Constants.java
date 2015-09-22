package com.asiainfo.gim.monitor;

public interface Constants
{
	public static final String INTERNAL_TOKEN = "E89CAF25-0479-4DE0-AB9B-C9E8F03EC365";
	
	public static interface RabbitMQ
	{
		public static final String SERVER_REPORT_EXCHANGE = "server_report_exchange";
	}
	

	public static interface AlertStatus
	{
		public static final int NEW = 0;
		public static final int CONFIRMED = 1; 
	}
	
	public static interface ResourceType
	{
		public static final int SERVER = 1;
	}
}
