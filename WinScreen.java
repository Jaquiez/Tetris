import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.*;


public class WinScreen extends JFrame {

    Color color;
    JFrame c;

    public WinScreen() {

        color = new Color(255,228,181);

        c = new JFrame();
        c.setLayout(null);
        c.getContentPane().setBackground( Color.black);


        JLabel tetrisLOGO = new JLabel(new ImageIcon("win.jpeg"));
        tetrisLOGO.setBounds(180, 25, 600, 300); // x, y, width, height
        c.add(tetrisLOGO);


        c.setSize(960, 540);
        c.setVisible(true);
    }

} // end of outer class