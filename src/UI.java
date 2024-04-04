import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends Main{
    private JPanel mainPanel;
    private JPanel titleContainer;
    private JPanel gameContainer;
    private JPanel selectorPanel;
    private JPanel displayPanel;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel titleLabel;
    private JPanel panel05;
    private JPanel panel00;
    private JPanel panel01;
    private JPanel panel02;
    private JPanel panel03;
    private JPanel panel04;
    private JPanel panel12;
    private JPanel panel15;
    private JPanel panel14;
    private JPanel panel13;
    private JPanel panel21;
    private JPanel panel31;
    private JPanel panel41;
    private JPanel panel51;
    private JPanel panel61;
    private JPanel panel11;
    private JPanel panel22;
    private JPanel panel32;
    private JPanel panel23;
    private JPanel panel24;
    private JPanel panel25;
    private JPanel panel35;
    private JPanel panel34;
    private JPanel panel33;
    private JPanel panel45;
    private JPanel panel44;
    private JPanel panel55;
    private JPanel panel65;
    private JPanel panel64;
    private JPanel panel54;
    private JPanel panel63;
    private JPanel panel53;
    private JPanel panel43;
    private JPanel panel42;
    private JPanel panel52;
    private JPanel panel62;
    private JPanel panel10;
    private JPanel panel20;
    private JPanel panel30;
    private JPanel panel40;
    private JPanel panel50;
    private JPanel panel60;

    private JPanel panel;

    public UI(JPanel panel) {
        this.panel = panel;
    }


    public UI() {

        int test = 0;
        Main main = new Main();
        int[][] grid = {
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1,-1}
        };

        initializeActionListener(grid,button0,0);
        initializeActionListener(grid,button1,1);
        initializeActionListener(grid,button2,2);
        initializeActionListener(grid,button3,3);
        initializeActionListener(grid,button4,4);
        initializeActionListener(grid,button5,5);
        initializeActionListener(grid,button6,6);

    }

    public JPanel getMainPanel(){

        return this.mainPanel;
    }

    private void initializeActionListener(int[][] grid,JButton button,int column) {

        for( ActionListener al : button.getActionListeners() ) {
                button.removeActionListener( al );
        }
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.buttonPress(1,grid,column);
            }
        });
    }

    public void transferGrid(int[][] grid) {
        initializeActionListener(grid,button0,0);
        initializeActionListener(grid,button1,1);
        initializeActionListener(grid,button2,2);
        initializeActionListener(grid,button3,3);
        initializeActionListener(grid,button4,4);
        initializeActionListener(grid,button5,5);
        initializeActionListener(grid,button6,6);
    }
    public void setPanelColor(Color color,int[] panelxy){
        JPanel panel = null;
        switch(panelxy[0]) {
            case 0:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel00;
                        break;
                    case 1:
                        panel = panel01;
                        break;
                    case 2:
                        panel = panel02;
                        break;
                    case 3:
                        panel = panel03;
                        break;
                    case 4:
                        panel = panel04;
                        break;
                    case 5:
                        panel = panel05;
                        break;
                        
                }
                break;
            case 1:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel10;
                        break;
                    case 1:
                        panel = panel11;
                        break;
                    case 2:
                        panel = panel12;
                        break;
                    case 3:
                        panel = panel13;
                        break;
                    case 4:
                        panel = panel14;
                        break;
                    case 5:
                        panel = panel15;
                        break;

                }
                break;
            case 2:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel20;
                        break;
                    case 1:
                        panel = panel21;
                        break;
                    case 2:
                        panel = panel22;
                        break;
                    case 3:
                        panel = panel23;
                        break;
                    case 4:
                        panel = panel24;
                        break;
                    case 5:
                        panel = panel25;
                        break;

                }
                break;
            case 3:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel30;
                        break;
                    case 1:
                        panel = panel31;
                        break;
                    case 2:
                        panel = panel32;
                        break;
                    case 3:
                        panel = panel33;
                        break;
                    case 4:
                        panel = panel34;
                        break;
                    case 5:
                        panel = panel35;
                        break;

                }
                break;
            case 4:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel40;
                        break;
                    case 1:
                        panel = panel41;
                        break;
                    case 2:
                        panel = panel42;
                        break;
                    case 3:
                        panel = panel43;
                        break;
                    case 4:
                        panel = panel44;
                        break;
                    case 5:
                        panel = panel45;
                        break;

                }
                break;
            case 5:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel50;
                        break;
                    case 1:
                        panel = panel51;
                        break;
                    case 2:
                        panel = panel52;
                        break;
                    case 3:
                        panel = panel53;
                        break;
                    case 4:
                        panel = panel54;
                        break;
                    case 5:
                        panel = panel55;
                        break;

                }
                break;
            case 6:
                switch(panelxy[1]) {
                    case 0:
                        panel = panel60;
                        break;
                    case 1:
                        panel = panel61;
                        break;
                    case 2:
                        panel = panel62;
                        break;
                    case 3:
                        panel = panel63;
                        break;
                    case 4:
                        panel = panel64;
                        break;
                    case 5:
                        panel = panel65;
                        break;

                }
                break;    
        }
        
        
        panel.setBackground(color);
    }

}