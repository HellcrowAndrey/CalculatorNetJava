package view;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import ServerClient.Client;
import blogic.PCommand;

public class PFrame extends JFrame
{

	public PFrame(Client client) throws UnknownHostException, IOException
	{
		setLayout(null);
		setBounds(250, 250, 600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PCommand cmd = new PCommand(client);
		PPanel pan = new PPanel(cmd);
		cmd.setPan(pan);
		pan.setBounds(0, 0, 600, 400);
		add(pan);
		setVisible(true);
	}
}
