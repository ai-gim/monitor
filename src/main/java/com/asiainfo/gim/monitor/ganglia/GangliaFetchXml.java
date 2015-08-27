/**
 * @author wangjy
 *
 */
package com.asiainfo.gim.monitor.ganglia;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class GangliaFetchXml
{

	private static final String targetIp = "localhost";
	private static final int targetPort = 8649;

	public static Socket getSocketConn() throws Exception
	{
		Socket socket = new Socket(targetIp, targetPort);
		return socket;
	}

	public static String fetchGangliaXml()
	{
		Socket socket = null;
		InputStream is = null;
		try
		{
			socket = getSocketConn();
			is = socket.getInputStream();
			byte[] byteArray = new byte[1024];
			int len;
			StringBuffer sb = new StringBuffer();
			while ((len = is.read(byteArray)) != -1)
			{
				sb.append(new String(byteArray, 0, len));
			}
			return sb.toString();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			closeInputStream(is);
			closeSocket(socket);
		}
		return "";

	}

	public static void closeSocket(Socket socket)
	{
		IOUtils.closeQuietly(socket);
	}

	public static void closeInputStream(InputStream is)
	{
		IOUtils.closeQuietly(is);
	}

}