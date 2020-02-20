

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;


public class StartScreen2 extends JFrame {

    private JButton playButtton;
    Color color;
    JFrame c;

    public StartScreen2() {

        playButtton = new JButton("Play");
        playButtton.setFont(new Font( "Arial", Font.BOLD, 50));
        playButtton.setBackground(Color.red);

        color = new Color(255,228,181);

        c = new JFrame();
        c.setLayout(null);
        playButtton.setBounds(380,300,200,75);
        c.getContentPane().setBackground( Color.black);
        
        c.add (playButtton);

        ButtonHandler handler = new ButtonHandler();    //creation of a new Object
        playButtton.addActionListener(handler);      // Attach/register handler to playButtton

        JLabel tetrisLOGO = new JLabel(new ImageIcon("tetris-logo.png"));
        tetrisLOGO.setBounds(280, 5, 400, 300); // x, y, width, height
        c.add(tetrisLOGO);
        
        JLabel prepareToDIE = new JLabel(new ImageIcon("prepare-to-yeet.jpg"));
        prepareToDIE.setBounds(330, 220, 275, 50); // x, y, width, height
        c.add(prepareToDIE);
        
      
        c.setSize(960, 540);
        c.setVisible(true);
    }
    
    // inner class for button event handling
    public class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playButtton) {
                Tetris.commence();
                c.setVisible(false);
            }
            /*if (e.getSource() == mySecondButton) {
                System.out.println(
                            "Right Button has been pressed.");
            }*/
        }
    } 
    
    
} // end of outer class