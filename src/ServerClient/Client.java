package ServerClient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	Socket s;
	DataOutputStream out;
	String line;

	public Client(String host, int port) throws UnknownHostException, IOException
	{
		this.s = new Socket(host, port);
		this.out = new DataOutputStream(s.getOutputStream());
	}

	public void setLine(String line)
	{
		this.line = line;
	}

	public Socket getS()
	{
		return s;
	}

	public void run()
	{
		System.out.println("Write the txt: ");
		while (true)
		{
			try
			{
				out.writeUTF(line);
				out.flush();
				// System.out.println(in.readUTF());
				line = "";
			} catch (Exception e)
			{
			}
		}
	}
}
