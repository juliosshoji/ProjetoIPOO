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
        // Cria um JFileChooser para selecionar arquivos
        JFileChooser chooser = new JFileChooser();
        // Define um filtro para que apenas arquivos .txt sejam selecionados
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Selecione apenas arquivos txt", "txt");
        chooser.setFileFilter(filter);

        // Exibe a caixa de diálogo de escolha de arquivo
        int retorno = chooser.showOpenDialog(frame);

        // Verifica se o usuário escolheu um arquivo
        if (retorno == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                StringBuilder fileContent = new StringBuilder();

                // Limpa o conteúdo atual da JTextArea
                textArea.setText("");

                // Lê o conteúdo do arquivo e adiciona ao JTextArea
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                // Define o texto do JTextArea com o conteúdo do arquivo
                textArea.setText(fileContent.toString());
            } catch (IOException ex) {
                // Exibe uma mensagem de erro se houver um problema ao ler o arquivo
                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo: " + ex.getMessage());
            }
        }
    }
}
