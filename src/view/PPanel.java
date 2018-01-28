package view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import blogic.PCommand;

public class PPanel extends JPanel
{
	private PCommand cmd;
	private JTextField txtC;
	
	public PPanel(PCommand cmd)
	{
		this.cmd = cmd;
		setLayout(null);
		JButton btnOk = new JButton("Ok");
		
		JTextField txtA = new JTextField();
		JTextField txtB = new JTextField();
		txtC = new JTextField();
		JTextField txtSymbol = new JTextField();
		
		btnOk.setBounds(10, 180, 70, 30);
		
		txtA.setBounds(10, 10, 70, 30);
		txtSymbol.setBounds(10, 50, 70, 30);
		txtB.setBounds(10, 90, 70, 30);
		txtC.setBounds(10, 130, 70, 30);
		
		btnOk.addActionListener(cmd.getActBtnOk());
		
		txtA.addActionListener(cmd.getActTxt());
		txtSymbol.addActionListener(cmd.getActTxt());
		txtB.addActionListener(cmd.getActTxt());
		
		add(btnOk);
		add(txtA);
		add(txtB);
		add(txtC);
		add(txtSymbol);
	}

	public JTextField getTxtC()
	{
		return txtC;
	}

}
