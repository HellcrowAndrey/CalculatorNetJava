package ServerClient;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	ServerSocket ss;

	public Server(int port) throws IOException
	{
		ss = new ServerSocket(port);
	}
	
	public void run()
	{
		System.out.println("Weit for client: ");
		while (true)
		{
			try
			{
				Socket s = ss.accept();
				ServerReadWrite srw = new ServerReadWrite(s);
				Thread t = new Thread(srw);
				t.start();
			} catch (Exception e)
			{
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		new Server(8888).run();
	}
	
}
