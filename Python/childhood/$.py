#do not copy the print function
import pygame, sys
from pygame.locals import *

pygame.init()

red=(255, 0, 0)
blue=(0, 0, 255)
green=(0, 255, 0)
black=(0, 0, 0)
white=(255, 255, 255)


screen=pygame.display.set_mode((500,500))
pygame.display.set_caption('$')

while True:

    mpos=pygame.mouse.get_pos()

    if pygame.mouse.get_pressed()[0]==1:
        print(str(mpos))
    
    screen.fill(white)    

    pygame.draw.line(screen, blue, (200, 100), (200, 150), 8)
    pygame.draw.line(screen, blue, (250, 100), (250, 150), 8)
    pygame.draw.line(screen, blue, (300, 100), (300, 150), 8)


    pygame.draw.line(screen, blue, (200, 250), (200, 300), 8)
    pygame.draw.line(screen, blue, (250, 250), (250, 300), 8)
    pygame.draw.line(screen, blue, (300, 250), (300, 300), 8)

    pygame.draw.line(screen, blue, (300, 250), (250, 150), 8)    
    pygame.draw.line(screen, blue, (250, 250), (200, 150), 8)

    pygame.draw.line(screen, blue, (224, 197), (200, 250), 8)
    pygame.draw.line(screen, blue, (281, 210), (300, 150), 8)

    pygame.draw.line(screen, blue, (250, 50), (300, 100), 8)
    pygame.draw.line(screen, blue, (250, 50), (200, 100), 8)

    pygame.draw.line(screen, blue, (250, 350), (300, 300), 8)
    pygame.draw.line(screen, blue, (250, 350), (200, 300), 8)
    
    
    for event in pygame.event.get():
        if event.type == QUIT :
            pygame.quit()
            sys.exit()




    pygame.display.update()
