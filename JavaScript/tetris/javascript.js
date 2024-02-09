// **Notes**

// Motion
// down = + 10
// up 	= - 10
// left = - 1
// right= + 1

// setup canvas
var canvas = document.getElementById("tetris");
var ctx = canvas.getContext("2d");

// define game and some game variables
var tetris = {};
tetris.tetromino = [];
tetris.px = 0;
tetris.py = 0;
// set frame/loop rate
tetris.fps = 10;
//0 - 200; defines existence/color of each possible block position
var board = [];
//0 - 200; x coordinate for each block position
var boardx = [];
//0 - 200; y coordinate for each block position
var boardy = [];
var sety = 0;
var setx = 0;
// setting boardx & boardy
for (i = 1; i < 201; i++) {
	// set all spaces to blank
	board.push(0);
	// set coordinates
	boardx.push(setx);
	boardy.push(sety);
	setx += 38;
	if ((((i) % 10) === 0)) {
		sety += 38;
		setx = 0;
	}
}
// function to draw grid
function drawGrid() {
	for (i=0; i < 201; i++) {
		ctx.strokeStyle="#000000";
		ctx.rect(boardx[i],boardy[i],38,38);
		ctx.stroke();
	}
}
// function to place a block on the board
function placeBlock(pos, color) {
	if (color == 1) {ctx.fillStyle = "#44FFFF";} // light blue		(I)
	else if (color == 2) {ctx.fillStyle = "#FFFF44";} // yellow		(O)
	else if (color == 3) {ctx.fillStyle = "#FF8800";} // orange		(L)
	else if (color == 4) {ctx.fillStyle = "#FF0000";} // red		(Z)
	else if (color == 5) {ctx.fillStyle = "#00FF00";} // green		(S)
	else if (color == 6) {ctx.fillStyle = "#0000FF";} // blue		(J)
	else if (color == 7) {ctx.fillStyle = "#FF44FF";} // purple		(T)
	ctx.fillRect(boardx[pos],boardy[pos],38,38);
	ctx.strokeStyle="#000000";
	ctx.rect(boardx[pos],boardy[pos],38,38);
	ctx.stroke();
}
// function to place tetromino
function placeTetromino(pos, type, orientation) {
	// do nothing
	if (type == 0) {return true;}
	
	// Draw I-Block (rotates around a point in between blocks)
	else if (type == 1) {
		if (orientation == 0) {
			placeBlock(pos-10, type); 	// top
			placeBlock(pos, type);		// next
			placeBlock(pos+10, type); 	// next
			placeBlock(pos+20, type); 	// bottom
		}
		else if (orientation == 2) {
			placeBlock(pos-9, type);	// top
			placeBlock(pos+1, type);	// next
			placeBlock(pos+11, type);	// next
			placeBlock(pos+21, type);	// bottom
		}
		else if (orientation == 1) {
			placeBlock(pos-1, type); // left
			placeBlock(pos, type);   // next
			placeBlock(pos+1, type); // next
			placeBlock(pos+2, type); // right
		}
		else if (orientation == 3) {
			placeBlock(pos+9, type);  // left
			placeBlock(pos+10, type); // next
			placeBlock(pos+11, type); // next
			placeBlock(pos+12, type); // right
		}
	}
	
	// Draw O-Block (pos is top-left, regardless of orientation)
	else if (type == 2) {
		placeBlock(pos, type); 		// start (top-left)
		placeBlock(pos+1, type); 	// top-right
		placeBlock(pos+10, type); 	// bottom-left
		placeBlock(pos+11, type); 	// bottom-right
	}
	
	// Draw L-Block (pos is rotation center; in the middle of the L)
	else if (type == 3) {
		if (orientation == 0) {
			placeBlock(pos-9, type); 	// top
			placeBlock(pos+1, type);	// down
			placeBlock(pos, type); 		// left
			placeBlock(pos-1, type); 	// left
		}
		if (orientation == 1) {
			placeBlock(pos-10, type); 	// top
			placeBlock(pos, type);		// down
			placeBlock(pos+10, type); 	// down
			placeBlock(pos+11, type); 	// right
		}
		if (orientation == 2) {
			placeBlock(pos+9, type);	// bottom
			placeBlock(pos-1, type);	// up
			placeBlock(pos, type); 		// right
			placeBlock(pos+1, type); 	// right
		}
		if (orientation == 3) {
			placeBlock(pos-11, type); 	// top-left
			placeBlock(pos-10, type);	// right
			placeBlock(pos, type); 		// down
			placeBlock(pos+10, type); 	// down
		}
	}
	
	// Draw Z-Block (pos starts in bottom left and rotatates around that point)
	else if (type == 4) {
		if (orientation == 0) {
			placeBlock(pos, type);
			placeBlock(pos+1, type);
			placeBlock(pos-11, type);
			placeBlock(pos-10, type);
		}
		if (orientation == 1) {
			placeBlock(pos, type);
			placeBlock(pos+10, type);
			placeBlock(pos-9, type);
			placeBlock(pos+1, type);
		}
		if (orientation == 2) {
			placeBlock(pos, type);
			placeBlock(pos-1, type);
			placeBlock(pos+10, type);
			placeBlock(pos+11, type);
		}
		if (orientation == 3) {
			placeBlock(pos, type);
			placeBlock(pos-10, type);
			placeBlock(pos-1, type);
			placeBlock(pos+9, type);
		}
	}
	
	// Draw S-Block (Same as Z, but bottom right is pos)
	else if (type == 5) {
		if (orientation == 0) {
			placeBlock(pos, type);
			placeBlock(pos-1, type);
			placeBlock(pos-9, type);
			placeBlock(pos-10, type);
		}
		if (orientation == 1) {
			placeBlock(pos, type);
			placeBlock(pos-10, type);
			placeBlock(pos+11, type);
			placeBlock(pos+1, type);
		}
		if (orientation == 2) {
			placeBlock(pos, type);
			placeBlock(pos+1, type);
			placeBlock(pos+9, type);
			placeBlock(pos+10, type);
		}
		if (orientation == 3) {
			placeBlock(pos, type);
			placeBlock(pos-11, type);
			placeBlock(pos-1, type);
			placeBlock(pos+10, type);
		}
	}
	
	// Draw J-Block (pos is rotation center; center of J)
	else if (type == 6) {
		if (orientation == 0) {
			placeBlock(pos-11, type);
			placeBlock(pos+1, type);
			placeBlock(pos, type); 
			placeBlock(pos-1, type); 
		}
		if (orientation == 1) {
			placeBlock(pos-10, type);
			placeBlock(pos, type);
			placeBlock(pos+10, type);
			placeBlock(pos-9, type);
		}
		if (orientation == 2) {
			placeBlock(pos+11, type);
			placeBlock(pos-1, type);
			placeBlock(pos, type);
			placeBlock(pos+1, type);
		}
		if (orientation == 3) {
			placeBlock(pos+9, type);
			placeBlock(pos-10, type);
			placeBlock(pos, type);
			placeBlock(pos+10, type);
		}
	}
	
	// Draw T-Block (pos is rotation center; center of T)
	else if (type == 7) {
		if (orientation == 0) {
			placeBlock(pos-10, type);
			placeBlock(pos, type);
			placeBlock(pos-1, type);
			placeBlock(pos+1, type);
		}
		if (orientation == 1) {
			placeBlock(pos-10, type);
			placeBlock(pos, type);
			placeBlock(pos+1, type);
			placeBlock(pos+10, type);
		}
		if (orientation == 2) {
			placeBlock(pos+10, type);
			placeBlock(pos, type);
			placeBlock(pos-1, type);
			placeBlock(pos+1, type);
		}
		if (orientation == 3) {
			placeBlock(pos-10, type);
			placeBlock(pos, type);
			placeBlock(pos-1, type);
			placeBlock(pos+10, type);
		}
	}

}

