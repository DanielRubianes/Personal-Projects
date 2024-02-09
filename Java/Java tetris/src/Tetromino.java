import java.awt.Graphics;

public class Tetromino implements SRS {
	
	// Constructor
	public Tetromino(double X, double Y, int tetrominoType, int rotation) {
		type = tetrominoType;
		boardX = X;
		boardY = Y;
		rotationState = rotation;
		blocks = new Block[4];
		updateBlocks();
	}
	
	// instance variables
	private int type;
	private double boardX;
	private double boardY;
	private int rotationState;
	private Block[] blocks;
	
	// Accessors
	public int getType() {return type;}
	public double getBoardX() {return boardX;}
	public double getBoardY() {return boardY;}
	public int getRotation() {return rotationState;}
	public Block[] getBlocks() {return blocks;}
	
	// Mutators
	public void setType(int tetrominoType) {
		type = tetrominoType;
		updateBlocks();
	}
	public void setBoardX(double X) {boardX = X;}
	public void setBoardY(double Y) {boardY = Y;}
	public void setRotation(int rotation) {rotationState = rotation;}
	public void placeAt(double X, double Y) {
		boardX = X;
		boardY = Y;
	}
	public void updateBlocks() {SRS.updateBlocks(boardX, boardY, rotationState, type, blocks);}
	
	// Other
	
	// creates and returns a copy of the given tetromino
	public Tetromino copy() {
		Tetromino copy = new Tetromino(boardX, boardY, type, rotationState);
		copy.updateBlocks();
		return copy;
	}
	
	// passes the SRS testMove method but with relative X & Y
	public boolean testMove(TetrisBoard board, int Xamount, int Yamount) {
		return SRS.testMove(this, board, (boardX + Xamount), (boardY + Yamount));
	}
	
	// rotates the tetromino clockwise
	public void rotate() {
		if (rotationState > 0) {rotationState--;}
		else {rotationState = 3;}
		updateBlocks();
	}
	
	// move the tetromino the relative X & Y amount
	public void move(int X, int Y) {
		boardX += X;
		boardY += Y;
		updateBlocks();
	}
	
	// places the tetromino on top of the board based on its type (I & O tetrominoes have decimal coordinates)
	// applies appropriate coordinates and rotation state
	public void resetPos() {
		boardY = -2;
		// I & O tetrominoes
		if ((type == 0) || (type == 3)) {
			boardX = 4.5;
			rotationState = 0;
		}
		// J tetromino
		else if (type == 1) {
			boardX = 4;
			rotationState = 1;
		}
		// L tetromino
		else if (type == 2) {
			boardX = 4;
			rotationState = 3;
		}
		else {
			boardX = 4;
			rotationState = 0;
		}
	}
	
	// gives the tetromino a random type
	public void randomType() {
		type = (int)(Math.random()*((6-0)+1))+0;
		updateBlocks();
	}
	
	// toString method
	public String toString() {
		String string = "";
		String blocksString = "";
		for (int index = 0; index < blocks.length; index++) {
			blocksString += blocks[index];
		}
		string += "----Tetromino----\n"
				+ "Type: " + type + "\n"
				+ "X: " + boardX + "\n"
				+ "Y: " + boardY + "\n"
				+ "rotationState: " + rotationState + "\n"
				+ "Blocks:\n" + blocksString + "\n";
		return string;
	}
	
	// draws all of the tetromino's blocks
	public void draw(Graphics Draw2D) {
		for (int index = 0; index < blocks.length; index++) {
			updateBlocks();
			blocks[index].draw(Draw2D);
		}
	}
}
