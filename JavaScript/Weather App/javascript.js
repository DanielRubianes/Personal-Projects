// setup canvas
var canvas = document.getElementById("page");
var ctx = canvas.getContext("2d");

// define drawing space
var weather = {};
weather.tetromino = [];
weather.px = 0;
weather.py = 0;
// set frame/loop rate
weather.fps = 10;
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
		ctx.rect(boardXlist[i],boardYlist[i],38,38);
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
	ctx.fillRect(boardXlist[pos],boardYlist[pos],38,38);
	ctx.strokeStyle="#000000";
	ctx.rect(boardXlist[pos],boardYlist[pos],38,38);
	ctx.stroke();
}
// clear function
weather.clr = function() {ctx.clearRect(0, 0, canvas.width, canvas.height);}

// *** testing code ***



// ***

// tetromino setup
// type
weather.tetromino[0] = 0;
// position
weather.tetromino[1] = 0;
// rotation
weather.tetromino[2] = 0;

// Bar Graph
weather.graph = function(ctx,Xlist,Ylist) {
	const gradient = ctx.createLinearGradient(0,0, window.innerWidth,0);
	gradient.addColorStop(0, '#abeb34');
	gradient.addColorStop(.25, "#7aeb34");
	gradient.addColorStop(.5, "#34ebb1");
	gradient.addColorStop(1, "#3462eb");
	ctx.fillStyle = gradient;
	ctx.beginPath();
	//ctx.moveTo(0, 0);
	count = Xlist.length;
	if (count > Ylist.length) {count = Ylist.length;}
	for (i = 0; i < count; i++) {
		if ((i != 0) && (i != (i.length))) {
			X = Xlist[i]-100;
			Y = (Ylist[i-1] - Ylist[i])*3/4;
			ctx.lineTo(X,Math.abs(Y));
			console.log("1st stagger - X: "+X+" Y:"+Y);

			X = Xlist[i];
			Y = Ylist[i];
			ctx.lineTo(X,Y);
			console.log("center - X: "+X+" Y:"+Y);
			
			X = Xlist[i]+100;
			Y = (Ylist[i-1] - Ylist[i])*3/4;
			ctx.lineTo(X,Math.abs(Y));
			console.log("2nd stagger - X: "+X+" Y:"+Y);
		}
		else {
			X = Xlist[i];
			Y = Ylist[i];
			ctx.lineTo(X,Y);
			console.log("start or end - X: "+X+" Y:"+Y);
		}
	}
	ctx.lineTo(window.innerWidth,window.innerHeight);
	ctx.lineTo(0,window.innerHeight);
	ctx.lineTo(0,0);
	ctx.closePath();
	ctx.fill();
}

// draw function
weather.draw = function() {
	// clear board
	weather.clr();

	Xlist = [0,window.innerWidth/4,window.innerWidth/2,window.innerWidth*3/4,window.innerWidth];
	Ylist = [0,200,300,250,350];
	
	weather.graph(ctx,Xlist,Ylist);
	//ctx.rect(20, 20, 150, 100);

	
}
// active game logic
weather.update = function() {
	//gravity
	if (boardYlist[weather.tetromino[1]] >= 722) {weather.tetromino[0] = 0}
	else {weather.tetromino[1] += 10;}
	
	
	// pick a tetromino & reset ratation and position if [0] is 0
	if (weather.tetromino[0] == 0) {
		weather.tetromino[0] = (Math.floor(Math.random() * 7) + 1)
		weather.tetromino[1] = 5;
		weather.tetromino[2] = 0;
	}
}








