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



import javax.swing.*;
import java.awt.*;


public class MainWindows {
    private JFrame frame;
    private JTextArea textArea;  // Certifique-se de que a JTextArea é inicializada corretamente

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
        addMenuItems(menuArquivo, menuAjuda);

        // Define a barra de menus no frame
        frame.setJMenuBar(menuBar);
    }

    private void addMenuItems(JMenu menuArquivo, JMenu menuAjuda) {
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

    }

    private void createTextArea() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setMargin(new Insets(10, 15, 10, 15));
        textArea.setBackground(Color.WHITE);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(frame.getContentPane().getBackground());
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        textPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        frame.add(textPanel, BorderLayout.CENTER);
    }

    private void createStatusBar() {
        JLabel statusBar = new JLabel("PROJETO 1 - GUI");
        statusBar.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);
    }
}