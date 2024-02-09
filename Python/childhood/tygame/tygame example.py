from pygame import *
from tygame.main import *
from tygame.extension import *

init()

screen = display.set_mode((800,600)) # you must make you display called screen as of right now

# Notice  similar way to make widgets in tkinter; it takes several keyword
# arguements and a master and makes the widget accordingly.

myFrame = Frame(screen,htitle="entry",width=100,height=100)

# Here is another Frame type which is closable

myXFrame = XFrame(screen,htitle="number",width=100,height=100)

# To place it on the screen simply
# use the place method: takes your x,y as a tuple

myFrame.place((2,2))
myXFrame.place((300,0))

# This is an entry. It is like the tkinter entry where you can type
# a string into it. To retrieve this string use the method get
# To set the sting use the method set

myEntry = Entry(myFrame,width=80)

# As you can see you can also have Frames as masters similar to tkinter

myEntry.place((5,5))

myEntry.set("entry")

# Function for the button widget

def quitB():
    global menu
    menu = 0

# This is a button it will detect when pressed and execute its target
# (which uses the keyword 'target') you can also pass arguments using the
# keyword args as a tuple

myCounter = Counter(myXFrame)

myCounter.place((2,2))

quitButton = Button(screen,text="QUIT",target=quitB)

quitButton.place((5,5))

menu = 1

msg,var = createInputBox(screen,"Hello World. My name is Eric Zhang!\nI have a message for you: use Tygame!!!")


while menu:

    for e in handle_widgets():
        if e.type == QUIT:
            menu = 0

    screen.fill(Color("red"))
    render_widgets() # draws the widgets on the screen can take a list and willonly draw those widgets
    display.flip()

quit()

# There are several other types of widgets which can be seen the source code
# More documentation and explainations will be added in the future
