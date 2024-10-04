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

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BackgroundAnimator implements Runnable {

    private JPanel panel;
    private int animationSpeed = 50;
    private float hue = 0f; 
    private String currentPattern = "Cor Sólida"; 
    private Color staticColor1 = Color.PINK; 
    private Color staticColor2 = Color.PINK; 
    private boolean running = true; 
    private String animationSpeedString = "Médio";
    
    public BackgroundAnimator(JPanel panel) {
        this.panel = panel;
        startBackgroundAnimation();
    }
    
    public void setAnimationSpeedString(String speed) {
    	this.animationSpeedString = speed;
    }
    
    public String getAnimationSpeedString() {
    	return this.animationSpeedString;
    }
    
    public void setStaticColor1(Color color1) {
    	this.staticColor1 = color1;
    }
    
    public String getCurrentPattern() {
		return this.currentPattern;
    	
    }
    
    public JPanel getPanel() {
		return this.panel;
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
            panel.repaint();

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
            case "Cor Sólida":
                drawSolidColor(g2d);
                break;
        }
    }

    private void animateGradient(Graphics2D g2d) {
        GradientPaint gradient = new GradientPaint(0, 0, staticColor1, panel.getWidth(), panel.getHeight(), staticColor2);
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

    private void drawSolidColor(Graphics2D g2d) {
        g2d.setColor(staticColor1);
        g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }
}