package Projeto1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpMouseListener implements ActionListener {

	private JFrame frame;

	public HelpMouseListener(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		createHelpDialog();
	}

	private void createHelpDialog() {
		JPanel contentPanel = new ImagePanel();
		JDialog helpDialog = new JDialog(frame, "Ajuda", true);
		helpDialog.setSize(((ImagePanel) contentPanel).getImage().getWidth(),
				((ImagePanel) contentPanel).getImage().getHeight() + 250);
		helpDialog.setLayout(new BorderLayout());
		JTextArea helpText = new JTextArea();
		helpText.setText("Esta é a seção de help da aplicação.\n\n"
				+ "Aqui você pode encontrar informações úteis about como usar a aplicação.\n"
				+ "Siga as instruções abaixo:\n" + "1. Clique nos menus para acessar as funções.\n"
				+ "2. Use o botão 'Sobre' para ver informações da aplicação.\n"
				+ "3. Clique em 'Ok' para fechar este diálogo.\n\n"
				+ "Para mais informações,  mande e-mail para j245708@dac.unicamp.br.");
		helpText.setLineWrap(true);
		helpText.setWrapStyleWord(true);
		helpText.setEditable(false);

		JScrollPane textScroll = new JScrollPane(helpText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
