/* ********************************************************************************
 * Group Noite 5
 * University of Campinas
 * School of Technology
 *
 * September, 25th, 2024.
 * Version 1.00
 *
 * Project 1 GUI  (Object Oriented Programming II - Si400)
 *
 * This code illustrates the use of MouseAdapter interfaces to change the menu color on mouse hover
 * *********************************************************************************/
package Projeto1;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MenuHoverListener extends MouseAdapter {
	private Color originalColor;

	@Override
	public void mouseEntered(MouseEvent e) {
		JMenu menu = (JMenu) e.getSource();
		originalColor = menu.getBackground();
		menu.setOpaque(true);
		menu.setBackground(Color.GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		JMenu menu = (JMenu) e.getSource();
		menu.setBackground(originalColor);
	}

}