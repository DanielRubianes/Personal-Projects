print("STARTING...")
bif="bg.jpg"
mif="cur.png"
import pygame, sys
from pygame.locals import *

pygame.init()

screen=pygame.display.set_mode((640,360),0,32)
pygame.display.set_caption('Draw stuff :P')

Blue=(0,0,255)
points=[]

backdrop=pygame.image.load(bif).convert()
cur=pygame.image.load(mif).convert_alpha()
print("DONE!")
while True:
    click=pygame.mouse.get_pressed()
    for event in pygame.event.get():
        if event.type == QUIT :
            print("STOPING...")
            pygame.quit()
            sys.exit()
        if event.type == KEYDOWN :
            if event.key==K_s:
                pygame.image.save(screen, 'paint.png')
                print('saved image as:paint.png')
    if click[0]==1:
        points.append(event.pos)

    if pygame.mouse.get_focused():
        pygame.mouse.set_visible(False)
    x,y = pygame.mouse.get_pos()

    
    screen.blit(backdrop, (0,0))
    if len(points)>1:
        pygame.draw.lines(screen, Blue, False, points, 3)
    screen.blit(cur,(x,y))
    pygame.display.update()

            
