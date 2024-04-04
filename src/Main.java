import javax.swing.*;
import java.awt.*;

public class Main {
    private static UI ui;
    public static void main(String[] args) {



        int turn = 0;

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame("The worlds worst 4 connect:");

        ui = new UI();

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 750);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(ui.getMainPanel());
        mainFrame.setVisible(true);


    }

    public static void buttonPress(int player,int[][] grid,int column) {
        boolean valid = true;
        int[] panelxy = {-1,-1};

        if (grid[0][column] == -1) {
            grid[0][column] = player;
            panelxy[0] = column;
            panelxy[1] = 0;
        } else if (grid[1][column] == -1) {
            grid[1][column] = player;
            panelxy[0] = column;
            panelxy[1] = 1;
        } else if (grid[2][column] == -1) {
            grid[2][column] = player;
            panelxy[0] = column;
            panelxy[1] = 2;
        } else if (grid[3][column] == -1) {
            grid[3][column] = player;
            panelxy[0] = column;
            panelxy[1] = 3;
        } else if (grid[4][column] == -1) {
            grid[4][column] = player;
            panelxy[0] = column;
            panelxy[1] = 4;
        } else if (grid[5][column] == -1) {
            grid[5][column] = player;
            panelxy[0] = column;
            panelxy[1] = 5;
        } else {
            JOptionPane.showMessageDialog(null,"no.");
            valid = false;
        }

        if (valid) {
            switch(player) {
                case 0:
                    ui.setPanelColor(Color.RED,panelxy);
                    player = 1;
                    break;
                case 1:
                    ui.setPanelColor(Color.YELLOW,panelxy);
                    player = 0;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Shit is broken. Exit Code: 69");
                    System.exit(69);
            }
            ui.transfer(grid,player);
        }

    }
}
