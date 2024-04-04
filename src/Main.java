import javax.swing.*;
import java.awt.*;

public class Main {
    private static UI ui;
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame("The worlds worst 4 gewinnt");

        ui = new UI();

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 750);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(ui.getMainPanel());
        mainFrame.setVisible(true);
    }
}
