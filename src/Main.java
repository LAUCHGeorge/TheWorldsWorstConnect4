import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    private static UI ui;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame mainFrame = new JFrame("The worlds worst 4 connect:");

        ui = new UI();

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 750);
        mainFrame.setResizable(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setContentPane(ui.getMainPanel());
        mainFrame.setVisible(true);


    }

    public static void buttonPress(int player, int[][] grid, int column) {
        boolean valid = true;
        boolean win = false;
        int[] panelxy = {-1, -1};
        panelxy[0] = column;


        if (grid[0][column] == -1) {
            grid[0][column] = player;
            panelxy[1] = 0;
        } else if (grid[1][column] == -1) {
            grid[1][column] = player;
            panelxy[1] = 1;
        } else if (grid[2][column] == -1) {
            grid[2][column] = player;
            panelxy[1] = 2;
        } else if (grid[3][column] == -1) {
            grid[3][column] = player;
            panelxy[1] = 3;
        } else if (grid[4][column] == -1) {
            grid[4][column] = player;
            panelxy[1] = 4;
        } else if (grid[5][column] == -1) {
            grid[5][column] = player;
            panelxy[1] = 5;
        } else {
            JOptionPane.showMessageDialog(null, "no.");
            valid = false;
        }

        if (valid) {


            switch (player) {
                case 0:
                    ui.setPanelColor(Color.RED, panelxy);
                    win = checkGrid(grid, win, player);
                    if (win) {
                        JOptionPane.showMessageDialog(null, "Red has won the game. L yellow.");
                        System.exit(4200);
                    }
                    player = 1;
                    break;
                case 1:
                    ui.setPanelColor(Color.YELLOW, panelxy);
                    win = checkGrid(grid,win,player);
                    if (win) {
                        JOptionPane.showMessageDialog(null, "Yellow has won the game. L red.");
                        System.exit(4201);
                    }
                    player = 0;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Shit is broken. Exit Code: 69");
                    System.exit(69);
            }

            ui.transfer(grid, player);
        }

    }



    public static boolean checkGrid(int[][] grid, boolean win,int player) {
        int counter = 0;
        int diagMode = 0;
        int indexX = 0;
        int indexY = 0;
        int spots = 0;

        for(int i = 0; i<=41; i++) {
            if(spots < 4) {
                if (grid[indexY][indexX] == player) {spots++;}
                else {spots = 0;}
                if (counter == 6) {indexY++; indexX = 0; counter = 0; spots = 0;}
                else {counter++; indexX++;}
                System.out.println(spots);
            }
            else {win=true;break;}

        }

        counter = 0;
        indexX = 0;
        indexY = 0;
        spots = 0;

        for(int i = 0; i<=41; i++) {
            if(spots < 4) {
                if (grid[indexY][indexX] == player) {spots++;}
                else {spots = 0;}
                if (counter == 5) {indexX++; indexY = 0; counter = 0; spots = 0;}
                else {counter++; indexY++;}
            }
            else {win=true;break;}
        }

        counter = 0;
        indexX = 0;
        indexY = 0;
        spots = 0;

        for(int i = 0; i<=41; i++) {
            if(spots < 4) {
                System.out.println("IF SPOTS PASSED");
                if (grid[indexY][indexX] == player) {spots++;}
                else {spots = 0;}
                switch(diagMode) {
                    case 0:
                        System.out.println("CASE 0 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 5) {indexX = 1; indexY = 0; counter = 0; diagMode++;}
                        else {counter++; indexY++; indexX++;}
                        break;
                    case 1:
                        System.out.println("CASE 1 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 5) {indexX = 2; indexY = 0; counter = 0; diagMode++;}
                        else {counter++; indexY++; indexX++;}
                        break;
                    case 2:
                        System.out.println("CASE 2 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 4) {indexX = 3; indexY = 0; counter = 0; diagMode++;}
                        else {counter++; indexY++; indexX++;}
                        break;
                    case 3:
                        System.out.println("CASE 3 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 3) {indexX = 4; indexY = 0; counter = 0; diagMode++;}
                        else {counter++; indexY++; indexX++;}
                        break;
                    case 4:
                        System.out.println("CASE 4 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 2) {indexX = 0; indexY = 1; counter = 0; diagMode++;}
                        else {counter++; indexY++; indexX++;}
                        break;
                    case 5:
                        System.out.println("CASE 5 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 3) {indexX = 0; indexY = 2; counter = 0; diagMode++;}
                        else {counter++; indexY++; indexX++;}
                        break;
                    case 6:
                        System.out.println("CASE 6 PASSED");
                        System.out.println(indexX);
                        System.out.println(indexY);
                        if (counter == 2) {indexX = 0; indexY = 0; counter = 0; diagMode = 0;}
                        else {counter++; indexY++; indexX++;}
                        break;
                }
            }
            else {win=true;break;}
            counter = 0;
            indexX = 0;
            indexY = 0;
            spots = 0;

        }


        return win;
    }

}
