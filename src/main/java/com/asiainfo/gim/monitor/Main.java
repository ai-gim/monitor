package com.asiainfo.gim.monitor;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.gim.common.spring.SpringContext;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		// 初始化Spring
		String[] springConfigFiles = { "spring-base.xml", "spring-task.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfigFiles);

		// 初始化日志
		DOMConfigurator.configure(Main.class.getClassLoader().getResource("log4j.xml"));

		// 启动 HTTP Server
		String host = SpringContext.getProperty("service.monitor.host");
		int port = NumberUtils.toInt(SpringContext.getProperty("service.monitor.port"), 9004);

		URI baseUri = UriBuilder.fromUri("http://" + host).port(port).build();
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, new ServerApplication());
		server.start();

	}
}