// clear function
tetris.clr = function() {ctx.clearRect(0, 0, canvas.width, canvas.height);}

// *** testing code ***



// ***

// tetromino setup
// type
tetris.tetromino[0] = 0;
// position
tetris.tetromino[1] = 0;
// rotation
tetris.tetromino[2] = 0;

// draw function
tetris.draw = function() {
	// clear board
	tetris.clr();
	// draw grid
	 drawGrid();
	// fill board with blocks defined in board[]
	for (b = 0; b < board.length; b++) {
		// skip if block is blank
		if (board[b] == 0) {continue;}
		// place block
		placeBlock(b, board[b]);
	}
	// draw current tetromino
	placeTetromino(tetris.tetromino[1],tetris.tetromino[0],tetris.tetromino[2]);
}
// active game logic
tetris.update = function() {
	//gravity
	if (boardy[tetris.tetromino[1]] >= 722) {tetris.tetromino[0] = 0}
	else {tetris.tetromino[1] += 10;}
	
	
	// pick a tetromino & reset ratation and position if [0] is 0
	if (tetris.tetromino[0] == 0) {
		tetris.tetromino[0] = (Math.floor(Math.random() * 7) + 1)
		tetris.tetromino[1] = 5;
		tetris.tetromino[2] = 0;
	}
}








