
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class Game extends JPanel implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Dimension panelSize = new Dimension(1200, 800);
	
	private int fps = 30;
	
	private int keyPress = 0;
	// keypress booleans
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean upPressed = false;
	private boolean downPressed = false;
	// 0 = horizontal 1 = vertical
	private int motionType = 0;
	
	private String[] sprites = new String[] {"R-F1", "R-F2", "L-F1", "L-f2"};
	private String[] spriteDefns = new String[] {"src/R-F1.png", "src/R-F2.png", "src/L-F1.png", "src/L-f2.png"};
	private Character Player = new Character(100, 100, sprites, spriteDefns);
	
	public Game() {
        addKeyListener(this);
        
		// game thread
		Thread gameThread = new Thread() {
			public void run() {
		        // variable to store how many milliseconds between frames
		        int previousTime = (int) System.currentTimeMillis();
		        int currentTime;
		        System.out.println(Game.HEIGHT);
				while (true) {
					currentTime = (int) System.currentTimeMillis();
					
					// run every frame
					if ((currentTime - previousTime) >= (1000 / fps)) {
				        previousTime = (int) System.currentTimeMillis();
				        
				        int moveX = 0;
				        int moveY = 0;
				        int motionSpeed = 5;
				        
				        if (rightPressed && motionType == 0) {moveX+=motionSpeed;}
				        if (leftPressed && motionType == 0) {moveX-=motionSpeed;} 
				        if (upPressed && motionType == 1) {moveY-=motionSpeed;}
				        if (downPressed && motionType == 1) {moveY+=motionSpeed;}
				        Player.move(moveX, moveY);
					}

					// Refresh the display
		            repaint(); // Callback paintComponent()
				}
			}
		};
	    gameThread.start();  // Callback run()
	}
	
	public void addNotify() {
        super.addNotify();
        requestFocus();
    }
	
	
	
	// function to redraw the board
    public void paintComponent(Graphics Draw2D) {
        super.paintComponent(Draw2D);
        drawBG(Draw2D);
        Player.draw(Draw2D);
    }
    
    // keyListener events
    public void keyPressed(KeyEvent KeyEvent) {
        keyPress = KeyEvent.getKeyCode();
        if ((keyPress == KeyEvent.VK_UP)||(keyPress == KeyEvent.VK_W)) {upPressed = true; motionType = 1;}
        if ((keyPress == KeyEvent.VK_LEFT)||(keyPress == KeyEvent.VK_A)) {leftPressed = true; motionType = 0;}
        if ((keyPress == KeyEvent.VK_DOWN)||(keyPress == KeyEvent.VK_S)) {downPressed = true; motionType = 1;}
        if ((keyPress == KeyEvent.VK_RIGHT)||(keyPress == KeyEvent.VK_D)) {rightPressed = true; motionType = 0;}
    }
    public void keyReleased(KeyEvent KeyEvent) {
        keyPress = KeyEvent.getKeyCode();
        System.out.println(keyPress + " pressed");
        if ((keyPress == KeyEvent.VK_UP)||(keyPress == KeyEvent.VK_W)) {upPressed = false; motionType = 0;}
        if ((keyPress == KeyEvent.VK_LEFT)||(keyPress == KeyEvent.VK_A)) {leftPressed = false; motionType = 1;}
        if ((keyPress == KeyEvent.VK_DOWN)||(keyPress == KeyEvent.VK_S)) {downPressed = false; motionType = 0;}
        if ((keyPress == KeyEvent.VK_RIGHT)||(keyPress == KeyEvent.VK_D)) {rightPressed = false; motionType = 1;}
        repaint();
    }
    public void keyTyped(KeyEvent e) {
    }
    
    // function to draw the white background and grid
	private void drawBG(Graphics Draw2D) {
		// create the Graphics2D object
		Graphics2D draw = (Graphics2D) Draw2D;
		RenderingHints renderingHints
        = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
		draw.setRenderingHints(renderingHints);
		
		// draw background
		Rectangle2D bg = new Rectangle2D.Double(0, 0, 20, 20);
        draw.setColor(Color.red);
        draw.fill(bg);
    }
}

