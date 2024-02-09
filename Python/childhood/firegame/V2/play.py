#startup
print('---------------------------------DEBUG CONSOLE---------------------------------')
print('STARTING')
#import statments
import pygame, sys, random
from pygame.locals import *
#var sets
end2=False
isP2=False
cinp=False
end=False
menu=True
pos2=False
#x,y sets
mey=150
mex=280

ey1=160
ex1=280

dx=305
dy=175
#clock
clock=pygame.time.Clock()
fps=700
pfps=300

pygame.init()

#load images
bif=pygame.image.load('bg.jpg')
mif=pygame.image.load('ball.png')
mif2=pygame.image.load('ball2.png')
eim=pygame.image.load('water.png')
eimd=pygame.image.load('water-drop.png')
p2=pygame.image.load('ball3.png')
p2f=pygame.image.load('ball4.png')
#set screen
screen = pygame.display.set_mode(bif.get_size())
pygame.display.set_caption('Fireball game')
bg=bif.convert()
#load sprites
mouse_c=mif.convert_alpha()
enda=mif2.convert_alpha()
enemy=eim.convert_alpha()
drop=eimd.convert_alpha()
player2=p2.convert_alpha()
player2f=p2f.convert_alpha()
#player sprites x, y
x, y = 0, 0
x2, y2= 0, 0
movex, movey = 0, 0
movex2, movey2=0,0
#function start song
def startSong(song):
    pygame.mixer.music.load(song)
    pygame.mixer.music.play(-1, 0.0)
    print('now playing song: ' + song)
#start music
startSong('mcmusic.ogg')
#function play sound
def playSound(sound):
    play=pygame.mixer.Sound(sound)
    play.play()
    print('now playing sound: ' + sound)
#add backgorund
screen.blit(bg, (0, 0))
pygame.display.update()
#finish startup
print('DONE!')
#font and text
font = pygame.font.SysFont("comicsansms", 60)
fontSmall = pygame.font.SysFont("comicsansms", 20)
fontMed= pygame.font.SysFont("comicsansms", 40)
titleText = font.render("Press enter to start", True, (0, 128, 0))
verText = fontMed.render("Firegame V2", True, (255, 0, 0))
p2ty=10
p2tx=80
p2Text = fontSmall.render("Press / to join", True, (0, 128, 0))
#menu loop
while menu:
    screen.blit(bg, (0, 0))
    #display the text
    screen.blit(titleText,(320 - titleText.get_width() // 2, 150 - titleText.get_height() // 2))
    screen.blit(verText,(120 - verText.get_width() // 2, 20 - verText.get_height() // 2))
    pygame.display.flip()
    clock.tick(60)
    #keys
    for event in pygame.event.get():
        if event.type==KEYDOWN:
            if event.key==K_RETURN:
                menu=False
                playSound("menu.ogg")
            if event.key==K_ESCAPE:
                print("STOPING...")
                pygame.quit()
                sys.exit()
        if event.type==QUIT:
            print("STOPING...")
            pygame.quit()
            sys.exit
#instructions
print('game started!')
print('Use w, a, s, and d to move around')
print('and space to change items')
#attempt at fullscreen
#main loop
while True:
   #make the game close when "x" is pressed
   for event in pygame.event.get():
       if event.type == QUIT:
         print('STOPING...')
         pygame.quit()
         sys.exit()
       #key actions
       if event.type==KEYDOWN:
         if event.key==K_SPACE:
           if end==False:
             playSound('end.ogg')
             end=True
           elif end==True:
             playSound('fire.ogg')
             end=False
         if event.key==K_RSHIFT:
           if end2==False:
             playSound('end.ogg')
             end2=True
           elif end2==True:
             playSound('fire.ogg')
             end2=False
         if event.key==K_a and movex==0:
           movex =-1
         if event.key==K_d and movex==0:
           movex =+1
         if event.key==K_w and movey==0:
           movey=-1
         if event.key==K_s and movey==0:
           movey=+1
         if event.key==K_LEFT:
           movex2=-1
         if event.key==K_RIGHT:
           movex2=+1
         if event.key==K_UP:
           movey2=-1
         if event.key==K_DOWN:
           movey2=+1
         if event.key==K_SLASH:
           if isP2==False:
             isP2=True
             pos2=True
             print('added player 2 (buggy with the boundrys)')
         if event.key==K_RETURN:
             #console-on
             print('please enter your command')
             command=input()
             cinp=True
         #To make the window close when escape button is pressed.
         if event.key==K_ESCAPE:
           print('STOPING...')
           pygame.quit()
           sys.exit()
       #stop movement when key is let go
       if event.type==KEYUP:
         if event.key==K_a:
           movex=0
         if event.key==K_d:
           movex=0
         if event.key==K_w:
           movey=0
         if event.key==K_s:
           movey=0
         if event.key==K_LEFT:
           movex2=0
         if event.key==K_RIGHT:
           movex2=0
         if event.key==K_DOWN:
           movey2=0
         if event.key==K_UP:
           movey2=0
   #make the sprites move
   #p1
   x+=movex
   y+=movey
   #p2
   x2+=movex2
   y2+=movey2
   #bg blit
   screen.blit(bg, (0, 0))
   #drop blit
   screen.blit(drop, (dx,dy))
   if pos2:
       x2=0
       y2=0
       pos2=False
   #adding player 2
   if isP2:
       if end2==False:
         screen.blit(player2f, (x2, y2))
       elif end2==True:
         screen.blit(player2, (x2, y2))
   else:
       #display the text
       screen.blit(p2Text,(p2tx - p2Text.get_width() // 2, p2ty - p2Text.get_height() // 2))
   #boundrys
   if x>584:
       x=584
   if x<-8:
       x=-8
   if y>305:
       y=305
   if y<-8:
       y=-8
   if x2>584:
       x2=584
   if x2<-8:
       x2=-8
   if y2>305:
       y2=305
   if y2<-8:
       y2=-8
   #change the ball
   if end==False:
     screen.blit( mouse_c, (x, y) )
   elif end==True:
     screen.blit( enda, (x, y) )

     

   screen.blit(enemy, (mex, mey))
   #clock
   mili=clock.tick()
   sec=mili/1000.0
   dm=sec*fps
   # drop animation
   dx+=dm
   if dx>640:
       dx=305
   #update the display
   pygame.display.update()
   #commands
   if cinp:
       if command=='text':
           print('please enter your x cordanate,')
           print('followed by your y cordanate')
           p2tx=int(input())
           p2ty=int(input())
           cinp=False
       if command=='kill':
           print('KILLING...')
           pygame.quit()
           sys.exit()
       if command=='tp':
           print('please enter your x cortanate')
           x=int(input())
           print('please enter your y cordanate')
           y=int(input())
           print('position set!')
           cinp=False
       if command=='playsound':
           print('please enter sound')
           csound=input()
           playSound(csound)
           cinp=False
       if command=='fps':
           print('please enter your custom fps')
           fps=int(input())
           print('fps set!')
           cinp=False
       if command=='setwater':
           print('please enter your custom y cordanate')
           mey=int(input())
           print('please enter your custom x cordanate')
           mex=int(input())
           cinp=False
       if command=='p2':
           print('adding player 2...')
           isP2=True
           pos2=True
           print('Done!')
           cinp=False
       if command=='help':
           print('command list:')
           print('kill - kills the program')
           print('tp - teleport the players')
           print('playsound - plays a sound in the program folder')
           print('fps - changes the fps of the water droplets')
           print('setwater - sets  the pos. of the main water drop')
           print('p2 - add a second player')
           print('text - change the text position')
           cinp=False
