package zeldaGame;

import java.awt.event.KeyEvent;

public class Character extends Sprite {

    private int dx;
    private int dy;
    
    private int motionType; // 0 = horiz, 1 = vert
    private int direction = 0; // 0 = right 1 = left
    private int frame = 0;

    public Character(int x, int y, String[] sprites) {
        super(x, y, sprites);
        
        initSprite();
    }

    private void initSprite() {
        loadImage(sprites[sprite]); 
        getImageDimensions();
    }

    private int increment = 0;
    private int limit = 15;
    public void move() {
    	// motion
        if (motionType == 0) {x += dx;}
        else {y += dy;}
        
        // sprite selection
        if (direction == 0) {
        	if (frame == 0) {sprite = 0;}
        	else if (frame == 1) {sprite = 1;}
        }
        else if (direction == 1) {
        	if (frame == 0) {sprite = 2;}
        	else if (frame == 1) {sprite = 3;}
        }
        initSprite();
        
        // increment
        if ((dx != 0) || (dy != 0)) {
	        increment++;
	        if (increment == limit) {
	        	increment = 0;
	        	if (frame == 0) {frame++;}
	        	else {frame--;}
	        }
        }
        else {frame = 0;}
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {}

        if ((key == KeyEvent.VK_LEFT)||(key == KeyEvent.VK_A)) {
            dx = -2;
            motionType = 0;
            direction = 1;
        }

        if ((key == KeyEvent.VK_RIGHT)||(key == KeyEvent.VK_D)) {
            dx = 2;
            motionType = 0;
            direction = 0;
        }

        if ((key == KeyEvent.VK_UP)||(key == KeyEvent.VK_W)) {
            dy = -2;
            motionType = 1;
        }

        if ((key == KeyEvent.VK_DOWN)||(key == KeyEvent.VK_S)) {
            dy = 2;
            motionType = 1;
        }
    }


    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if ((key == KeyEvent.VK_LEFT)||(key == KeyEvent.VK_A)) {
            dx = 0;
            motionType = 1;
        }

        if ((key == KeyEvent.VK_RIGHT)||(key == KeyEvent.VK_D)) {
            dx = 0;
            motionType = 1;
        }

        if ((key == KeyEvent.VK_UP)||(key == KeyEvent.VK_W)) {
            dy = 0;
            motionType = 0;
        }

        if ((key == KeyEvent.VK_DOWN)||(key == KeyEvent.VK_S)) {
            dy = 0;
            motionType = 0;
        }
    }
}