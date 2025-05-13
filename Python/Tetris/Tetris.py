from GameBoard import *
from tkinter import *
import tkinter

window: Tk = Tk()
window.geometry()
window.title("Python Tetris")

game = Game(window, 30)
window.mainloop()