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
 * This class is used to control the background of the aplication
 * Diferent color and color patterns can be selected in the menu
 * *********************************************************************************/
package Projeto1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BackgroundAnimator implements Runnable {

	private JPanel panel;
	private int animationSpeed = 50;
	private float hue = 0f;
	private String currentPattern = "Cor Sólida";
	private Color staticColor1 = Color.PINK;
	private Color staticColor2 = Color.PINK;
	private boolean running = true;
	private Random random = new Random();
	private String animationSpeedString;
	private boolean alternateColors = false;
	private int cyclecounter = 0;

	public BackgroundAnimator(JPanel panel) {
		this.panel = panel;
		startBackgroundAnimation();
	}

	public JPanel getPanel() {
		return this.panel;
	}

	public void setStaticColor1(Color color1) {
		this.staticColor1 = color1;
	}

	public String getCurrentPattern() {
		return this.currentPattern;
	}

	public void setPattern(String pattern) {
		currentPattern = pattern;
		panel.repaint();
	}

	public void setSpeed(int speed) {
		this.animationSpeed = speed;
	}

	public void setStaticColors(Color color1, Color color2) {
		this.staticColor1 = color1;
		this.staticColor2 = color2;
		panel.repaint();
	}

	public void startBackgroundAnimation() {
		Thread animationThread = new Thread(this);
		animationThread.start();
	}

	@Override
	public void run() {
		while (running) {
			this.panel.repaint();

			this.cyclecounter++;

			if (this.cyclecounter >= this.animationSpeed / 40) {
				this.alternateColors = !this.alternateColors;
				this.cyclecounter = 0;
			}
			try {
				Thread.sleep(animationSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopAnimation() {
		running = false;
	}

	public void drawBackground(Graphics2D g2d) {
		switch (currentPattern) {
		case "Gradiente":
			animateGradient(g2d);
			break;
		case "Transição de Cores":
			animateColorTransition(g2d);
			break;
		case "Padrão Geométrico":
			drawGeometricPattern(g2d);
			break;
		case "Linhas Aleatórias":
			drawRandomLines(g2d);
			break;
		case "Cor Sólida":
			drawSolidColor(g2d);
			break;
		}
	}

	private void animateGradient(Graphics2D g2d) {
		GradientPaint gradient = new GradientPaint(0, 0, staticColor1, panel.getWidth(), panel.getHeight(),
				staticColor2);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());

		hue += 0.01f;
		if (hue > 1) {
			hue = 0;
		}
	}

	private void animateColorTransition(Graphics2D g2d) {
		Color color = Color.getHSBColor(hue, 1f, 1f);
		g2d.setColor(color);
		g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());

		hue += 0.01f;
		if (hue > 1) {
			hue = 0;
		}
	}

	private void drawGeometricPattern(Graphics2D g2d) {
		int squareSize = 100;
		for (int y = 0; y < panel.getHeight(); y += squareSize) {
			for (int x = 0; x < panel.getWidth(); x += squareSize) {
				if ((x / squareSize + y / squareSize) % 2 == 0) {
					g2d.setColor(alternateColors ? staticColor1 : staticColor2);
				} else {
					g2d.setColor(alternateColors ? staticColor2 : staticColor1);
				}
				g2d.fillRect(x, y, squareSize, squareSize);
			}
		}
	}

	private void drawRandomLines(Graphics2D g2d) {
		g2d.setColor(staticColor1);
		for (int i = 0; i < 100; i++) {
			int x1 = random.nextInt(panel.getWidth());
			int y1 = random.nextInt(panel.getHeight());
			int x2 = random.nextInt(panel.getWidth());
			int y2 = random.nextInt(panel.getHeight());
			g2d.drawLine(x1, y1, x2, y2);
		}
	}

	private void drawSolidColor(Graphics2D g2d) {
		g2d.setColor(staticColor1);
		g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());
	}

	public String getAnimationSpeedString() {
		return animationSpeedString;
	}

	public void setAnimationSpeedString(String animationSpeedString) {
		this.animationSpeedString = animationSpeedString;
	}
}
