import java.io.File;
import java.awt.*;
import java.lang.Math;
import java.util.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.event.*;

public class Tetris extends JPanel
{
   
    public static void main(String[] args) {
       //TURN UP YOUR VOLUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
       //TURN UP YOUR VOLUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
       //TURN UP YOUR VOLUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
       //TURN UP YOUR VOLUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
       //TURN UP YOUR VOLUMEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        //StartScreen f = new StartScreen();
        StartScreen2 f = new StartScreen2();
        
        f.addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

             
                    System.exit(0);
                }
            }
        );
}
    
    public static void commence() {
        JFrame yeet = new JFrame("Tetris");
        yeet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        yeet.setSize(12*26+10, 26*23+25);
        yeet.setVisible(true);
 
 
        Tetris game = new Tetris();
        game.init();
        playMusic();
        yeet.add(game);
        
        yeet.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
 
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.rotate(+1);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.moveDown();
                        
                        break;
                    case KeyEvent.VK_LEFT:
                        game.moveSide(-1);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.moveSide(+1);
                        break;
                    case KeyEvent.VK_SPACE:
                        game.moveDown();
                        
                        break;
                }
            }
 
            public void keyReleased(KeyEvent e) {
            }
        });
        new Thread() {   ///Just learned about this Thread thing...the .sleep for Thread pretty much adds a delay before the tetris block moves down
            public void run() {
                while (true) {
                    try {
                            int speed= 1000/wave;
                        Thread.sleep(speed);
                        game.moveDown();
                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();
        
        
        
    }


    private Point[][][] shapes = 
    {
        {
            //I as in Iqbal, the last name of the beast himself
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(3,1)}, //Rotation 1
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(1,3)}, //Rotation 2
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(3,1)}, //Rotation 3
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(1,3)}  //Rotation 4
        },
        {
            //J
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(2,0)}, //Rotation 1
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(2,2)}, //Rotation 2
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(0,2)}, //Rotation 3
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(0,0)}  //Rotation 4
        },
        {
            //L_?
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(2,2)}, //Rotation 1
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(0,2)}, //Rotation 2
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(0,0)}, //Rotation 3
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(2,0)}  //Rotation 4
        },
        {
            //[]
            {new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)}, //Rotation 1
            {new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)}, //Rotation 2
            {new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)}, //Rotation 3
            {new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)}  //Rotation 4
            
            
        },
        {
            //hat
            {new Point(1,0), new Point(0,1), new Point(1,1), new Point(2,1)}, //Rotation 1
            {new Point(1,0), new Point(1,1), new Point(2,1), new Point(1,2)}, //Rotation 2
            {new Point(0,1), new Point(1,1), new Point(2,1), new Point(1,2)},//Rotation 3
            {new Point(1,0), new Point(1,1), new Point(1,2), new Point(0,1)} //Rotation 4
            
        },
        {
            //Z
            
            {new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0)}, //Rotation 1
            {new Point(1,2), new Point(1,1), new Point(0,1), new Point(0,0)},
            {new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0)}, //Rotation 1
            {new Point(1,2), new Point(1,1), new Point(0,1), new Point(0,0)}//Rotation 4
            
        },
        {
            //s
            
            {new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0)}, //Rotation 1
            {new Point(2,2), new Point(2,1), new Point(1,1), new Point(1,0)},
            {new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0)}, //Rotation 1
            {new Point(2,2), new Point(2,1), new Point(1,1), new Point(1,0)}//Rotation 4
            
        }
    };
    private int row = 0;
    private static int wave = 1;
    private Color[] colors = {Color.blue, Color.magenta, Color.orange, Color.yellow, Color.pink, Color.red, Color.green};
    
    private Point pt;
    private int currentPiece;
    private int rotationNumCycle;

    private ArrayList<Integer>nextPieces = new ArrayList<Integer>();
    
    private int score;
    private Color[][] background;
    
    private void init() { /////////BACKGROUND WITH SOME FANCY SCHMANCY COLORS ON THE SIDES (creates an array of colors that represents the background - the if else statement is simply for the stuff on te side))
        background = new Color[12][24];
        for(int a = 0; a < 12; a++) {
            for(int b =0; b < 23; b++) {
                if(a==0 || a==11 || b==22)
                    background[a][b] = Color.cyan;
                else
                    background[a][b] = Color.black;
                }
            }
        generateNewPiece();      
    }
            
    public void generateNewPiece() {
        if(checkLoss()){ lose();}
        pt = new Point(5,2);
        if(nextPieces.size()==0){
            nextPieces.add(0);
            nextPieces.add(1);
            nextPieces.add(2);
            nextPieces.add(3);
            nextPieces.add(4);
            nextPieces.add(5);
            nextPieces.add(6);
        }
        int k = (int)(Math.random()*nextPieces.size());
        currentPiece = nextPieces.get(k);
        nextPieces.remove(k);                               ////Randomizes the process of generating a new piece (straightforward)     
    }
    
    public boolean collided(int x, int y, int rotationNum) { ////If the blocks around the current shape are not of the color black 
        for(Point p: shapes[currentPiece][rotationNum]) {      ////(meaning a border color or a color of another shape), then that shape has 
            if(background[p.x + x][p.y + y]!=Color.black) {    ////collided with either another shape, or is touching the border
                return true;
            }
        }
        return false;                                          ////Will return TRUE if colliding, false if not
    }
    
    public void rotate(int i) {           /////This method cycles through rotations of the current shape as "i", the parameter/value passed, increases
        int newRotation = (rotationNumCycle + i) % 4;
        
        if(newRotation < 0) {
            newRotation = 3;
        }

        if(collided(pt.x, pt.y, newRotation) == false) {
            rotationNumCycle = newRotation;
        }   
        repaint();
    }

    public void moveSide(int i) {  ///The parameter "int i" is used to indicate whether the shape goes left or right in movement (-1, or 1))

        if(collided(pt.x + i, pt.y, rotationNumCycle) == false) {
            pt.x+=i;
        }
        repaint();
    }

    public void moveDown() {  ///Simply pushes the shape down, until it is dropped (set in place)
        
        if(collided(pt.x, pt.y + 1, rotationNumCycle) == false) {
            pt.y++;
        }
        else {
            dropped();
        }
        repaint();
    }

    public void dropped() {
        for(Point p: shapes[currentPiece][rotationNumCycle]) {
            background[pt.x + p.x][pt.y + p.y] = colors[currentPiece];
        }
        clearRow();

        generateNewPiece();
    }

    public void deleteRow(int r) {
        for(int j = r - 1; j > 0; j--) {
            for(int i = 1; i < 11; i++) {
                background[i][j + 1] = background[i][j];
            }
        }
    }

    public void clearRow() {
        boolean gap;
        int numRowToBeCleared = 0;
        
        for(int j = 21; j > 0; j--) {
            gap = false;             
            for(int i = 1; i < 11; i++) {
                if(background[i][j] == Color.black) {
                    gap = true;
                    
                }
            }
            if(!gap) {
                deleteRow(j);
                j++;
                numRowToBeCleared++;
            }
        }
        switch (numRowToBeCleared) {
            case 1: score += 100*wave; row++;  break;
            case 2: score += 300*wave; row+=2; break;
            case 3: score += 500*wave; row+=3; break;
            case 4: score += 800*wave; row+=4; break;
        }
        if(row >= 10)
        {
        wave++;
        row = 1;
        }
        if(wave > 10)
        {
           //YOU WIN!
           setVisible(false);
           chickenDinner();
        }
    }
    
    public void drawShape(Graphics g) { 
        g.setColor(colors[currentPiece]);
        for (Point p : shapes[currentPiece][rotationNumCycle]) {
             g.fillRect( (p.x + pt.x) * 26, (p.y + pt.y) * 26, 25, 25);
        }
    }

    public void paintComponent(Graphics g) {    ///sorta like the paint method of the JFrame ting
        g.fillRect(0, 0, 26*12, 26*23);
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 23; j++) {
                g.setColor(background[i][j]);
                g.fillRect(26*i, 26*j, 25, 25);
            }
        }
        g.setColor(Color.WHITE);
        g.drawString("Score : " + score, 19*12, 25);
        g.drawString ("Wave : " + wave, 19*12, 45);
        g.drawString("Rows : " + row, 19*12, 65);
        drawShape(g);
        
    }
    public boolean checkLoss()
    {
    int counter = 0;
    for(int k = 21; k>0; k--)
    {
    boolean isColor = false;
        for(int j = 0; j<12;j++)
        {
        if(background[j][k] != Color.black && background[j][k] != Color.cyan){isColor = true;}
        }
        if(isColor){counter++;}
    }
    if(counter >= 20){return true;}
    return false;
    }
    public void chickenDinner()
    {
         JFrame frame = new JFrame("YOU WON?????");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ImageIcon ii = new ImageIcon("win.jpg");
         JLabel lable = new JLabel(ii);
         JScrollPane jsp = new JScrollPane(lable);
         frame.getContentPane().add(jsp);
         frame.setSize(1920, 1080);
         frame.setVisible(true);
         try
         {
             Thread.sleep(100000);
         }
         catch(InterruptedException ex)
         {
            Thread.currentThread().interrupt();
         }
         System.exit(0);
    }
    
    public void lose()
    {
         JFrame fram = new JFrame("LOSEERRRRR!!!!!!!");
         fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ImageIcon yote = new ImageIcon("lose.jpg");
         JLabel boat = new JLabel(yote);
         JScrollPane pp = new JScrollPane(boat);
         fram.getContentPane().add(pp);
         fram.setSize(1920, 1080);
         fram.setVisible(true);
         try
         {
             Thread.sleep(3000);
         }
         catch(InterruptedException ex)
         {
            Thread.currentThread().interrupt();
         }
         System.exit(0);
    }
    private static void playMusic() {
      
       File file = new File("soul.wav");
       try
       {
           if(file.exists())
           {
               AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
               Clip clip = AudioSystem.getClip();
               clip.open(audioInput);
               clip.start();
               clip.loop(Clip.LOOP_CONTINUOUSLY);
      
            }
            else
            {
                System.out.println("NOTHING HERE!");
            }
        }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }
 }
}
