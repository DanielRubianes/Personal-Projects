from tkinter import *
import random

EMPTY = object()

class LoopList:

    _iter: iter
    _list: list
    
    def __init__(self, list: list):
        self._list = list
        self._iter = iter(list)

    def __iter__(self):
        return self
    
    def __next__(self):
        output = next(self._iter, EMPTY)
        if output is EMPTY:
            self._iter = iter(self._list)
            return next(self._iter)
        return output

class Coords:

    x: int = None
    y: int = None

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __add__(self, other):
        if isinstance(other, Coords):
            return Coords(self.x + other.x, self.y + other.y)
        else:
            raise TypeError(f"Unsupported operand type {str(self)} + {str(other)}")

    def __mul__(self, other):
        if isinstance(other, Coords):
            return Coords(self.x * other.x, self.y * other.y)
        elif isinstance(other, (int, float)):
            return Coords(self.x * other, self.y * other)
        else:
            raise TypeError(f"Unsupported operand type {str(self)} * {str(other)}")
        
    def flip(self, boolean):
        if boolean:
            return Coords(self.y, self.x)
        else:
            return Coords(self.x, self.y)

    def __repr__(self):
        return f"Coords({self.x}, {self.y})"
    
    def __iter__(self):
        for i  in (self.x, self.y):
            yield i

    # Allow declarations with tuples (x, y)
    @classmethod
    def t(cls, xy: tuple[int, int]):
        x, y = xy
        return cls(x, y)

class Block:

    blockType: str = None
    xy: Coords = None

    _colors = {
        "I": "#00FFFF",
        "J": "#FF7F00",
        "L": "#0000FF",
        "O": "#FFFF00",
        "S": "#00FF00",
        "T": "#800080",
        "Z": "#FF0000"
    }

    def __init__(self, blockType, xy: Coords):
        if blockType in self._colors.keys():
            self.blockType = blockType
            self.xy = Coords(int(xy.x), int(xy.y))
        else: 
            raise ValueError(f"{blockType} is an invalid block type!")
    
    def __repr__(self):
        return f"<Single block with type {self.blockType} and color {self.color} @ {self.xy}>"

    @property
    def color(self):
        return self._colors[self.blockType]

class Tetromino:
    
    tetrominoType: str = None
    blocks: list[Block] = []
    xy: Coords = None
    
    # (X, Y) values relative to center for each block
    # Initial rotation
    _I = [
        (-1.5, -.5),
        (-.5, -.5),
        (.5, -.5),
        (1.5, -.5)
    ]
    _J = [
        (-1, -1),
        (-1, -0),
        (0, -0),
        (1, -0)
    ]
    _L = [
        (1, -1),
        (1, -0),
        (0, -0),
        (-1, -0)
    ]
    _O = [
        (-.5, .5),
        (-.5, -.5),
        (.5, -.5),
        (.5, .5)
    ]
    _S = [
        (-1, -0),
        (0, -0),
        (0, -1),
        (1, -1)
    ]
    _T = [
        (-1, -0),
        (0, -0),
        (1, -0),
        (0, -1)
    ]
    _Z = [
        (-1, -1),
        (0, -1),
        (0, -0),
        (1, -0)
    ]

    _shapes = {
        "I": _I,
        "J": _J,
        "L": _L,
        "O": _O,
        "S": _S,
        "T": _T,
        "Z": _Z
    }

    # Define SRS Kicks
    # Key: tuple[int, int]; init rotation, target rotation
    # Value: list[tuple[x, y]]
    _defaul_kicks = {
        (0, 1): [
            (-1, 0), (-1, -1), (0, 2), (-1, 2)
        ],
        (1, 0): [
            (-1, 0), (-1, -1), (0, 2), (-1, 2)
        ],
    }
    _I_kicks = {

    }

    _O_kicks = [
        (0, 0)
    ]

    def __init__(self, tetrominoType=None, x=4, y=0):
        
        # Possible rotation values
        # FORMAT: (Coords, Bool: flip x and y?)
        self._rotation_values = LoopList([
            ( Coords(1, 1), False),
            ( Coords(-1, 1), True),
            ( Coords(-1, -1), False),
            ( Coords(1, -1), True)
        ])
        self._rotation = next(self._rotation_values)

        self._rotation_states = LoopList([
            0, 1, 2, 3
        ])
        self._rotation_state = next(self._rotation_states)

        # Shift a half block for shapes that rotate about a grid corner
        if not tetrominoType:
            tetrominoType = random.choice(list(self._shapes.keys()))
        if tetrominoType in ["O", "I"]:
            x += .5
            y -= .5
        self.tetrominoType = tetrominoType
        self.xy = Coords(x, y)

    def __repr__(self):
        return f"<{self.tetrominoType} tetromino with blocks: {self.blocks}>"
    
    @property
    def blocks(self):
        rotation, flip_state = self._rotation
        blocks =  [Block(self.tetrominoType, self.xy + Coords.t(shift).flip(flip_state) * rotation)
                   for shift
                   in self._shapes[self.tetrominoType]]
        return blocks
    
    def rotate(self, grid):
        self._rotation = next(self._rotation_values)
        self._rotation_state = next(self._rotation_states)
        print(self._rotation_state)
        self._kick(grid)

    # Preform an SRS "kick" function after rotating Tetromino
    def _kick(self, grid) -> bool:



        return False

    # Return false if tetromino touches borders or existing blocks within a given GameGrid object
    def bumpX(self, grid):

        # Test for borders
        for block in self.blocks:
            x, y = block.xy
            if x >= grid.xSize or x < 0:
                return True
            if grid[block.xy]:
                return True
        return False

    # Return false if tetromino touches borders or existing blocks within a given GameGrid object
    def bumpY(self, grid):

        # Test for borders
        for block in self.blocks:
            x, y = block.xy
            if y >= grid.ySize:
                return True
            if grid[block.xy]:
                return True
        return False


