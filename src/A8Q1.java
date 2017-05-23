
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author niralikantaria
 */
public class A8Q1 extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;


    // GAME VARIABLES WOULD GO HERE
    
    //tan colour is created 
    Color tan = new Color(224, 178, 143);
    //colors created for the background 
    Color blue1 = new Color(114, 157, 249);  
    Color red1 = new Color(239, 98, 117);
    Color green1 = new Color(121, 247, 125);
    Color pink1 = new Color(252, 141, 222);
    Color yellow1 = new Color(252, 248, 138);
    Color teal1 = new Color(138, 252, 219);
    //the ears are moved 
    int Ear = 130;
    int EarDirection = 1;
    
    //int variable created to move the eyes up and down
    int eyes = 300;
    int eyesDirection = 1;
    
    //int variable created to move the nose up and down 
    int nose = 368;
    int noseDirection = 1;
    
    //int variable to move the black line up and down
    int line = 50;
    int lineDirection= 1;
    // GAME VARIABLES END HERE   

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        //randomly change the background color very fast
         Random rand = new Random();
         // two colors are choosen 
         int sieze = rand.nextInt(6) + 1;
         //the five different colors
         switch (sieze) {         
            case 1:
                g.setColor(red1);
                break;
            case 2:
                g.setColor(blue1);
                break;
            case 3:
                g.setColor(green1);
                break;
            case 4:
                g.setColor(pink1);
                break;    
            case 5:
                g.setColor(yellow1);
                break;    
            case 6:
                g.setColor(teal1);
                break;
            default:
                break;
        }
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE
        //set the line color as black
        g.setColor(Color.BLACK);
        //18 lines created in the background
        g.fillRect(0, line - 50, 800, 5);
        g.fillRect(0, line, 800, 5);
        g.fillRect(0, line +50, 800, 5);
        g.fillRect(0, line +100, 800, 5);
        g.fillRect(0, line +150, 800, 5);
        g.fillRect(0, line +200, 800, 5);
        g.fillRect(0, line +250, 800, 5);
        g.fillRect(0, line +300, 800, 5);
        g.fillRect(0, line +350, 800, 5);
        g.fillRect(0, line +400, 800, 5);
        g.fillRect(0, line +450, 800, 5);
        g.fillRect(0, line +500, 800, 5);
        g.fillRect(0, line +550, 800, 5);
        g.fillRect(0, line +600, 800, 5);
        g.fillRect(0, line +650, 800, 5);
        g.fillRect(0, line +700, 800, 5);
        g.fillRect(0, line +750, 800, 5);
        g.fillRect(0, line +800, 800, 5);
        
        //base of the mickey mouse face 
        //face drawing
        g.setColor(Color.BLACK);
        g.fillOval(200, 150, 400, 400);
        //right ear
        g.fillOval(Ear + 337, 55, 200, 200);
        //left ear 
        g.fillOval(Ear, 55, 200, 200);
        
        //face drawing
        g.setColor(tan);
        //right side of the face
        g.fillOval(352, 167, 215, 368);
        //left side of the face 
        g.fillOval(242, 167, 215, 368);
        //bottom part of the face 
        g.fillOval(200, 308, 412, 233);
        //mouth base 
        g.fillOval(307, 465, 198, 101);
        
        //eyes drawing 
        //right eye 
        g.setColor(Color.WHITE);
        g.fillOval(425, 240, 50, 140);    
        g.setColor(Color.BLACK);
        g.drawOval(425, 240, 50, 140);
        //left eye 
        g.setColor(Color.WHITE);
        g.fillOval(350, 240, 50, 140);
        g.setColor(Color.BLACK);
        g.drawOval(350, 240, 50, 140);
        //inner eye 
        //right eye 
        g.fillOval(432, eyes, 35, 80);
        //left eye
        g.fillOval(358, eyes, 35, 80);
        //draw an arch that cuts off the eye
        g.drawArc(343, 359, 140, 70, 0, 180);
        g.setColor(tan);
        g.fillArc(343, 359, 140, 70, 0, 180);
        
        //draw nose 
        g.setColor(Color.BLACK);
        g.fillOval(354, nose, 120, 65);
        
        //draw mouth (arch)
        //arch of the smile
        g.drawArc(267, 345, 290, 140, 180, 180);
        //arch of the left dimple
        g.drawArc(254, 415, 30, 20, 10, 180);
        //arch of the right dimple
        g.drawArc(540, 415, 30, 20, 0, 170); 
        //arch of the mouth
        g.drawArc(307, 390, 200, 150, 180, 178);      
        // GAME DRAWING ENDS HERE
    }


    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void  preSetup(){
       // Any of your pre setup before the loop starts should go here

    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;

        preSetup();

        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            //moving the ears 
            if(Ear >= 150) {
               EarDirection = -1; 
            }
            if(Ear <= 150 ){
               EarDirection = 1;
            }
            Ear = Ear + EarDirection*15;
            
            //moving the eyes 
            if(eyes >= 300) {
                eyesDirection = -1;
            }            
            if(eyes <= 237) {
                eyesDirection = 1;
            }
            eyes = eyes + eyesDirection*10;
            
            //move the nose 
            if(nose >= 368) {
                noseDirection = -1;
            }
            if(nose <= 360) {
                noseDirection = 1;
            }
            nose = nose + noseDirection*5;
            
            //move the black line up and down in the background
            if(line >=600) {
                lineDirection = -1;
            }
            if(line <=10) {
                lineDirection = 1;
            }
            line = line + lineDirection*20;
            
            // GAME LOGIC ENDS HERE 
            // update the drawing (calls paintComponent)
            repaint();

            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try {
                if (deltaTime > desiredTime) {
                    //took too much time, don't wait
                    Thread.sleep(1);
                } else {
                    // sleep to make up the extra time
                    Thread.sleep(desiredTime - deltaTime);
                }
            } catch (Exception e) {
            };
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");

        // creates an instance of my game
        A8Q1 game = new A8Q1();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(game);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        game.addMouseListener(new Mouse());
        
        // starts the game loop
        game.run();
    }

    // Used to implement any of the Mouse Actions
    private static class Mouse extends MouseAdapter {
        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e){
            
        }
        
        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e){
            
        }
        
        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e){
            
        }
    }
    
    // Used to implements any of the Keyboard Actions
    private static class Keyboard extends KeyAdapter{
        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e){
            
        }
        
        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e){
            
        }
    }
}
