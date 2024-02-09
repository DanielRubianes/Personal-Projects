#do not copy the print function
print('this is not a game just the start code')
import pygame, sys
from pygame.locals import *

pygame.init()

screen=pygame.display.set_mode((640,360),0,32)
pygame.display.set_caption('Default game')

while True:

    for event in pygame.event.get():
        if event.type == QUIT :
            pygame.quit()
            sys.exit()




    pygame.display.update()
