import java.awt.Graphics;

public class TetrisBoard {
	
	// instance variables
	private Block[][] blocks;
	
	// constructors
	public TetrisBoard() {
		// create the block array
		blocks = new Block[10][20];
		for (int xIndex = 0; xIndex < blocks.length; xIndex++) {
			for (int yIndex = 0; yIndex < blocks[0].length; yIndex++) {
				blocks[xIndex][yIndex] = new Block(xIndex, yIndex);
			}
		}
	}
	
	// draws all of the blocks on the board
	public void draw(Graphics Draw2D) {
		for (int xIndex = 0; xIndex < blocks.length; xIndex++) {
			for (int yIndex = 0; yIndex < blocks[0].length; yIndex++) {
				if (blocks[xIndex][yIndex].getType() != 7) {
					blocks[xIndex][yIndex].draw(Draw2D);
				}
			}
		}
	}
	
	// gets the block array
	public Block[][] getBlocks() {
		return blocks;
	}
	
	// clears lines starting from the bottom and returns number of lines cleared
	public int clearLines() {
		
		
		for (int yIndex = (blocks[0].length - 1); yIndex > 0; yIndex--) {
			boolean fullLine = true;
			boolean moreLines = true;
			while (moreLines) {
				for (int xIndex = 0; xIndex < blocks.length; xIndex++) {
					if ((blocks[xIndex][yIndex].getType() == 7)) {
						fullLine = false;
						moreLines = false;
					}
				}
				if (fullLine) {
					for (int lineIndex = yIndex; lineIndex > 0; lineIndex--) {
						for (int xIndex = 0; xIndex < blocks.length; xIndex++) {
							blocks[xIndex][lineIndex] = blocks[xIndex][lineIndex - 1];
							blocks[xIndex][lineIndex].setBoardY(lineIndex);
						}
					}
				}
			}
		}
		
		return 0;
	}
	
	// gets the block at the specified coordinate
	public Block getBlockAt(int X, int Y) {return blocks[X][Y];}
	
	// adds a block to the block array (if it is within the bounds of the board)
	public void addBlock(Block block) {
		if ((block.getBoardX() < 10) && (block.getBoardX() > -1)
				&& (block.getBoardY() < 20) && (block.getBoardY() > -1)) {
			blocks[block.getBoardX()][block.getBoardY()] = block;
		}
	}
	
	// adds the blocks from a tetromino to the block array 
	public void addTetromino(Tetromino tetromino) {
		Block[] tetrominoBlocks = tetromino.getBlocks();
		for (int index = 0; index < tetrominoBlocks.length; index++) {
			addBlock(tetrominoBlocks[index]);
		}
	}
}
