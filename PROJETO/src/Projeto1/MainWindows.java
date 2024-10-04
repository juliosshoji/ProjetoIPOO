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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainWindows {
	
    private JFrame frame;
    private JTextArea textArea;
    private JPanel textPanel;
    private BackgroundAnimator backgroundanimator;

    public void createAndShowGUI() {
        // Cria o frame principal
        frame = new JFrame("SI400 - Programação Orientada a Objetos II");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Definir a cor de fundo do frame
        frame.getContentPane().setBackground(Color.PINK);

        // Chame createTextArea() antes de configurar os menus para garantir que textArea seja inicializada
        
        createTextArea();
        createMenuBar();
        createStatusBar();
        // Exibe o frame
        frame.setVisible(true);
    }

    private void createMenuBar() {
        // Cria a barra de menus
        JMenuBar menuBar = new JMenuBar();

        // Cria os menus
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenu menuConfiguracao = new JMenu("Configuração");
        JMenu menuAjuda = new JMenu("Ajuda");

        // Adiciona os menus à barra de menus
        menuBar.add(menuArquivo);
        menuBar.add(menuConfiguracao);
        menuBar.add(menuAjuda);

        // Adiciona itens de menu e seus ouvintes
        addMenuItems(menuArquivo, menuAjuda, menuConfiguracao);

        // Define a barra de menus no frame
        frame.setJMenuBar(menuBar);
    }

    private void addMenuItems(JMenu menuArquivo, JMenu menuAjuda, JMenu menuConfiguracao) {
        JMenuItem abrirArquivo = new JMenuItem("Abrir arquivo");
        JMenuItem fecharArquivo = new JMenuItem("Fechar arquivo");
        JMenuItem sair = new JMenuItem("Sair");

        // Certifique-se de que textArea foi inicializada antes de passar para o OpenFileActionListener
        abrirArquivo.addActionListener(new OpenFileListener(frame, textArea));
        fecharArquivo.addActionListener(e -> textArea.setText(""));
        sair.addActionListener(new ExitListener(frame));

        menuArquivo.add(abrirArquivo);
        menuArquivo.add(fecharArquivo);
        menuArquivo.addSeparator();
        menuArquivo.add(sair);
        
        //Adicionando menuConfig Items
    	JMenuItem speedItem = new JMenuItem("Configurar Velocidade");
		JMenuItem colorItem = new JMenuItem("Configurar Cor");
		JMenuItem patternItem = new JMenuItem("Configurar Padrão");
		
		speedItem.addActionListener(new ConfiguracaoMouseListener(this.backgroundanimator));
		colorItem.addActionListener(new ConfiguracaoMouseListener(this.backgroundanimator));
		patternItem.addActionListener(new ConfiguracaoMouseListener(this.backgroundanimator));
		
		menuConfiguracao.add(speedItem);
		menuConfiguracao.add(colorItem);
		menuConfiguracao.add(patternItem);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(10, 15, 10, 15));
        textArea.setBackground(Color.WHITE);

        this.textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(frame.getContentPane().getBackground());
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        this.backgroundanimator = new BackgroundAnimator(this.textPanel);

        
        frame.add(textPanel, BorderLayout.CENTER);
    }

    private void createStatusBar() {
        JLabel statusBar = new JLabel("PROJETO 1 - GUI");
        statusBar.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);
    }
}