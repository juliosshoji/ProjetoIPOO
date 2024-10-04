package Projeto1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ConfiguracaoMouseListener implements ActionListener {
	
	private BackgroundAnimator backgroundanimator;
	
	ConfiguracaoMouseListener(BackgroundAnimator backgroundanimator){
		super();
		this.backgroundanimator = backgroundanimator;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Configurar Velocidade") {
			showSpeedMenu(e);
		}
		if(e.getActionCommand() == "Configurar Cor") {
			showColorMenu(e);
		}
		if(e.getActionCommand() == "Configurar Padrão") {
			showPatternMenu(e);
		}
	}
	
	
	public void showSpeedMenu(ActionEvent e) {
		
	}
		
	public void showColorMenu(ActionEvent e) {
		Color color1 = JColorChooser.showDialog((JMenuItem) e.getSource(), "Escolha a primeira cor", this.backgroundanimator.getPanel().getBackground());
        Color color2 = JColorChooser.showDialog((JMenuItem) e.getSource(), "Escolha a segunda cor", this.backgroundanimator.getPanel().getBackground());
        if (color1 != null && color2 != null) {
            this.backgroundanimator.setStaticColors(color1, color2); // Atualizar as cores
        }
	}
	
	public void showPatternMenu(ActionEvent e) {
		String[] patterns = {"Padrão 1", "Padrão 2", "Padrão 3"};
        String pattern = (String) JOptionPane.showInputDialog((JMenuItem) e.getSource(), "Escolha um padrão:", 
                "Configurar Padrão", JOptionPane.QUESTION_MESSAGE, null, patterns, patterns[0]);
        if (pattern != null) {
            // Mudar o padrão de fundo
        	 this.backgroundanimator.setPattern(pattern);
        }
	}
	
}