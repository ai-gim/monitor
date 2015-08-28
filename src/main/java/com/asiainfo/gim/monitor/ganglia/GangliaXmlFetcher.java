/**
 * @author wangjy
 *
 */
package com.asiainfo.gim.monitor.ganglia;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.stereotype.Component;

@Component
public class GangliaXmlFetcher
{
	private Log log = LogFactory.getLog(GangliaXmlFetcher.class);
	
	public String fetchGangliaXml(String ip, int port)
	{
		TelnetClient tt = new TelnetClient();
		try
		{
			tt.connect(ip, port);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			IOUtils.copy(tt.getInputStream(), out);
		    return new String(out.toByteArray());
		}
		catch (Exception e)
		{
			log.error(e.getMessage(), e);
		}
		finally
		{
			try
			{
				tt.disconnect();
			}
			catch (IOException e)
			{
				log.error(e.getMessage(), e);
			}
		}
		
		return null;
	}
}