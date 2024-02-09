import pygame, sys
from pygame.locals import *

def displaytext(font, text, x, y, RGB, screen):
    text=font.render(text,True, RGB)
    screen.blit(text,(x - text.get_width() // 2, y - text.get_height() // 2))

