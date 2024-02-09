import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Block {
	
	// Populated constructor
	public Block(int X, int Y,int blockType) {
		type = blockType;
		boardX = X;
		boardY = Y;
	}
	
	// Void block constructor
	public Block (int X, int Y) {
		type = 7;
		boardX = X;
		boardY = Y;
	}
	
	// instance variables
	private int type;
	private int boardX;
	private int boardY;
	
	// Accessors
	public int getType() {return type;}
	public int getBoardX() {return boardX;}
	public int getBoardY() {return boardY;}
	
	// Mutators
	public void setType(int blockType) {type = blockType;}
	public void setBoardX(int X) {boardX = X;}
	public void setBoardY(int Y) {boardY = Y;}
	
	// Other
	public String toString() {
		String string = "";
		string += "--Block--\n"
				+ "Type: " + type + "\n"
				+ "X: " + boardX + "\n"
				+ "Y: " + boardY + "\n";
		return string;
	}
	
	// draw function
	public void draw(Graphics Draw2D) {
		
		// don't draw if void
		if (type == 7) {return;}
		
		// create the Graphics2D object
		Graphics2D draw = (Graphics2D) Draw2D;
		RenderingHints renderingHints
        = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_RENDERING,
        RenderingHints.VALUE_RENDER_QUALITY);
		draw.setRenderingHints(renderingHints);
		
		// create the rectangle object
		Rectangle2D block = new Rectangle2D.Double(1, 1, 38, 38);
		// set the color based on the block type
		switch (type) {
			case 0: // I tetromino
		        draw.setColor(new Color(0, 240, 240));
		        break;
			case 1: // J tetromino
		        draw.setColor(new Color(0, 0, 240));
		        break;
			case 2: // L tetromino
		        draw.setColor(new Color(240, 160, 0));
		        break;
			case 3: // O tetromino
		        draw.setColor(new Color(240, 240, 0));
		        break;
			case 4: // S tetromino
		        draw.setColor(new Color(0, 240, 0));
		        break;
			case 5: // T tetromino
		        draw.setColor(new Color(160, 0, 240));
		        break;
			case 6: // Z tetromino
		        draw.setColor(new Color(240, 0, 0));
		        break;
		}
		// move the block to its position defined with boardX & boardY
        AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
    	at.translate(41*boardX, 41*boardY);
    	// draw the block
        draw.fill(at.createTransformedShape(block));
	}
}
