# import the library
from appJar import gui
# create a GUI variable called app
app = gui()

# add & configure widgets - widgets get a name, to help referencing them later
app.addLabel("title", "Welcome to appJar")
app.setLabelBg("title", "red")



# start the GUI
app.go()