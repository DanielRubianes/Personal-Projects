"""
Block rotation and kicking information derived from this wiki:
https://harddrop.com/wiki/SRS
"""

import tkinter as tk

from typing import Optional

import random
import time
import copy
from itertools import cycle

class Coords:
    x: int
    y: int

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
        
    def __eq__(self, other) -> bool:
        if self.x == other.x and self.y == other.y:
            return True
        else:
            return False

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
    def t(cls, xy: tuple[float, float]):
        x, y = xy
        return cls(x, y)

class Block:
    blockType: str
    xy: Coords

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
    tetrominoType: str
    xy: Coords

    _rotation: tuple[int, int, bool]
    
    # (X, Y) values relative to center for each block (O & I blocks have half step centers at the interesection of four blocks)
    _shapes: dict[ str, list[ tuple[float, float] ] ] = {
        "I":
        [
            (-1.5, -.5),
            (-.5, -.5),
            (.5, -.5),
            (1.5, -.5)
        ],
        "J":
        [
            (-1, -1),
            (-1, -0),
            (0, -0),
            (1, -0)
        ],
        "L":
        [
            (1, -1),
            (1, -0),
            (0, -0),
            (-1, -0)
        ],
        "O":
        [
            (-.5, .5),
            (-.5, -.5),
            (.5, -.5),
            (.5, .5)
        ],
        "S":
        [
            (-1, -0),
            (0, -0),
            (0, -1),
            (1, -1)
        ],
        "T":
        [
            (-1, -0),
            (0, -0),
            (1, -0),
            (0, -1)
        ],
        "Z":
        [
            (-1, -1),
            (0, -1),
            (0, -0),
            (1, -0)
        ]
    }

    _start_coordinates: dict[str, tuple[float, float] ] = {
        "I": (4.5, 0.5),
        "J": (4, 0),
        "L": (4, 0),
        "O": (4.5, 0.5),
        "S": (4, 0),
        "T": (4, 0),
        "Z": (4, 0)
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

    def __init__(self, tetrominoType=None):
        # Possible rotation values
        # FORMAT: (int, int, Bool)
            # integers represent x, y transformation (multiplication)
            # boolean is true if x and y values will be flipped
        self._rotation_values: cycle[ tuple[ int, int, bool ] ] = cycle([
            (1, 1, False),
            (-1, 1, True),
            (-1, -1, False),
            (1, -1, True)
        ])
        self._rotation = next(self._rotation_values)

        self._rotation_states = cycle([
            0, 1, 2, 3
        ])
        self._rotation_state = next(self._rotation_states)

        # Shift a half block for shapes that rotate about a grid corner
        if not tetrominoType:
            tetrominoType = random.choice(list(self._shapes.keys()))
        
        self.tetrominoType = tetrominoType
        self.xy = Coords.t(self._start_coordinates[self.tetrominoType])

    def __repr__(self):
        return f"<{self.tetrominoType} tetromino @ {self.xy} with blocks: {self.blocks}"
    
    @property
    def blocks(self) -> list[Block]:
        dx, dy, flip_state = self._rotation
        transformation = Coords(dx, dy)
        blocks =  [Block(self.tetrominoType, self.xy + Coords.t(shift).flip(flip_state) * transformation)
                   for shift
                   in self._shapes[self.tetrominoType]]
        return blocks
    
    def rotate(self, grid):
        self._rotation = next(self._rotation_values)
        self._rotation_state = next(self._rotation_states)
        self._kick(grid)

    # Preform an SRS "kick" function after rotating Tetromino
    def _kick(self, grid) -> bool:



        return False

    # Returns true if tetromino overlaps existing block or is out of x bounds
    def bumpX(self, grid):
        # Test for borders
        for block in self.blocks:
            x, y = block.xy
            if x >= grid.xSize or x < 0:
                return True
            if grid[block.xy]:
                return True
        return False

    # Returns true if tetromino overlaps existing block or is out of y bounds
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
    board: list[ list[ Optional[Block] ] ] = []
    xSize: int
    ySize: int

    activeTetromino: Tetromino

    def __init__(self, xSize: int=10, ySize: int=20):
        self.xSize = xSize
        self.ySize = ySize
        if not self.board:
            self.board = [[None]*self.xSize for _ in range(self.ySize)]
    
    def __repr__(self):
        string = "<GameBoard grid object:"
        for x, xList in enumerate(self.board):
            string += "\n"
            for y, yItem in enumerate(xList):
                if yItem:
                    string += f"{yItem.blockType}"
                else:
                    string += " "
        return string + ">"
    
    def __getitem__(self, xy: Coords):
        x, y = xy
        return self.board[y][x]
    def __setitem__(self, xy: Coords, newBlock: Block):
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

    def validate(self):
        for y, yList in enumerate(self.board):
            for x, xItem in enumerate(yList):
                if xItem:
                    if xItem.xy != Coords(x, y):
                        print(f'Block at board index {x}, {y} has coordinate value {xItem.xy}!')

    # Clears the line @ the specified y value and drops every row above down to that value
    def drop(self, yClear: int):
        self.board[yClear] = [None]*self.xSize
        for y in range(yClear, 1, -1):
            self.board[y] = [None]*self.xSize
            for x, block in enumerate(self.board[y-1]):
                if block: 
                    self.board[y][x] = block
        self.updateBlocks()

    def place(self, source: Block | Tetromino):
        if isinstance(source, Block):
            self[source.xy] = source
        elif isinstance(source, Tetromino):
            for block in source.blocks:
                self[block.xy] = block
        else:
            raise ValueError(f"{repr(source)} not a valid object to draw!")
        for y, yList in enumerate(self.board):
            if None not in yList:
                self.drop(y)
        print(self)
        self.validate()
    
    def draw(self, canvas: tk.Canvas, scale):
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

        canvas.pack(expand = True, fill = tk.BOTH)


class Game:
    """Main class to handle Tkinter GUI"""
    _scale: int
    
    _speed: float
    _prev_time: float

    _active_keys: list[str]

    _window: tk.Tk
    _frame: tk.Frame
    _grid: GameGrid
    _canvas: tk.Canvas

    def __init__(self, window: tk.Tk, scale: int=40):
        self._scale = scale
        
        self._speed = 1
        self._prev_time = time.perf_counter()

        self._active_keys: list[str] = []

        self._window = window

        frame = tk.Frame(window)
        frame.pack()
        self._frame = frame

        frame.bind_all("<KeyPress>", self.key_down)
        frame.bind_all("<KeyRelease>", self.key_up)

        grid = GameGrid()
        grid.activeTetromino = Tetromino("I")
        self._grid = grid

        width = grid.xSize * self._scale
        height = grid.ySize * self._scale
        self._canvas = tk.Canvas(frame,bg='white', width=width, height=height)

        # def game_loop():
        #     self.loop()
        #     window.after(self._speed, game_loop)
        
        self.loop()
        self.game_loop()

    def game_loop(self):

        if time.perf_counter() > (self._prev_time + self._speed):
            self._prev_time = time.perf_counter()
            self.loop()
        self._window.after(1, self.game_loop)

    def loop(self):
        grid = self._grid
        grid.activeTetromino.xy.y += 1

        if grid.activeTetromino.bumpY(grid):
            grid.activeTetromino.xy.y -= 1
            grid.place(grid.activeTetromino)
            grid.activeTetromino = Tetromino()
            
        grid.draw(self._canvas, self._scale)

    def key_down(self, event: tk.Event):
        key = event.keysym

        if key in self._active_keys:
            return
        
        self._active_keys.append(key)

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
            if tetromino.bumpX(grid):
                tetromino.xy.x += 1
            grid.draw(canvas, self._scale)

        # Move Right
        if key == "Right":
            grid.activeTetromino.xy.x += 1
            if grid.activeTetromino.bumpX(grid):
                self._grid.activeTetromino.xy.x -= 1
            grid.draw(canvas, self._scale)
        
        # Drop faster
        if key == "Down":
            self._speed = .01
    
    def key_up(self, event: tk.Event):
        key = event.keysym

        if key in self._active_keys:
            self._active_keys.remove(key)
        else:
            return

        # Slow to normal speed
        if key == "Down":
            self._speed = 1