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

/**
 *
 * @author anoosha
 */
public class Game extends JComponent {

    // Height and Width of our game
    static final int WIDTH = 500;
    static final int HEIGHT = 900;
    //Title of the window
    String title = "My Game";
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;
    // YOUR GAME VARIABLES WOULD GO HERE
    //creating the player 
    
    Rectangle player = new Rectangle(250, 890, 40, 100);
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
    // GAME VARIABLES END HERE   
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Game() {
        // using the arraylist variable created to make the position of the coins that need to be collected by the object
//        coins = new ArrayList<>();
        
       
        
        
//        coins.add(new Rectangle(30, 10, 30, 20));
//        coins.add(new Rectangle(100, 10, 30, 20));
//        coins.add(new Rectangle(210, 100, 30, 20));
//        coins.add(new Rectangle(225, 250, 30, 20));
//        coins.add(new Rectangle(290, 300, 30, 20));
//        coins.add(new Rectangle(350, 90, 30, 20));
//        coins.add(new Rectangle(300, 50, 30, 20));
//        coins.add(new Rectangle(190, 175, 30, 20));
//        coins.add(new Rectangle(10, 350, 30, 20));
//        coins.add(new Rectangle(125, 410, 30, 20));
//        coins.add(new Rectangle(50, 50, 30, 20));
//        coins.add(new Rectangle(80, 210, 30, 20));

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
        //create a new player 
        //drawing a ball
        g.drawRect(ball.x, ball.y, ball.width, ball.height);

       
        g.drawRect(player.x, player.y, player.width, player.height);

        // GAME DRAWING GOES HERE
         // using the arraylist variable created to make the position of the coins that need to be collected by the object
//        coins = new ArrayList<>();
         
        g.setColor(Color.YELLOW);
        g.drawRect(30,10,30,20);
        g.drawRect(100,10,30,20);
        g.drawRect(210,100, 30,20);
        g.drawRect(225, 250, 30, 20);
        g.drawRect(290,300,30,20);
        g.drawRect(350, 90,30, 20);
        g.drawRect(300, 50, 30, 20);
        g.drawRect(190, 175, 30, 20);
        g.drawRect(190, 175, 30, 20);
        g.drawRect(10, 350, 30, 20);
        g.drawRect(125, 410, 30, 20);
        g.drawRect(50, 50, 30, 20);
        g.drawRect(80, 210, 30, 20);
       
        
        
//        coins.add(new Rectangle(30, 10, 30, 20));
//        coins.add(new Rectangle(100, 10, 30, 20));
//        coins.add(new Rectangle(210, 100, 30, 20));
//        coins.add(new Rectangle(225, 250, 30, 20));
//        coins.add(new Rectangle(290, 300, 30, 20));
//        coins.add(new Rectangle(350, 90, 30, 20));
//        coins.add(new Rectangle(300, 50, 30, 20));
//        coins.add(new Rectangle(190, 175, 30, 20));
//        coins.add(new Rectangle(10, 350, 30, 20));
//        coins.add(new Rectangle(125, 410, 30, 20));
//        coins.add(new Rectangle(50, 50, 30, 20));
//        coins.add(new Rectangle(80, 210, 30, 20));
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
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        Game game = new Game();

        // starts the game loop
        game.run();
    }
}
