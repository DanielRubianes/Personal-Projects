print('starting...')
bif="bg.jpg"
mif="ball.png"


import pygame, sys
from pygame.locals import *

pygame.init()
screen=pygame.display.set_mode((640,360),0,32)
pygame.display.set_caption('Fireball cursor test')

background=pygame.image.load(bif).convert()
mouse_ball=pygame.image.load(mif).convert_alpha()
print("DONE!")
while True:
    for event in pygame.event.get():
        if event.type == QUIT:
            print('STOPING...')
            pygame.quit()
            sys.exit()


    if pygame.mouse.get_focused():
        pygame.mouse.set_visible(False)
    screen.blit(background,(0,0))

    x,y = pygame.mouse.get_pos()
    x -= mouse_ball.get_width()/2
    y -= mouse_ball.get_height()/2

    screen.blit(mouse_ball,(x,y))

    pygame.display.update()
