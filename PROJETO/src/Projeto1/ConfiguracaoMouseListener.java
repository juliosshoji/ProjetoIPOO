/* ********************************************************************************
 * Group Noite 5
 * University of Campinas
 * School of Technology
 *
 * September, 24th, 2024.
 * Version 1.00
 *
 * Project 1 GUI  (Object Oriented Programming II - Si400)
 *
 * This class is used to listen to listen an action at the menu "Configuração"
 * and then open the necessary items and set the background using the BackgroundAnimator class
 * *********************************************************************************/
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
		String[] speeds = {"Lento", "Médio", "Rápido"};
        String speed = (String) JOptionPane.showInputDialog((JMenuItem)e.getSource(), "Escolha a velocidade:", 
                "Configurar Velocidade", JOptionPane.QUESTION_MESSAGE, null, speeds, this.backgroundanimator.getAnimationSpeedString());
        if (speed != null) {
            switch (speed) {
                case "Lento":
                	this.backgroundanimator.setAnimationSpeedString("Lento");
                	this.backgroundanimator.setSpeed(80);
                    break;
                case "Médio":
                	this.backgroundanimator.setAnimationSpeedString("Médio");
                	this.backgroundanimator.setSpeed(40);
                    break;
                case "Rápido":
                	this.backgroundanimator.setAnimationSpeedString("Rápido");
                	this.backgroundanimator.setSpeed(20);
                    break;
            }
        }
	}
		
	public void showColorMenu(ActionEvent e) {
		Color color1 = JColorChooser.showDialog((JMenuItem) e.getSource(), "Escolha a primeira cor", this.backgroundanimator.getPanel().getBackground());
		if(this.backgroundanimator.getCurrentPattern() != "Cor Sólida") {
	        Color color2 = JColorChooser.showDialog((JMenuItem) e.getSource(), "Escolha a segunda cor", this.backgroundanimator.getPanel().getBackground());
			if (color1 != null && color2 != null) {
	            this.backgroundanimator.setStaticColors(color1, color2);
	        }
		} else {
			this.backgroundanimator.setStaticColor1(color1);
		}
	}
	
	public void showPatternMenu(ActionEvent e) {
		String[] patterns = {"Gradiente", "Transição de Cores", "Padrão Geométrico", "Linhas Aleatórias", "Cor Sólida"};
        String pattern = (String) JOptionPane.showInputDialog((JMenuItem) e.getSource(), "Escolha um padrão:", 
                "Configurar Padrão", JOptionPane.QUESTION_MESSAGE, null, patterns, this.backgroundanimator.getCurrentPattern());
        if (pattern != null) {
        	this.backgroundanimator.setPattern(pattern);
	        	switch (pattern) {
	        	case "Padrão Geométrico":
	        		showColorMenu(e);
	        		break;
	            case "Gradiente":
	            	showColorMenu(e);
	                break;
	            case "Transição de Cores":
	            	break;
	            case "Padrão Imagem":
	            	break;
	            case "Cor Sólida":
	                showColorMenu(e);
	                break;
	        	}	
        }
	}
	
}