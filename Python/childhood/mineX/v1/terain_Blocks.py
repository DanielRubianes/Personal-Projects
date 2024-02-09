import pygame, sys
from pygame.locals import *
#colors
grey=(83, 83, 83)
darkGrey=(73, 73, 73)
lightGrey=(103, 103, 103)
red=(255, 0, 0)
blue=(0, 0, 255)
green=(0, 255, 0)
brown=(92, 51, 23)
darkBrown=(82, 41, 13)
skyBlue=(0, 200, 255)

def terainBlocks(level, screen):
    if level=='L1, 1x1':
        screen.lock()        
        #sky
        pygame.draw.rect(screen, skyBlue, Rect((0,0),(800,600)))
        #grass
        pygame.draw.rect(screen, green, Rect((0,420),(800,20)))
        #dirt
        pygame.draw.rect(screen, brown, Rect((0,440),(800,160)))
        screen.unlock()
    if level=='L1, 1x2':
        screen.lock()
        #sky
        pygame.draw.rect(screen, skyBlue, Rect((0,0),(800,600)))
        #grass
        pygame.draw.rect(screen, green, Rect((0,420),(800,20)))
        #dirt
        pygame.draw.rect(screen, brown, Rect((0,440),(800,160)))
        screen.unlock()
    if level=='L1, 1x3':
        screen.lock()
        #sky
        pygame.draw.rect(screen, skyBlue, Rect((0,0),(800,600)))
        #grass
        pygame.draw.rect(screen, green, Rect((0,420),(800,20)))
        #dirt
        pygame.draw.rect(screen, brown, Rect((0,440),(800,160)))
        #elevator
        pygame.draw.rect(screen, grey, Rect((780,300), (20,300)))
        pygame.draw.rect(screen, grey, Rect((720,300), (60,20)))
        pygame.draw.rect(screen, lightGrey, Rect((720,320), (60,280)))
        pygame.draw.rect(screen, grey, Rect((720,420), (20,200)))
        pygame.draw.rect(screen, darkGrey, Rect((740,420), (40,20)))
        screen.unlock()
    if level=='L1, 2x3':
        #dirt
        pygame.draw.rect(screen, brown, Rect((0,0),(800,600)))
        pygame.draw.rect(screen, darkBrown, Rect((0,420),(800,180)))
        #elevator
        pygame.draw.rect(screen, grey, Rect((780,300), (20,300)))
        pygame.draw.rect(screen, lightGrey, Rect((720,0), (60,320)))
        pygame.draw.rect(screen, grey, Rect((720,0), (20,320)))
        pygame.draw.rect(screen, grey, Rect((780,0), (20,320)))
        pygame.draw.rect(screen, lightGrey, Rect((720,320), (60,280)))
        pygame.draw.rect(screen, grey, Rect((720,420), (20,200)))
        pygame.draw.rect(screen, darkGrey, Rect((740,420), (40,20)))
    if level=='testing':
        #bg
        pygame.draw.rect(screen, brown, Rect((0,0),(800,600)))
        pygame.draw.rect(screen, darkBrown, Rect((0,420),(800,180)))
    if level=='empty':
        pygame.draw.rect(screen, grey, Rect((0,0),(800,600)))
        
