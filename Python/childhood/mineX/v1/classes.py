import pygame, sys
from pygame.locals import *

def displaytext(font, text, x, y, R, G, B, screen):
    text=font.render(text,True, (R, G, B))
    screen.blit(text,(x - text.get_width() // 2, y - text.get_height() // 2))
def playSound(sound):
    play=pygame.mixer.Sound(sound)
    play.play()
def startSong(song):
    pygame.mixer.music.load(song)
    pygame.mixer.music.play(-1, 0.0)
    print('now playing song: ' + song)


