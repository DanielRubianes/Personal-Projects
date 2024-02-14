from GameBoard import *
from tkinter import *
import tkinter

window = Tk()
window.geometry()
frame = Frame(window)

frame = Frame(window)
frame.pack()

game = Game(frame, 40)

def logic_loop():
    game.loop()
    window.after(game.speed, logic_loop)

def key_down(event: Event):
    game.key_down(event)
    
def key_up(event: Event):
    game.key_up(event)

window.title("Python Tetris")

# Key press actions
frame.bind_all("<KeyPress>", key_down)
frame.bind_all("<KeyRelease>", key_up)

# Start main loop and game logic loop
logic_loop()
window.mainloop()