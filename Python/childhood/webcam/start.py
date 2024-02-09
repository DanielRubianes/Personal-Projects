print('---------------CODE START---------------')
print('starting...')
#imports
import pygame, sys
import pygame.camera
from pygame.locals import *
from classes import *

print('setting variables...')
#vars
posText=False
on=True
pic=True
ico='cam'
#startup
print('initialising pygame...')
pygame.init()
print('initialising webcam...')
pygame.camera.init()
print('starting screen...')
screen=pygame.display.set_mode((640,480),0,32)
pygame.display.set_caption('webcam')

print('setting camera...')
cam = pygame.camera.Camera(0)
print('starting camera...')
cam.start()

#images
print("loading images...")
cami=pygame.image.load("cam.png").convert_alpha()
reci=pygame.image.load("rec.png").convert_alpha()

#fonts
print("loading fonts...")
agent = pygame.font.SysFont("agent orange", 40)
#colors
red = (255, 0 , 0)
green = (0, 255, 0)
blue = (0, 0, 255)
white = (255, 255, 255)
black = (0, 0, 0)

print('done!')
#main loop
while on:
    #cam update
    camDisplay = cam.get_image()
    #blits
    screen.blit(camDisplay,(0,0))
    if ico=='cam':
        screen.blit(cami,(10,10))
    if ico=='rec':
        screen.blit(reci,(10,10))
    #mpos
    mpos=str(pygame.mouse.get_pos())
    if posText:
        displaytext(agent, mpos, 575, 455, white, screen)
    for event in pygame.event.get():
        if event.type == QUIT :
            on=False
        if event.type == KEYDOWN:
            if event.key==K_s:
                print('webcam saved as "shot.png"')
                pygame.image.save(camDisplay, 'shot.png')
            if event.key==K_t and ico=='cam' and pic:
                ico='rec'
                pic=False
                print('recording (N.Y.I.)')
            if event.key==K_t and ico=='rec' and pic:
                ico='cam'
                pic=False
                print('camera')
        if event.type == KEYUP:
            if event.key==K_t:
                pic=True
    if on:
        pygame.display.update()


print('stopping program...')
print('stoping pygame...')
pygame.quit()
print('---------------CODE END---------------')