class GameGrid:

    # List of X coordinates, containing lists of y coordinates
    # Origin is @ top left
    # 10 x 20 default
    board: list[list[Block]] = EMPTY
    xSize: int
    ySize: int

    activeTetromino: Tetromino = None

    def __init__(self, xSize: int=10, ySize: int=20):
        self.xSize = xSize
        self.ySize = ySize
        if self.board is EMPTY:
            #self.board = [[None]*self.ySize for _ in range(self.xSize)]
            self.board = [[None]*self.xSize for _ in range(self.ySize)]
    
    def __repr__(self):
        string = "<GameBoard grid object:"
        for x, xList in enumerate(self.board):
            string += "\n"
            for y, yItem in enumerate(xList):
                if yItem:
                    string += f"{yItem.blockType}"
                else:
                    string += "N"
        return string + ">"
    
    def __getitem__(self, xy: Coords):
        x, y = xy
        return self.board[y][x]
    def __setitem__(self, xy: Coords, newBlock):
        x, y = xy
        if not self.board[y][x]:
            self.board[y][x] = newBlock

    def getTKShapes(self, pixelWidth, pixelHeight):
        squares = []
        xWidth = pixelWidth / self.xSize
        yWidth = pixelHeight / self.ySize
        for y, yList in enumerate(self.board):
            for x, xItem in enumerate(yList):
                if xItem:
                    x, y = xItem.xy
                    squares.append( ( (x*xWidth, y*yWidth, (x+1)*xWidth, (y+1)*yWidth), xItem.color) )
        for block in self.activeTetromino.blocks:
            x, y = block.xy
            squares.append( ( (x*xWidth, y*yWidth, (x+1)*xWidth, (y+1)*yWidth), block.color) )
        return squares

    # TODO: Simplify this by relying more on the array position rather than Block.xy value
    def updateBlocks(self):
        for y, yList in enumerate(self.board):
            for x, xItem in enumerate(yList):
                if xItem:
                    xItem.xy = Coords(x, y)

    # Clears the line @ the specified y value and drops every row above down to that value
    def drop(self, yClear):
        self.board[yClear] = [None]*self.xSize
        for y in range(yClear, 1, -1):
            self.board[y] = [None]*self.xSize
            for x, block in enumerate(self.board[y-1]):
                if block: 
                    self.board[y][x] = block
        self.updateBlocks()

    def place(self, object):
        if isinstance(object, Block):
            self[object.xy] = object
        elif isinstance(object, Tetromino):
            for block in object.blocks:
                self[block.xy] = block
        else:
            raise ValueError(f"{repr(object)} not a valid object to draw!")
        for y, yList in enumerate(self.board):
            if None not in yList:
                self.drop(y)
                print(self)
    
    def draw(self, canvas: Canvas, scale):
        width = self.xSize * scale
        height = self.ySize * scale

        canvas.delete("all")

        # Draw static blocks
        for coordinates, color in self.getTKShapes(width, height):
            canvas.create_rectangle(coordinates, fill=color, width=0)

        # Draw grid
        XIncrement = width / 10
        YIncrement = height / 20
        gridLines = [
            (XIncrement*i, 0, XIncrement*i, height)
            for i in range(1, 10)] + [
            (0, YIncrement*i, width, YIncrement*i)
            for i in range(1, 20)
        ]

        for coordinates in gridLines:
            canvas.create_line(coordinates, fill="black", width=2)

        canvas.pack(expand = True, fill = BOTH)


class Game:

    """Game class to run alongside main loop"""

    _grid: GameGrid
    _frame: Frame
    _canvas: Canvas
    _scale: int
    speed: int

    def __init__(self, frame: Frame, scale: int=40):

        self._scale = scale
        self.speed = 1000

        grid = GameGrid()
        grid.activeTetromino = Tetromino("I")
        self._grid = grid
        self._frame = frame

        width = grid.xSize * self._scale
        height = grid.ySize * self._scale

        # NOTE: Test
        # for i in range(0, 20):
        #     grid.place(Block("I", Coords(i, i)))
        # for block in Tetromino(5, 5, "L").blocks:
        #     grid.place(block)
        #     print(block)

        self._canvas = Canvas(frame,bg='white', width=width, height=height)

    def loop(self):

        grid = self._grid

        grid.draw(self._canvas, self._scale)

        grid.activeTetromino.xy.y += 1

        if (grid.activeTetromino.bumpY(grid)):
            grid.activeTetromino.xy.y -= 1
            grid.place(grid.activeTetromino)
            grid.activeTetromino = Tetromino()

    def key_down(self, event: Event):

        key = event.keysym
        grid = self._grid
        canvas = self._canvas

        # Rotate
        if key == "Up":
            self._grid.activeTetromino.rotate(self._grid)
            grid.draw(canvas, self._scale)

        # Move left
        if key == "Left":
            tetromino = self._grid.activeTetromino

            tetromino.xy.x -= 1
            if (tetromino.bumpX(grid)):
                tetromino.xy.x += 1
            grid.draw(canvas, self._scale)

        # Move Right
        if key == "Right":
            grid.activeTetromino.xy.x += 1
            if (grid.activeTetromino.bumpX(grid)):
                self._grid.activeTetromino.xy.x -= 1
            grid.draw(canvas, self._scale)
        
        # Drop faster
        if key == "Down":
            # self.speed = 50
            self.loop()
    
    def key_up(self, event: Event):

        key = event.keysym

        # Slow to normal speed
        if key == "Down":
            self.speed = 1000