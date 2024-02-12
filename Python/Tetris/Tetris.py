from GameBoard import *
from tkinter import *

window = Tk()
window.geometry()
frame = Frame(window)

frame = Frame(window)
frame.pack()

width = 400
height = 800
gameCanvas = Canvas(frame,bg='white', width = width, height = height)

gameCanvas.pack(expand = True, fill = BOTH)

# Draw tetrominoes

gameGrid = GameGrid()

gameGrid.draw(Tetromino("L", 4, 15))
gameGrid.draw(Tetromino("J", 6, 10))
gameGrid.activeTetromino = Tetromino("S", 1, 1)

for coordinates, color in gameGrid.getTKShapes(width, height):
    print(coordinates)
    gameCanvas.create_rectangle(coordinates, fill=color, width=0)

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
    gameCanvas.create_line(coordinates, fill="black", width=2)


gameCanvas.pack(expand = True, fill = BOTH)
window.title("Python Tetris")
window.mainloop()