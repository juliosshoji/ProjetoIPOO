package Projeto1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFileListener implements ActionListener {
    private JFrame frame;
    private JTextArea textArea;

    public OpenFileListener(JFrame frame, JTextArea textArea) {
        this.frame = frame;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas arquivos txt", "txt");
        chooser.setFileFilter(filter);

        int retorno = chooser.showOpenDialog(frame);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                StringBuilder fileContent = new StringBuilder();

                textArea.setText("");

                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                textArea.setText(fileContent.toString());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + ex.getMessage());
            }
        }
    }
}
