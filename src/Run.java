import java.io.IOException;
import java.net.UnknownHostException;

import ServerClient.Client;
import view.PFrame;

public class Run
{
	public static void main(String args[]) throws UnknownHostException, IOException
	{
		Client client= new Client("localhost", 8888);
		new PFrame(client);
		client.run();
	}
}
