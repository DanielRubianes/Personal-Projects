from tkinter import *

EMPTY = object()

class Wrapper:

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

    def __repr__(self):
        return f"Coords({self.x}, {self.y})"

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

    def __init__(self, blockType, xy):
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
    _rotation = (0, 0)
    
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

    # Possible rotation values
    _rotation_values = Wrapper([
        Coords(1, 1),
        Coords(-1, 1),
        Coords(-1, -1),
        Coords(1, -1),
    ])

    def __init__(self, tetrominoType, x, y):
        self.tetrominoType = tetrominoType
        self.xy = Coords(x, y)

    def __repr__(self):
        return f"<{self.tetrominoType} tetromino with blocks: {self.blocks}>"
    
    @property
    def blocks(self):
        print(f"COORDINATES: {self.xy}")
        return [Block(self.tetrominoType, self.xy + Coords.t(shift))
                for shift 
                in self._shapes[self.tetrominoType]]
    
    def rotate(self):
        self.xy *= next(self._rotation_values)

    def bump(self, newXY):
        pass

    def kick(self, newXY):
        pass


class GameGrid:

    # List of X coordinates, containing lists of y coordinates
    # Origin is @ top left
    # 10 x 20 default
    board: list[list[Block]] = [[]]
    xSize = int
    ySize = int

    activeTetromino: Tetromino = None

    def __init__(self, xSize: int=10, ySize: int=20):
        self.xSize = xSize
        self.ySize = ySize
        self.board = [
            [None for y in range(self.ySize)]
            for x in range(self.xSize)
        ]
    
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
        x, y = (xy.x, xy.y)
        return self.board[x][y]
    def __setitem__(self, xy, newBlock):
        x, y = (xy.x, xy.y)
        self.board[x][y] = newBlock

    def getTKShapes(self, pixelWidth, pixelHeight):
        squares = []
        xWidth = pixelWidth / self.xSize
        yWidth = pixelHeight / self.ySize
        for x, xList in enumerate(self.board):
            for y, yItem in enumerate(xList):
                if yItem:
                    x = yItem.xy.x
                    y = yItem.xy.y
                    squares.append( ( (x*xWidth, y*yWidth, (x+1)*xWidth, (y+1)*yWidth), yItem.color) )
        for block in self.activeTetromino.blocks:
            x = block.xy.x
            y = block.xy.y
            squares.append( ( (x*xWidth, y*yWidth, (x+1)*xWidth, (y+1)*yWidth), block.color) )
        return squares
    
    def add(self, object):
        if isinstance(object, Block):
            self[object.xy] = object
        elif isinstance(object, Tetromino):
            for block in object.blocks:
                self[block.xy] = block
        else:
            raise ValueError(f"{repr(object)} not a valid object to draw!")
    
    def draw(self, canvas: Canvas, scale):
        width = self.xSize * scale
        height = self.ySize * scale

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

    def __init__(self, frame: Frame, scale: int=40):

        self._scale = scale

        grid = GameGrid()

        width = grid.xSize * self._scale
        height = grid.ySize * self._scale

        # NOTE: Test
        grid.activeTetromino = Tetromino("T", 5, 1)

        self._grid = grid
        self._frame = frame

        self._canvas = Canvas(frame,bg='white', width=width, height=height)

    def loop(self):
        self._canvas.delete("all")

        self._grid.draw(self._canvas, self._scale)

        self._grid.activeTetromino.xy.y += 1

    def key_press(self, event: Event):
        key = event.keysym

        if key == "Up":
            self._grid.activeTetromino.rotate()