package Projeto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ConfiguracaoItemsListener extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static JFrame parent;
	
	ConfiguracaoItemsListener(JFrame parent){
		super();
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Velocidade") {
			System.out.println("1");
		}
		if(arg0.getActionCommand() == "Definir Cor") {
			System.out.println("2");
		}
		if(arg0.getActionCommand() == "Padrão") {
			System.out.println("3");
		}
	}

}
