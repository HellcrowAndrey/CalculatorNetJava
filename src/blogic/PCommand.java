package blogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ServerClient.Client;
import ServerClient.ClientRead;
import view.PPanel;

public class PCommand
{

	private ActBtnOk actBtnOk = new ActBtnOk();
	private ActTxt actTxt = new ActTxt();
	private String line = "";
	private Client client;
	private ClientRead cr;
	private PPanel pan;

	public PCommand(Client client)
	{
		this.client = client;
	}

	public Client getClient()
	{
		return client;
	}

	public ActBtnOk getActBtnOk()
	{
		return actBtnOk;
	}

	public ActTxt getActTxt()
	{
		return actTxt;
	}

	public void setPan(PPanel pan)
	{
		this.pan = pan;
	}

	private class ActTxt implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String str = e.getActionCommand();
			line += str;
		}
	}

	private class ActBtnOk implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			client.setLine(line);
			ClientRead cr;
			try
			{
				cr = new ClientRead(client.getS(), pan);
				Thread t = new Thread(cr);
				t.start();
			} catch (IOException e1)
			{
			}
		}
	}
}
