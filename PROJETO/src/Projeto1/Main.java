package Projeto1;

public class Main {
    public static void main(String[] args) {
        try {
        	MainWindows mainWindows = new MainWindows();
            mainWindows.createAndShowGUI();
        } catch(Exception e) {
        	System.out.println("Exceção disparada: " + e.getStackTrace() + "\n" + e.getLocalizedMessage() + "\n" + e.getMessage());
        }
    }
}
