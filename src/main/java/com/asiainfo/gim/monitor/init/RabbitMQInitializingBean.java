/**   
 * @Title: RabbitMQInitializingBean.java 
 * @Package com.asiainfo.gim.monitor.init 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年8月28日 上午11:18:58 
 * @version V1.0   
 */
package com.asiainfo.gim.monitor.init;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.asiainfo.gim.common.amqp.rabbitmq.RabbitMQTemplate;
import com.asiainfo.gim.monitor.Constants;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author zhangli
 *
 */
@Component
public class RabbitMQInitializingBean implements InitializingBean, ApplicationContextAware
{
	private ApplicationContext context;

	@Value("${is.data.report}")
	private boolean report;

	@Value("${rabbitmq.host}")
	private String host;

	@Value("${rabbitmq.port}")
	private int port;

	@Value("${rabbitmq.virtualhost}")
	private String virtualHost;

	@Value("${rabbitmq.username}")
	private String username;

	@Value("${rabbitmq.password}")
	private String password;

	public void afterPropertiesSet() throws Exception
	{
		if (report)
		{
			ConnectionFactory cf = new ConnectionFactory();
			cf.setHost(host);
			cf.setPort(port);
			cf.setVirtualHost(virtualHost);
			cf.setUsername(username);
			cf.setPassword(password);

			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RabbitMQTemplate.class);
			builder.addPropertyValue("connectionFactory", cf);

			ConfigurableApplicationContext cac = (ConfigurableApplicationContext) context;
			DefaultListableBeanFactory factory = (DefaultListableBeanFactory) cac.getBeanFactory();
			factory.registerBeanDefinition("rabbitMQTemplate", builder.getBeanDefinition());

			RabbitMQTemplate rabbitMQTemplate = (RabbitMQTemplate) context.getBean("rabbitMQTemplate");
			rabbitMQTemplate.exchangeDeclare(Constants.RabbitMQ.SERVER_REPORT_EXCHANGE, "fanout");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.context = applicationContext;
	}
}
