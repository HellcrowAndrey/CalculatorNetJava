package ServerClient;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerReadWrite implements Runnable
{

	Socket s;
	DataInputStream in;
	DataOutputStream out;

	public ServerReadWrite(Socket s) throws IOException
	{
		this.s = s;
		in = new DataInputStream(s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
	}

	@Override
	public void run()
	{
		String str = "";
		try
		{
			while (true)
			{
				String line = in.readUTF();
				System.out.println(line);
				if (line != "" && line != null)
				{
					str += line;
				}
				String number = str.replaceAll("[+-/*]", " ");
				String arr[] = number.split(" ");
				String symbol = str.replaceAll("[1-9]+", "");	
				out.writeUTF( calc(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), symbol)+ "");
				out.flush();
				str = "";
			}
		} catch (Exception e)
		{
		}
	}
	
	public int calc(int p1, int p2, String op)
	{
		int rez = 0;
		switch (op)
		{
		case "+":
			rez = p1 + p2;
			break;
		case "-":
			rez = p1 - p2;
			break;
		case "*":
			rez = p1 * p2;
			break;
		case "/":
			rez = p1 / p2;
			break;
		}
		return rez;
	}

}
