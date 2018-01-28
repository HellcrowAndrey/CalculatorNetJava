package ServerClient;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import view.PPanel;

public class ClientRead implements Runnable
{

	private Socket s;
	private DataInputStream in;
	private String outLine;
	private PPanel pan;

	public ClientRead(Socket s, PPanel pan) throws IOException
	{
		this.s = s;
		this.pan = pan;
		this.in = new DataInputStream(s.getInputStream());
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				outLine = in.readUTF();
				System.out.println("1 " + outLine);
				pan.getTxtC().setText(outLine);
			}
		} catch (IOException e)
		{
		}
	}

}
