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
 * This code illustrates the use of the Action Listener interface to exit the system
 * *********************************************************************************/
package Projeto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
	public ExitListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
}

