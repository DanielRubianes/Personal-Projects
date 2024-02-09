package zeldaGame;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;
	protected String[] sprites;
	protected int sprite = 0;

    public Sprite(int x, int y, String[] sprites) {

        this.x = x;
        this.y = y;
        this.sprites = sprites;
        visible = true;
		/*for (int count = 0; count < spriteList.length; count++) {
			ImageIcon icon = new ImageIcon(spriteLinks[count]);
			Image sprite = icon.getImage();
			System.out.println(spriteLinks[count]);
			this.sprites.add(sprite);
		}*/
    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }    

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}