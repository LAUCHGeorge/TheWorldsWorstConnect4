import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {
    private static UI ui;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("[ERROR] Exception occurred: "+e.getMessage());
        }

        JFrame mainFrame = new JFrame("The world's worst connect 4");

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
        int diagonalRow = 0;
        int indexX = 0;
        int indexY = 0;
        int spots = 0;

        for(int i = 0; i<=41; i++) {

            int debugIX = indexX;
            int debugIY = indexY;

            if (grid[indexY][indexX] == player) {spots++;}
            else {spots = 0;}
            if (spots >= 4) {return true;}
            if (indexX == 6) {indexY++; indexX = 0; spots = 0;}
            else {indexX++;}

            System.out.println("[HORIZONTAL] S: "+spots+" | X: "+debugIX+" | Y: "+debugIY);
        }

        indexX = 0;
        indexY = 0;
        spots = 0;

        for(int i = 0; i<=41; i++) {

            int debugIX = indexX;
            int debugIY = indexY;

            if (grid[indexY][indexX] == player) {spots++;}
            else {spots = 0;}
            if (spots >= 4) {return true;}
            if (indexY == 5) {indexX++; indexY = 0; spots = 0;}
            else {indexY++;}

            System.out.println("[VERTICAL] S: "+spots+" | X: "+debugIX+" | Y: "+debugIY);
        }

        indexX = 0;
        indexY = 3;
        spots = 0;
        boolean continueLoop = true;

        for (int y = 0; y < 6; y++) {

            for (int x = 0; x < 7; x++) {
                System.out.print("  " + grid[y][x] + "  ");
            }

            System.out.println("");

        }

        while(continueLoop) {

            int debugIX = indexX;
            int debugIY = indexY;

            if (grid[indexY][indexX] == player) {spots++;}
            else {spots = 0;}
            if (spots >= 4) {return true;}
            switch(diagonalRow) {
                case 0:
                    if (indexY == 0) {indexX = 0; indexY = 4; diagonalRow++; spots = 0;}
                    else {indexY--; indexX++;}
                    break;
                case 1:
                    if (indexY == 0) {indexX = 0; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX++;}
                    break;
                case 2:
                    if (indexY == 0) {indexX = 1; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX++;}
                    break;
                case 3:
                    if (indexY == 0) {indexX = 2; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX++;}
                    break;
                case 4:
                    if (indexY == 1) {indexX = 3; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX++;}
                    break;
                case 5:
                    if (indexY == 2) {continueLoop = false; spots = 0; diagonalRow = 0;}
                    else {indexY--; indexX++;}
                    break;
            }
            System.out.println("[DIAGONAL 1] [ROW "+diagonalRow+"] S: "+spots+" | X: "+indexX+" | Y: "+indexY);
        }

        indexX = 6;
        indexY = 3;

        continueLoop = true;

        while(continueLoop) {

            int debugIX = indexX;
            int debugIY = indexY;
;
            if (grid[indexY][indexX] == player) {spots++;}
            else {spots = 0;}
            if (spots >= 4) {return true;}
            switch(diagonalRow) {
                case 0:
                    if (indexY == 0) {indexX = 6; indexY = 4; diagonalRow++; spots = 0;}
                    else {indexY--; indexX--;}
                    break;
                case 1:
                    if (indexY == 0) {indexX = 6; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX--;}
                    break;
                case 2:
                    if (indexY == 0) {indexX = 5; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX--;}
                    break;
                case 3:
                    if (indexY == 0) {indexX = 4; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX--;}
                    break;
                case 4:
                    if (indexY == 1) {indexX = 3; indexY = 5; diagonalRow++; spots = 0;}
                    else {indexY--; indexX--;}
                    break;
                case 5:
                    if (indexY == 2) {continueLoop = false; spots = 0;}
                    else {indexY--; indexX--;}
                    break;
            }
            System.out.println("[DIAGONAL 2] [ROW "+diagonalRow+"] S: "+spots+" | X: "+indexX+" | Y: "+indexY);
        }

        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println();
        return false;
    }

}