public interface SRS {
	
	// function to test if it is possible to move the given tetromino to the given coordinate on the board
	public static boolean testMove(Tetromino tetromino, TetrisBoard board, double testX, double testY) {
		// create the theoretical tetromino and store its blocks
		Tetromino theoTetromino = tetromino.copy();
		theoTetromino.placeAt(testX, testY);
		theoTetromino.updateBlocks();
		Block[] theoBlocks = theoTetromino.getBlocks();
		
		// store the blocks from the tetris board
		Block[][] boardBlocks = board.getBlocks();
		
		// test for board boundaries
		for (int index = 0; index < theoBlocks.length; index++) {
			if (theoBlocks[index].getBoardX() < 0) {return false;}
			if (theoBlocks[index].getBoardX() > 9) {return false;}
			if (theoBlocks[index].getBoardY() > 19) {return false;}
		}
		
		// test for conflicts on the tetris board
		for (int index = 0; index < theoBlocks.length; index++) {
			for (int xIndex = 0; xIndex < boardBlocks.length; xIndex++) {
				for (int yIndex = 0; yIndex < boardBlocks[0].length; yIndex++) {
					if (boardBlocks[xIndex][yIndex].getType() != 7) {
						if ((theoBlocks[index].getBoardX() == boardBlocks[xIndex][yIndex].getBoardX())
							&& (theoBlocks[index].getBoardY() == boardBlocks[xIndex][yIndex].getBoardY())) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	public static void updateBlocks(double x, double y, int rotationState, int type, Block[] blocks) {
		switch (type) {
			case 0: // I tetromino
		        for (int index = 0; index <= 3; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative y axis
		        	rotationBoundTranslate(x, y, rotationState, 0, -.5, blocks[index], type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-1.5+index), blocks[index], type);
		        }
		        break;
			case 1: // J tetromino
		        for (int index = 0; index <= 2; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-1+index), blocks[index], type);
		        }
	        	blocks[3] = new Block((int)x, (int)y, type);
	        	// translate on relative y axis
	        	rotationBoundTranslate(x, y, rotationState, 0, -1, blocks[3], type);
	        	// translate on relative x axis
	        	rotationBoundTranslate(x, y, rotationState, 1, -1, blocks[3], type);
		        break;
			case 2: // L tetromino
		        for (int index = 0; index <= 2; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-1+index), blocks[index], type);
		        }
	        	blocks[3] = new Block((int)x, (int)y, type);
	        	// translate on relative y axis
	        	rotationBoundTranslate(x, y, rotationState, 0, -1, blocks[3], type);
	        	// translate on relative x axis
	        	rotationBoundTranslate(x, y, rotationState, 1, 1, blocks[3], type);
		        break;
			case 3: // O tetromino
				for (int index = 0; index <= 3; index++) {
					blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative y axis
		        	rotationBoundTranslate(x, y, index, 0, .5, blocks[index], type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, index, 1, .5, blocks[index], type);
				}
		        break;
			case 4: // S tetromino
				for (int index = 0; index <= 1; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-1+index), blocks[index], type);
		        }
				for (int index = 2; index <= 3; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative y axis
		        	rotationBoundTranslate(x, y, rotationState, 0, -1, blocks[index], type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-2+index), blocks[index], type);
		        }
		        break;
			case 5: // T tetromino
		        for (int index = 0; index <= 2; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-1+index), blocks[index], type);
		        }
	        	blocks[3] = new Block((int)x, (int)y, type);
	        	// translate on relative y axis
	        	rotationBoundTranslate(x, y, rotationState, 0, -1, blocks[3], type);
		        break;
			case 6: // Z tetromino
				for (int index = 0; index <= 1; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (index), blocks[index], type);
		        }
				for (int index = 2; index <= 3; index++) {
		        	blocks[index] = new Block((int)x, (int)y, type);
		        	// translate on relative y axis
		        	rotationBoundTranslate(x, y, rotationState, 0, -1, blocks[index], type);
		        	// translate on relative x axis
		        	rotationBoundTranslate(x, y, rotationState, 1, (-3+index), blocks[index], type);
		        }
		        break;
		}
	}
	
	static void rotationBoundTranslate(double x, double y, int rotationState, int direction, double amount, Block block, int type) {
		// 		0 = y
		// 		1 = x
		
		switch (rotationState) {
			case 0: // normal translation
				switch (direction) {
					case 0: // relative y
						y += amount;
						block.setBoardY((int)y);
						break;
					case 1: // relative x
						x += amount;
						block.setBoardX((int)x);
						break;
				}
				break;
			case 1: // rotated to the x
				switch (direction) {
					case 0: // relative y
						x += amount;
						block.setBoardX((int)x);
						break;
					case 1: // relative x
						y -= amount;
						block.setBoardY((int)y);
						break;
				}
				break;
			case 2: // rotated down
				switch (direction) {
					case 0: // relative y
						y -= amount;
						block.setBoardY((int)y);
						break;
					case 1: // relative x
						x -= amount;
						block.setBoardX((int)x);
						break;
				}
				break;
			case 3: // rotated to the left
				switch (direction) {
				case 0: // relative y
					x -= amount;
					block.setBoardX((int)x);
					break;
				case 1: // relative x
					y += amount;
					block.setBoardY((int)y);
					break;
				}
				break;
		}
	}
}
