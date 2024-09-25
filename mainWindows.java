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
 * This code illustrates the use of JFrame, JMenu and other graphical components,
 * MouseListener interface
 * *********************************************************************************/

package Projeto1;

import javax.swing.*;
import java.awt.*;

public class mainWindows {
    public static void main(String[] args) {
        // Cria o frame principal
        JFrame frame = new JFrame("SI400 - Programação Orientada a Objetos II ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400); // Define o tamanho da janela
        frame.setLayout(new BorderLayout());

        // Definir a cor de fundo do frame
        frame.getContentPane().setBackground(Color.PINK);

        // Cria a barra de menus
        JMenuBar menuBar = new JMenuBar();

        // Cria os menus
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuConfiguracao = new JMenu("Configuração");
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenu menuSair = new JMenu("Sair");

        // Adiciona os menus à barra de menus
        menuBar.add(menuArquivo);
        menuBar.add(menuConfiguracao);
        menuBar.add(menuAjuda);
        menuBar.add(menuSair);

        // Define a barra de menus no frame
        frame.setJMenuBar(menuBar);

        // Cria uma barra de status
        JLabel statusBar = new JLabel("PROJETO 1 - GUI");
        statusBar.setHorizontalAlignment(SwingConstants.CENTER);

        // Adiciona a barra de status
        frame.add(statusBar, BorderLayout.SOUTH);

        //Chamando os ouvintes de menu para mudar a cor ao passar o mouse sobre os menus
        menuArquivo.addMouseListener(new MenuHoverListener());
        menuConfiguracao.addMouseListener(new MenuHoverListener());
        menuAjuda.addMouseListener(new MenuHoverListener());
        menuSair.addMouseListener(new MenuHoverListener());

        //Chama o ouvinte que sai do programa com ação de clique
        menuSair.addMouseListener(new SairMouseListener());

        // Exibe o frame
        frame.setVisible(true);
    }
}

