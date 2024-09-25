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
 * This code illustrates the use of MouseAdapter interfaces to exit the program when interacting with JMenu
 * *********************************************************************************/

package Projeto1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SairMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }
}
