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
 * This code illustrates the use of a user help image
 * *********************************************************************************/
package Projeto1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage Image;
	
	public ImagePanel() {
		try {
			String path = "imagem.jpeg";
			this.Image = ImageIO.read(new File(path));
			this.setSize(this.Image.getWidth(), this.Image.getHeight());
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(this.Image, 0, 0, this);
	}
	
	public BufferedImage getImage() {
		return this.Image;
	}
}
