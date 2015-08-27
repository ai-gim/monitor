/**
 * @author wangjy
 *
 */
package com.asiainfo.gim.monitor.ganglia;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.stereotype.Component;
@Component
public class GangliaFetchXml
{

	private static final String targetIp = "172.16.102.130";
	private static final int targetPort = 8649;

	public String fetchGangliaXml()
	{
		TelnetClient tt = new TelnetClient();
		try
		{
			tt.connect(targetIp, targetPort);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			IOUtils.copy(tt.getInputStream(), out);
			tt.disconnect();
		    return new String(out.toByteArray());
		}
		catch (SocketException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return "";
	}


	public static void main(String[] args)
	{
		GangliaFetchXml g = new GangliaFetchXml();
		String xmlStr = g.fetchGangliaXml();
		System.out.println(xmlStr);
		FileWriter fileWriter = null;
		try
		{
			fileWriter = new FileWriter("C:/Users/wangjy/Desktop/data.xml");
			fileWriter.write(xmlStr);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fileWriter.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			fileWriter = null;
		}
	}

}