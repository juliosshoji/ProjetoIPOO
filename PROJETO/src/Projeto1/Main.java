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
 * This code illustrates the creation of a new Window instance 
 ** *********************************************************************************/
package Projeto1;

public class Main {
	public static void main(String[] args) {
		try {
			new Window();
		} catch (Exception e) {
			System.out.println(
					"Exceção disparada: " + e.getStackTrace() + "\n" + e.getLocalizedMessage() + "\n" + e.getMessage());
		}
	}
}
