package code;

import javax.swing.*;
import java.awt.*;

public class Driver{


    public static void startGUI(){
        GUI instance = new GUI();

        JFrame frame = new JFrame("Reddit API Wrapper");

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.add(instance.startGUI());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                startGUI();
            }
        });
    }

}
