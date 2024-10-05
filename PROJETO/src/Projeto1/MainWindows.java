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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainWindows {
	private JFrame frame;
	private JTextArea textArea;
	private JPanel textPanel;
	protected BackgroundAnimator backgroundanimator;


    public void createAndShowGUI() {
        // Cria o frame principal
        frame = new JFrame("SI400 - Programação Orientada a Objetos II");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
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
        JMenu archiveMenu = new JMenu("Arquivo");
        JMenu configurationMenu = new JMenu("Configuração");
        JMenu helpMenu = new JMenu("Ajuda");

        // Adiciona os menus à barra de menus
        menuBar.add(archiveMenu);
        menuBar.add(configurationMenu);
        menuBar.add(helpMenu);

        // Adiciona itens de menu e seus ouvintes
        addMenuItems(archiveMenu, helpMenu, configurationMenu);

        // Define a barra de menus no frame
        frame.setJMenuBar(menuBar);
    }

    private void addMenuItems(JMenu archiveMenu, JMenu helpMenu, JMenu configurationMenu) {
        JMenuItem openArchive = new JMenuItem("Abrir arquivo");
        JMenuItem closeArchive = new JMenuItem("Fechar arquivo");
        JMenuItem exit = new JMenuItem("Sair");

        openArchive.addActionListener(new OpenFileListener(frame, textArea));
        closeArchive.addActionListener(e -> textArea.setText(""));
        exit.addActionListener(new ExitListener(frame));

        archiveMenu.add(openArchive);
        archiveMenu.add(closeArchive);
        archiveMenu.addSeparator();
        archiveMenu.add(exit);

        JMenuItem help = new JMenuItem("Ajuda");
        JMenuItem about = new JMenuItem("Sobre");

        help.addActionListener(e -> createHelpDialog());
        about.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Versão 1.0\nAutores:\nFernanda R. G. Mansano - 257088\nJúlio S. Z. Kobayashi - 245708\nMatheus Cirillo - 171535\nStephani S. Miler - 237152\nVictor C. da Silva - 255821",
                "Sobre", JOptionPane.INFORMATION_MESSAGE));

        helpMenu.add(help);
        helpMenu.add(about);
        
        JMenuItem speedItem = new JMenuItem("Configurar Velocidade");
		JMenuItem colorItem = new JMenuItem("Configurar Cor");
		JMenuItem patternItem = new JMenuItem("Configurar Padrão");

		speedItem.addActionListener(new ConfiguracaoMouseListener(this.backgroundanimator));
		colorItem.addActionListener(new ConfiguracaoMouseListener(this.backgroundanimator));
		patternItem.addActionListener(new ConfiguracaoMouseListener(this.backgroundanimator));

		configurationMenu.add(speedItem);
		configurationMenu.add(colorItem);
		configurationMenu.add(patternItem);
    }

    private void createTextArea() {
    	textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setMargin(new Insets(10, 15, 10, 15));
		textArea.setBackground(Color.WHITE);

		this.backgroundanimator = new BackgroundAnimator(new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;

				backgroundanimator.drawBackground(g2d);
			}
		});

		this.textPanel = this.backgroundanimator.getPanel();

		textPanel.setLayout(new BorderLayout());

		this.backgroundanimator.startBackgroundAnimation();

		textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

		frame.add(textPanel, BorderLayout.CENTER);
    }

    private void createStatusBar() {
        JLabel statusBar = new JLabel("PROJETO 1 - GUI");
        statusBar.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);
    }

    private void createHelpDialog() {     
        JPanel contentPanel = new ImagePanel();
        JDialog helpDialog = new JDialog(frame, "Ajuda", true);
        helpDialog.setSize(((ImagePanel) contentPanel).getImage().getWidth(), ((ImagePanel) contentPanel).getImage().getHeight()+250);
        helpDialog.setLayout(new BorderLayout());
        JTextArea helpText = new JTextArea();
        helpText.setText("Esta é a seção de help da aplicação.\n\n"
               + "Aqui você pode encontrar informações úteis about como usar a aplicação.\n"
               + "Siga as instruções abaixo:\n"
               + "1. Clique nos menus para acessar as funções.\n"
               + "2. Use o botão 'Sobre' para ver informações da aplicação.\n"
               + "3. Clique em 'Ok' para fechar este diálogo.\n\n"
               + "Para mais informações,  mande e-mail para j245708@dac.unicamp.br.");
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setEditable(false);

        JScrollPane textScroll = new JScrollPane(helpText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textScroll.setSize(((ImagePanel) contentPanel).getImage().getWidth(), 250);
        
        
        JPanel buttonPanel = new JPanel();
        JButton okayButton = new JButton("Ok");
        okayButton.addActionListener(e -> helpDialog.dispose());

        buttonPanel.add(okayButton);

        helpDialog.add(contentPanel, BorderLayout.CENTER);
        helpDialog.add(textScroll, BorderLayout.NORTH);
        helpDialog.add(buttonPanel, BorderLayout.SOUTH);

        helpDialog.setLocationRelativeTo(frame);
        helpDialog.setVisible(true);
    }
}
