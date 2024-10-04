package Projeto1;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BackgroundAnimator {

    private JPanel panel;
    private Timer animationTimer;
    private int animationSpeed = 50; // Velocidade da animação
    private float hue = 0f; // Cor inicial do gradiente
    private String currentPattern = "Gradiente"; // Padrão de animação atual
    private Color staticColor1 = Color.WHITE; // Cor sólida 1
    private Color staticColor2 = Color.WHITE; // Cor sólida 2 (usada em gradientes e transições)

    public BackgroundAnimator(JPanel panel) {
        this.panel = panel;
        startBackgroundAnimation();
    }
    
    public JPanel getPanel() {
    	return this.panel;
    }

    // Configurar o padrão de animação
    public void setPattern(String pattern) {
        currentPattern = pattern;
        panel.repaint(); // Atualizar o painel imediatamente após mudança
    }

    // Configurar a velocidade da animação
    public void setSpeed(int speed) {
        animationSpeed = speed;
        startBackgroundAnimation(); // Reiniciar a animação com a nova velocidade
    }

    // Configurar a cor inicial do gradiente
    public void setInitialHue(float hue) {
        this.hue = hue;
        panel.repaint();
    }

    // Configurar as cores sólidas (usadas em gradientes e padrão de cor estática)
    public void setStaticColors(Color color1, Color color2) {
        this.staticColor1 = color1;
        this.staticColor2 = color2;
        panel.repaint();
    }

    // Iniciar a animação de fundo
    public void startBackgroundAnimation() {
        if (animationTimer != null) {
            animationTimer.cancel();
        }

        animationTimer = new Timer();
        animationTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                panel.repaint(); // Atualizar o painel constantemente
            }
        }, 0, animationSpeed);
    }

    // Desenhar o fundo com base no padrão atual
    public void drawBackground(Graphics2D g2d) {
        switch (currentPattern) {
            case "Gradiente":
                animateGradient(g2d);
                break;
            case "Transição de Cores":
                animateColorTransition(g2d);
                break;
            case "Padrão Imagem":
                animateImagePattern(g2d);
                break;
            case "Cor Sólida":
                drawSolidColor(g2d);
                break;
        }
    }

    // Animação: Gradiente de cores dinâmico
    private void animateGradient(Graphics2D g2d) {
        GradientPaint gradient = new GradientPaint(0, 0, staticColor1, panel.getWidth(), panel.getHeight(), staticColor2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        // Atualizar o hue para criar o efeito de animação
        hue += 0.01f;
        if (hue > 1) {
            hue = 0;
        }
    }

    // Animação: Transição suave entre duas cores
    private void animateColorTransition(Graphics2D g2d) {
        Color color = Color.getHSBColor(hue, 1f, 1f);
        g2d.setColor(color);
        g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        // Atualizar o hue para fazer a transição de cor
        hue += 0.01f;
        if (hue > 1) {
            hue = 0;
        }
    }

    // Animação: Usar um padrão de imagem (simulação aqui com cor)
    private void animateImagePattern(Graphics2D g2d) {
        // Carregar uma imagem (substituir o caminho da imagem real)
        Image image = Toolkit.getDefaultToolkit().getImage("image-path.jpg");
        g2d.drawImage(image, 0, 0, panel.getWidth(), panel.getHeight(), panel);
    }

    // Desenhar uma cor sólida como fundo
    private void drawSolidColor(Graphics2D g2d) {
        g2d.setColor(staticColor1);
        g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }
}
