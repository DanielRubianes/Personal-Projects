import java.awt.BasicStroke;
import java.awt.Color;
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
	
	private Tetromino currentPiece;
	private TetrisBoard board;
	private int fps = 1;
	
	private int pressedKey = 0;
	
	// functions to run for key presses
	private void onUp() {
		currentPiece.rotate();
	}
	private void onLeft() {
		if (currentPiece.testMove(board, -1, 0)) {
		currentPiece.move(-1, 0);
		}
	}
	private void onRight() {
		if (currentPiece.testMove(board, 1, 0)) {
		currentPiece.move(1, 0);
		}
	}
	private void speedUp() {fps = 7;}
	private void slowDown() {fps = 1;}
	
	public Game() {
        addKeyListener(this);
		// game thread
		Thread gameThread = new Thread() {
			public void run() {
		        // variable to store how many milliseconds between frames
		        int previousTime = (int) System.currentTimeMillis();
		        int currentTime;
		        board = new TetrisBoard();
		        currentPiece = new Tetromino(4.5, 0, 0, 0);
		        currentPiece.randomType();
				currentPiece.resetPos();
				while (true) {
					currentTime = (int) System.currentTimeMillis();
					
					if ((currentTime - previousTime) >= (1000 / fps)) {
				        previousTime = (int) System.currentTimeMillis();
				        // normal gravity
				        if (currentPiece.testMove(board, 0,1)) {
				        	currentPiece.move(0, 1);
				        }
				        // place tetromino on board, clear lines, and add a new, random tetromino
				        else {
				        	board.addTetromino(currentPiece);
				        	board.clearLines();
					        currentPiece.randomType();
							currentPiece.resetPos();
				        }
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
        drawGrid(Draw2D);
        board.draw(Draw2D);
        currentPiece.draw(Draw2D);
    }
    
    // keyListener events
    public void keyPressed(KeyEvent e) {
        pressedKey = e.getKeyCode();
        if (pressedKey == 40) {speedUp();} // down key
    }
    public void keyReleased(KeyEvent e) {
        pressedKey = e.getKeyCode();
        //System.out.println(pressedKey + " pressed");
        if (pressedKey == 38) {onUp();}
        if (pressedKey == 37) {onLeft();}
        if (pressedKey == 39) {onRight();}
        if (pressedKey == 40) {slowDown();} // down key
        repaint();
    }
    public void keyTyped(KeyEvent e) {
    }
    
    // function to draw the white background and grid
	private void drawGrid(Graphics Draw2D) {
		
		// create the Graphics2D object
		Graphics2D draw = (Graphics2D) Draw2D;
		RenderingHints renderingHints
        = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
		draw.setRenderingHints(renderingHints);
		
		// draw background
		Rectangle2D bg = new Rectangle2D.Double(0, 0, 415, 847);
        draw.setColor(Color.white);
        draw.fill(bg);
		
        // draw vertical lines
        Line2D vertLine = new Line2D.Double(-1, 0, -1, 827);
        draw.setStroke(new BasicStroke(3));
        draw.setColor(Color.gray);
        for (int curLine = 0; curLine < 11; curLine++) {
        	AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        	at.translate(41*curLine, 0);

            draw.draw(at.createTransformedShape(vertLine));
        }
        
        // draw horizontal lines
        Line2D horizLine = new Line2D.Double(0, -1, 427, -1);
        draw.setStroke(new BasicStroke(3));
        draw.setColor(Color.gray);
        for (int curLine = 0; curLine < 21; curLine++) {
        	AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        	at.translate(0, 41*curLine);

            draw.draw(at.createTransformedShape(horizLine));
        }
    }
}


