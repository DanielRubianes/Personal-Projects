from GameBoard import *
import tkinter as tk

window: tk.Tk = tk.Tk()
window.geometry()
window.title("Python Tetris")

game = Game(window, 30)
window.mainloop()