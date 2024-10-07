package Projeto1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {
	public ExitListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
}

