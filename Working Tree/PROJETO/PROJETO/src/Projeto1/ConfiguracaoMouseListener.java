package Projeto1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class ConfiguracaoMouseListener extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		JFrame ConfigPanel = new JFrame();
		ConfigPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ConfigPanel.setSize(512, 288); // Define o tamanho da janela
        ConfigPanel.setLayout(new BorderLayout());
        ConfigPanel.getContentPane().setBackground(Color.PINK);
        
		JMenuBar menuBar = new JMenuBar();
		
		JMenu Pattern = new JMenu("Padrão");
        JMenu Color = new JMenu("Definir Cor");
        JMenu Speed = new JMenu("Velocidade");
        
        menuBar.add(Color);
        menuBar.add(Pattern);
        menuBar.add(Speed);
        
        ConfigPanel.setJMenuBar(menuBar);
        
        Speed.addActionListener(new ConfiguracaoItemsListener(ConfigPanel));
        Color.addActionListener(new ConfiguracaoItemsListener(ConfigPanel));
        Pattern.addActionListener(new ConfiguracaoItemsListener(ConfigPanel));
        
        ConfigPanel.setVisible(rootPaneCheckingEnabled);
        
	}
}
