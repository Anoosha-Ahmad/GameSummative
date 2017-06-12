package SummativeGame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import static SummativeGame.Game.WIDTH;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author anoosha
 */
public class Game extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 400;
    static final int HEIGHT = 600;
    //Title of the window
    String title = "My Game";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    
    // YOUR GAME VARIABLES WOULD GO HERE
    

    Rectangle player = new Rectangle(175, 550, 30, 30);
//    Rectangle coins = new Rectangle(WIDTH / 2, HEIGHT / 2, 10, 10);
//    Rectangle bombs = new Rectangle(WIDTH / 2, HEIGHT / 2, 10, 10);
    
     ArrayList <Rectangle> coins= new ArrayList<>();
    
    // create bricks
    ArrayList<Rectangle> bombs = new ArrayList<>();
    
    
    
    //player movement 
    boolean rightPressed;
    boolean leftPressed;
    // creating a variable for the gravity, so that the object is able to move down, when needed
    int gravity = 0;

    // speed
    int velocityx;
    int velocityy;

    // player score 
    int playerScore = 0;
    // score keeper
    Font myFont = new Font("Arial", Font.BOLD, 75);
    // creating the blocks for the 
    // creating a variable for the frame ratte of each pizel in the game (for visual appearance) 
    int frameCount = 0;

    //creating an an array (its variable) of items that need to be collected by the object the users will have control over
//    ArrayList<Rectangle> coins = new ArrayList<>();
//    ArrayList<Rectangle> bombs = new ArrayList<>();
//    
    
   
  
//    ArrayList<Rectangle> coins = new ArrayList<>();
    // GAME VARIABLES END HERE   
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)

    public Game() {
        
    
    
    
        // using the arraylist variable created to make the position of the coins that need to be collected by the object
//        coins = new ArrayList<>();
        
        coins = new ArrayList<>();
        coins.add(new Rectangle(30, 10, 30, 20));
        coins.add(new Rectangle(100, 10, 30, 20));
        coins.add(new Rectangle(30, 10, 30, 20));
        coins.add(new Rectangle(100, 10, 30, 20));
        coins.add(new Rectangle(210, 100, 30, 20));
        coins.add(new Rectangle(225, 250, 30, 20));
        coins.add(new Rectangle(290, 300, 30, 20));
        coins.add(new Rectangle(350, 90, 30, 20));
        coins.add(new Rectangle(300, 50, 30, 20));
        coins.add(new Rectangle(190, 175, 30, 20));
        coins.add(new Rectangle(10, 350, 30, 20));
        coins.add(new Rectangle(125, 410, 30, 20));
        coins.add(new Rectangle(50, 50, 30, 20));
        coins.add(new Rectangle(80, 210, 30, 20));
        
        bombs = new ArrayList<>();
        bombs.add(new Rectangle(75, 50, 40, 20));
        bombs.add(new Rectangle(0, 150, 40, 20));
        bombs.add(new Rectangle(150, 440, 40, 20));
        bombs.add(new Rectangle(250, 0, 40, 20));
        bombs.add(new Rectangle(150, 400, 40, 20));
        bombs.add(new Rectangle(280, 480, 40, 20));
        bombs.add(new Rectangle(350, 250, 40, 20));
        bombs.add(new Rectangle(275, 75, 40, 20));
        bombs.add(new Rectangle(15, 345, 40, 20));
        bombs.add(new Rectangle(350, 300, 40, 20));
        bombs.add(new Rectangle(200, 200, 40, 20));
        bombs.add(new Rectangle(500, 375, 40, 20));
        bombs.add(new Rectangle(50, 500, 40, 20));
        bombs.add(new Rectangle(120, 550, 40, 20));
        bombs.add(new Rectangle(260, 350, 40, 20));
        bombs.add(new Rectangle(15, 260, 40, 20));
        bombs.add(new Rectangle(45, 25, 40, 20));
        bombs.add(new Rectangle(100, 175, 40, 20));
        bombs.add(new Rectangle(160, 90, 40, 20));
        bombs.add(new Rectangle(130, 275, 40, 20));
       
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Game.Keyboard());
        Game.Mouse m = new Game.Mouse();

        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        
        // GAME DRAWING GOES HERE
        
        
    
        g.setColor(Color.YELLOW);
        coins = new ArrayList<>();
        
        g.setColor(Color.BLACK);
        bombs = new ArrayList<>();
        
        // using the arraylist variable created to make the position of the coins that need to be collected by the object
//      
        
        
        g.setColor(Color.PINK);
        g.fillRect(player.x, player.y, player.width, player.height);
        
        
       
            
      
        

        //drawing the coins 
        
    
    g.setColor (Color.WHITE);
        g.setFont(myFont);
        g.drawString("" + playerScore, WIDTH/2, 50);

        // GAME DRAWING ENDS HERE
            }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
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
             //moving the player from left to right
                if (leftPressed) {
                    // the squid will move at the spesd of 3 to the left
                    player.x = player.x - 5;
                } 
                if (rightPressed) {
                    // the squid will move at the speed of to the right
                    player.x = player.x + 3;
                    
                }
                // go through all of rectangles
                    for (Rectangle bombs : bombs) {
                        // making the rectangles to go down
                        bombs.y = bombs.y + 2;
                        if (bombs.y > 600){
                            bombs.y = - 100;
                            
                            // when the squid will collide a rectangle
                        if(player.intersects(bombs)){
                            // if yes the squid is hit
                            done = true;
                        }
                            
                // go through all of diamonds
                    for (Rectangle coins : coins){
                        //making the diamonds to go down
                        coins.y = coins.y + 2;
                        if (coins.y > 600){
                            coins.y = - 100;
                                   
                
                        // when the squid will collide with a diamond it will ad a score
                        if (player.intersects (coins)){
                            playerScore = playerScore + 1 ;
                        }
                    }
                            
                        
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
            
    
    
                    
    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }

        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
             int key = e.getExtendedKeyCode();
        if (key == KeyEvent.VK_LEFT){
            //moving the squid to the left using this left key
            leftPressed = false;
        } 
         // moving the squid to the rigth using the right key
        if (key == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        
    
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){ 
        // creates an instance of my game
        Game game = new Game();

        // starts the game loop
        game.run();
    }
    }
}
