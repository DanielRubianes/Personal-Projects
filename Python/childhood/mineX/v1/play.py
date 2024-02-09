print('---------------------------------DEBUG CONSOLE---------------------------------')
print('project mineX V1')
bis=''
debug=False
from classes import *
print('imported pygame')
#startup start
print('starting...')
pygame.init()
pygame.joystick.init()
#set vars
Px=0
Py=340
LRUDp=''
JHeight=0
state=''
jump=''
cmdText=''
backsp=''
screenShot=0
InElv=False
command=''
konami=''
PS='R'
CNum=0
playerTime=0
menu=True
play=False
COn1=True
PickWoodOn=True
pickHeld=''
STSound='1'
STSoundChange=False
credit=False
newgame=True
console=False
options=False
click=False
MAIN=True
output=''
commandInp=''
music=False
musicPlaying=False
grav=True
Walk='yes'
text=''
level='L1, 1x1'
keycode=''
print('variables set')
#clock
clock=pygame.time.Clock()
fps=400
print('clock started')
#load bg
if bis=='':
    bis='bg.jpg'
bif=pygame.image.load(bis)
print('loaded background')
#set screen
screen = pygame.display.set_mode(bif.get_size())
print('display set: ' + str(screen))
pygame.transform.set_smoothscale_backend('SSE')
#terain load
from terain_Blocks import *
#icon
icon=pygame.image.load("icon.png").convert_alpha()
pygame.display.set_icon(icon)
print('icon displayed')
#set screen
pygame.display.set_caption('project mineX V1')
print('caption set')
#bg
bg=bif.convert()
#sprites
print('loading player.png...')
player=pygame.image.load('sprites/player.png').convert_alpha()
print('loading playerBack.png...')
playerR=pygame.image.load('sprites/playerBack.png').convert_alpha()
print('loading playerFR2.png')
playerFR2=pygame.image.load('sprites/playerFR2.png').convert_alpha()
print('loading playerBackFR2.png...')
playerRFR2=pygame.image.load('sprites/playerBackFR2.png').convert_alpha()

print('loading playerWoodPick.png...')
playerWood=pygame.image.load('sprites/playerWoodPick.png').convert_alpha()
print('loading playerBackWoodPick.png...')
playerRWood=pygame.image.load('sprites/playerBackWoodPick.png').convert_alpha()
print('loading playerFR2WoodPick.png')
playerFR2Wood=pygame.image.load('sprites/playerFR2WoodPick.png').convert_alpha()
print('loading playerBackFR2WoodPick.png...')
playerRFR2Wood=pygame.image.load('sprites/playerBackFR2WoodPick.png').convert_alpha()

print('loading coal.png..')
coal=pygame.image.load("sprites/coal.png").convert_alpha()
print('loading pickItem.png..')
pickWood=pygame.image.load("sprites/pickItem.png").convert_alpha()

print('loaded sprites')
#load bg
screen.blit(bg, (0, 0))
pygame.display.update()
print('background loaded')
#colors
red=(255, 0, 0)
blue=(0, 0, 255)
green=(0, 255, 0)
white=(255, 255, 255)
black=(0, 0, 0)
print('colors loaded')
#fonts
font = pygame.font.SysFont("agent orange", 60)
fontSmall = pygame.font.SysFont("agent orange", 20)
fontMedSmall = pygame.font.SysFont("agent orange", 30)
fontMed= pygame.font.SysFont("agent orange", 40)
print('fonts loaded')
print('done!')
#startup fin
#main loop
while MAIN:
    #title
    while menu:
        #blit the bg
        screen.blit(bg, (0, 0))
        #display the text
        mpos=pygame.mouse.get_pos()
        if mpos[0]>33 and mpos[1]>260 and mpos[0]<129 and mpos[1]<292:
            displaytext(font, "Start", 80, 280, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                menu=False
                play=True
                startSong('music/track1.ogg')
                musicPlaying=True
        else:
            displaytext(font, "Start", 80, 280, 0, 128, 0, screen)
        displaytext(fontMed, "project mineX V1", 430, 64, 255, 0, 0, screen)
        mpos=pygame.mouse.get_pos()
        
        if mpos[0]>27 and mpos[1]>332 and mpos[0]<190 and mpos[1]<372:
            displaytext(font, "Options", 109, 350, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                menu=False
                options=True
        else:
            displaytext(font, "Options", 109, 350, 0, 128, 0, screen)

            
        if mpos[0]>27 and mpos[1]>411 and mpos[0]<145 and mpos[1]<445:
            displaytext(font, "Music", 87, 430, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                menu=False
                music=True
        else:
            displaytext(font, "Music", 87, 430, 0, 128, 0, screen)


        if mpos[0]>36 and mpos[1]>476 and mpos[0]<122 and mpos[1]<514:
            displaytext(font, "Quit", 80, 499, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                print('stoping...')
                MAIN=False
                menu=False
                
        else:
            displaytext(font, "Quit", 80, 499, 0, 128, 0, screen)

        if mpos[0]>690 and mpos[1]>8 and mpos[0]<790 and mpos[1]<30:
            displaytext(fontMed, "Credits", 740, 20, 200, 0, 255, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                menu=False
                credit=True
                playSound('sounds/click.ogg')
                
        else:
            displaytext(fontMed, "Credits", 740, 20, 0, 0, 255, screen)




            

        if debug:
            if pygame.mouse.get_focused():
                numText = str(pygame.mouse.get_pos())
                displaytext(fontMed, numText, 80, 60 , 255, 255, 255, screen)



        pygame.display.flip()
        clock.tick(60)
        #display version and menu text
        for event in pygame.event.get():
            if event.type == QUIT :
                MAIN=False
                menu=False
                print('stoping...')
            if event.type == KEYDOWN:
                if event.key==K_ESCAPE:
                    print('stoping...')
                    MAIN=False
                    menu=False
                if event.key==K_c:
                    print('entering console...')
                    menu=False
                    console=True
        pygame.display.update()
    
    #options menu
    while options:
        #diplay the text
        mpos=pygame.mouse.get_pos()
        #blit the bg
        screen.blit(bg, (0, 0))
        #display the text
        mpos=pygame.mouse.get_pos()
        if debug==False:
            if mpos[0]>298 and mpos[1]>181 and mpos[0]<562 and mpos[1]<224:
                displaytext(font, "debugger:off", 430, 200, 255, 0, 0, screen)
                if pygame.mouse.get_pressed()==(1, 0, 0) and click==False:
                    click=True
                if pygame.mouse.get_pressed()==(0, 0, 0) and click==True:
                    playSound('sounds/click.ogg')
                    debug=True
                    click=False
            else:
                displaytext(font, "debugger:off", 430, 200, 0, 128, 0, screen)
        if debug==True:
            if mpos[0]>298 and mpos[1]>181 and mpos[0]<562 and mpos[1]<224:
                displaytext(font, "debugger:on", 430, 200, 255, 0, 0, screen)
                if pygame.mouse.get_pressed()==(1, 0, 0) and click==False:
                    click=True
                if pygame.mouse.get_pressed()==(0, 0, 0) and click==True:
                    playSound('sounds/click.ogg')
                    debug=False
                    click=False
            else:
                displaytext(font, "debugger:on", 430, 200, 0, 128, 0, screen)



        if musicPlaying:
            if mpos[0]>340 and mpos[1]>240 and mpos[0]<523 and mpos[1]<272:
                displaytext(font, "Music:on", 430, 260, 255, 0, 0, screen)
                if pygame.mouse.get_pressed()==(1, 0, 0) and click==False:
                    musicPlaying=False
                    pygame.mixer.music.stop()
            else:
                displaytext(font, "Music:on", 430, 260, 0, 128, 0, screen)
        else:
            displaytext(font, "Music:off", 430, 260, 0, 128, 0, screen)



                
                
        
        if mpos[0]>383 and mpos[1]>117 and mpos[0]<480 and mpos[1]<151:
            displaytext(font, "Back", 430, 140, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                options=False
                menu=True
        else:
            displaytext(font, "Back", 430, 140, 0, 128, 0, screen)
        displaytext(fontMed, "Options", 430, 64, 186, 50, 203, screen)
        mpos=pygame.mouse.get_pos()
        if debug:
            if pygame.mouse.get_focused():
                numText = str(mpos)
                displaytext(fontMed, numText, 80, 60 , 255, 255, 255, screen)
        #key detection
        for event in pygame.event.get():
            if event.type == QUIT :
                MAIN=False
                options=False
                print('stoping...')
            if event.type == KEYDOWN:
                if event.key==K_ESCAPE:
                    options=False
                    menu=True
        pygame.display.flip()
        pygame.display.update()

    #music menu
    while music:
        #blit the bg
        screen.blit(bg, (0, 0))
        #diplay the text
        mpos=pygame.mouse.get_pos()
        if mpos[0]>589 and mpos[1]>180 and mpos[0]<725 and mpos[1]<214:
            displaytext(font, "Track 1", 660, 200, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                startSong('music/track1.ogg')
                musicPlaying=True
        else:
            displaytext(font, "Track 1", 660, 200, 0, 128, 0, screen)

        if mpos[0]>589 and mpos[1]>240 and mpos[0]<732 and mpos[1]<273:
            displaytext(font, "Track 2", 660, 260, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                startSong('music/track2.ogg')
                musicPlaying=True
        else:
            displaytext(font, "Track 2", 660, 260, 0, 128, 0, screen)

        if mpos[0]>589 and mpos[1]>301 and mpos[0]<729 and mpos[1]<333:
            displaytext(font, "Track 3", 660, 320, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                startSong('music/track3.ogg')
                musicPlaying=True
        else:
            displaytext(font, "Track 3", 660, 320, 0, 128, 0, screen)


        displaytext(fontMed, "Music", 45, 20, 186, 50, 203, screen)
        

        if mpos[0]>611 and mpos[1]>117 and mpos[0]<709 and mpos[1]<153:
            displaytext(font, "Back", 660, 140, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                music=False
                menu=True
        else:
            displaytext(font, "Back", 660, 140, 0, 128, 0, screen)
        if debug:
            if pygame.mouse.get_focused():
                numText = str(mpos)
                displaytext(fontMed, numText, 80, 60 , 255, 255, 255, screen)
        #key detection
        for event in pygame.event.get():
            if event.type == QUIT :
                MAIN=False
                music=False
                print('stoping...')
            if event.type == KEYDOWN:
                if event.key==K_ESCAPE:
                    music=False
                    menu=True
        pygame.display.flip()
        pygame.display.update()


    #credits
    while credit:
        #blit the bg
        screen.blit(bg, (0, 0))
        #diplay the text
        mpos=pygame.mouse.get_pos()
        #blit the bg
        screen.blit(bg, (0, 0))
        #display the text
        mpos=pygame.mouse.get_pos()
        


        
        displaytext(font, "Sound: mark Rubianes", 430, 200, 0, 0, 255, screen)


        displaytext(font, "Music: nosoapradio.us", 430, 260, 0, 0, 255, screen)


        displaytext(font, "code: danda9478", 430, 320, 0, 0, 255, screen)

                
                
        
        if mpos[0]>383 and mpos[1]>117 and mpos[0]<480 and mpos[1]<151:
            displaytext(font, "Back", 430, 140, 255, 0, 0, screen)
            if pygame.mouse.get_pressed()==(1, 0, 0):
                playSound('sounds/click.ogg')
                credit=False
                menu=True
        else:
            displaytext(font, "Back", 430, 140, 0, 128, 0, screen)
        displaytext(fontMed, "Credits", 430, 64, 186, 50, 203, screen)
        mpos=pygame.mouse.get_pos()
        if debug:
            if pygame.mouse.get_focused():
                numText = str(mpos)
                displaytext(fontMed, numText, 80, 60 , 255, 255, 255, screen)
        #key detection
        for event in pygame.event.get():
            if event.type == QUIT :
                MAIN=False
                credit=False
                print('stoping...')
            if event.type == KEYDOWN:
                if event.key==K_ESCAPE:
                    credit=False
                    menu=True
        pygame.display.flip()
        pygame.display.update()




    #play loop
    while play:
        #clock
        milli=clock.tick()
        sec=milli/1000.
        dm=sec*fps
        #block display
        #rects
        PRect = pygame.Rect((Px,Py),(60,80))
        CRect1 = pygame.Rect((300,400), (40,20))
        PickWoodRect = pygame.Rect((300,403), (14, 17))
        ETopRect = pygame.Rect((720,300),(80,20))
        EMainRect = pygame.Rect((720,300),(80,120))
        #level
        terainBlocks(level, screen)
        #debug rect
        if debug:
            pygame.draw.rect(screen, white, PRect)
            if level=='testing' and COn1==True:
                pygame.draw.rect(screen, white, CRect1)
            if level=='L1, 1x3' and PickWoodOn==True:
                pygame.draw.rect(screen, white, PickWoodRect)
            if level=='L1, 1x3':
                pygame.draw.rect(screen, red, ETopRect)
                pygame.draw.rect(screen, blue, EMainRect)
        #key codes
        if len(keycode)>20:
            keycode=''
        if keycode=='UUDDLRLRSPACE':
            keycode=''
            konami=True
            play=False
        #Rectangle detection
        screen.blit(coal,(720,-3))
        displaytext(fontMed, str(CNum), 775, 30, 255, 255, 255, screen)
        if level == 'testing' and COn1==True:
            screen.blit(coal,(300,380))
        if level == 'L1, 1x3' and PickWoodOn==True:
            screen.blit(pickWood,(300,403))
        if PRect.colliderect(CRect1) and COn1==True and level=='testing':
            COn1=False
            CNum+=1
            playSound('sounds/pickup.ogg')
        if PRect.colliderect(PickWoodRect) and PickWoodOn==True and level=='L1, 1x3':
            PickWoodOn=False
            pickHeld='wooden'
            playSound('sounds/pickup.ogg')
        if PRect.colliderect(ETopRect) and Px>662 and level=='L1, 1x3':
            grav=True
            jump=''
        if PRect.colliderect(EMainRect) and Px>662 and level=='L1, 1x3':
            InElv=True
        else:
            InElv=False
        #player
        playerTime+=dm
        if jump=='U':
            if JHeight<Py:
                Py-=dm
                grav=False
            if JHeight>Py:
                grav=True
                jump=''
        if 0>Px and level=='L1, 1x1':
            Px+=dm
        if 780<Px+60 and level=='L1, 1x3':
            Px-=dm
        if 780<Px+60 and level=='L1, 2x3':
            Px-=dm
        if jump=='':
            grav=True
        if Py==340:
            state='G'
        if Py<340:
            state='A'
        if grav:
            Py+=dm
        if Py>340:
            Py=340
        if level=='L1, 1x1':
            if Px>800:
                level='L1, 1x2'
                Px=0
        if level=='L1, 1x2':
            if Px>800:
                level='L1, 1x3'
                Px=0
        if level=='L1, 1x2':
            if Px<0:
                level='L1, 1x1'
                Px=799
        if level=='L1, 1x3':
            if Px<0:
                level='L1, 1x2'
                Px=799
        if LRUDp=='R':
            Px+=dm
        if LRUDp=='L':
            Px-=dm
        #sprites
        if PS=='RM':
            if playerTime>70 and Walk=='no':
                Walk='yes'
                playerTime=0
                if state=='G':
                    STSoundChange=True
                    if STSound=='1' and STSoundChange==True:
                        playSound("sounds/stepgrass1.ogg")
                        STSound='2'
                        STSoundChange=False
                    if STSound=='2' and STSoundChange==True:
                        playSound("sounds/Stepgrass2.ogg")
                        STSound='1'
                        STSoundChange=False
            if playerTime>70 and Walk=='yes':
                Walk='no'
                playerTime=0
            if Walk=='no':
                screen.blit(player, (Px,Py))
                if pickHeld=='wooden':
                    screen.blit(playerWood, (Px,Py))
            if Walk=='yes':
                screen.blit(playerFR2, (Px,Py))
                if pickHeld=='wooden':
                    screen.blit(playerFR2Wood, (Px,Py))
        if PS=='LM':
            if playerTime>70 and Walk=='no':
                Walk='yes'
                playerTime=0
                if state=='G':
                    STSoundChange=True
                    if STSound=='1' and STSoundChange==True:
                        playSound("sounds/stepgrass1.ogg")
                        STSound='2'
                        STSoundChange=False
                    if STSound=='2' and STSoundChange==True:
                        playSound("sounds/Stepgrass2.ogg")
                        STSound='1'
                        STSoundChange=False
            if playerTime>70 and Walk=='yes':
                Walk='no'
                playerTime=0
            if Walk=='no':
                screen.blit(playerR, (Px,Py))
                if pickHeld=='wooden':
                    screen.blit(playerRWood, (Px, Py))
            if Walk=='yes':
                screen.blit(playerRFR2, (Px,Py))
                if pickHeld=='wooden':
                    screen.blit(playerRFR2Wood, (Px, Py))
        if PS=='R':
            screen.blit(player, (Px,Py))
            if pickHeld=='wooden':
                screen.blit(playerWood, (Px,Py))
        if PS=='L':
            screen.blit(playerR, (Px,Py))
            if pickHeld=='wooden':
                screen.blit(playerRWood, (Px, Py))
        #diplay all text
        mpos=pygame.mouse.get_pos()
        playerDebug='(' + str(int(Px)) + ',' + str(int(Py)) + ')'
        if debug:
            if pygame.mouse.get_focused():
                numText = str(mpos)
                displaytext(fontMed, numText, 80, 20 , 255, 255, 255, screen)
            displaytext(fontMed, playerDebug, 80, 50, 255, 255, 255, screen)
        if level=='L1, 1x1':
            displaytext(font, "press a and d to move around", 400, 100, 0, 0, 255, screen)
            displaytext(font, "and press w to jump", 400, 200, 0, 0, 255, screen)
        #say that the game has started
        if newgame:
            print('game started')
            newgame=False
        #key detection (events)
        for event in pygame.event.get():
            if event.type == QUIT:
                MAIN=False
                play=False
                print('stoping...')
            if event.type == KEYDOWN:
                if event.key==K_F2:
                    screenShot+=1
                    pygame.image.save(screen, 'shot' + str(screenShot) + '.png')
                    print('captured screen as "shot' + str(screenShot) + '.png"')
                if event.key==K_d:
                    keycode+='R'
                    LRUDp='R'
                    PS='RM'
                if event.key==K_a:
                    keycode+='L'
                    LRUDp='L'
                    PS='LM'
                if event.key==K_w:
                    if keycode!='U':
                        keycode=''
                    keycode+='U'
                if event.key==K_s:
                    keycode+='D'
                if event.key==K_q:
                    keycode=''
                if event.key==K_F3 and debug==True:
                    debug=False
                elif event.key==K_F3 and debug==False:
                    debug=True
                if event.key==K_w:
                    if state=='G':
                        JHeight=Py-80
                        jump='U'
                if event.key==K_l:
                    print(state)
                if event.key==K_SPACE:
                    keycode+='SPACE'
                if event.key==K_F11:
                    full=pygame.display.toggle_fullscreen()
                    print(str(full))
                if event.key==K_DOWN and InElv==True:
                    level='L1, 2x3'
                print(keycode)
            if event.type == KEYUP:
                if event.key==K_d and LRUDp=='R':
                    LRUDp=''
                    PS='R'
                if event.key==K_a and LRUDp=='L':
                    LRUDp=''
                    PS='L'
                if event.key==K_w or event.key==K_SPACE:
                    grav=True
                    jump=''
                if event.key==K_ESCAPE:
                    play=False
                    menu=True
                    musicPlaying=False
                    pygame.mixer.music.stop()
        pygame.display.flip()
        pygame.display.update()
    
    if konami:
        #blit the bg
        screen.blit(bg, (0, 0))
        #display the text
        displaytext(font, "command:" + cmdText, 400, 100, 0, 0, 255, screen)
        displaytext(fontMedSmall, output, 400, 150, 0, 0, 255, screen)
        displaytext(fontMedSmall, "type 'back' to exit", 400, 50, 0, 0, 255, screen)
        #make the command text not go off the screen
        if len(cmdText)>26:
            cmdText=''
        for event in pygame.event.get():
            if event.type == QUIT :
                main=False
                konami=False
                print('stoping...')
            if event.type == KEYDOWN:
                if event.key==K_BACKSPACE:
                    cmdText=''
                if event.key==K_a:
                    cmdText+='a'
                if event.key==K_b:
                    cmdText+='b'
                if event.key==K_c:
                    cmdText+='c'
                if event.key==K_d:
                    cmdText+='d'
                if event.key==K_e:
                    cmdText+='e'
                if event.key==K_f:
                    cmdText+='f'
                if event.key==K_g:
                    cmdText+='g'
                if event.key==K_h:
                    cmdText+='h'
                if event.key==K_i:
                    cmdText+='i'
                if event.key==K_j:
                    cmdText+='j'
                if event.key==K_k:
                    cmdText+='k'
                if event.key==K_l:
                    cmdText+='l'
                if event.key==K_m:
                    cmdText+='m'
                if event.key==K_n:
                    cmdText+='n'
                if event.key==K_o:
                    cmdText+='o'
                if event.key==K_p:
                    cmdText+='p'
                if event.key==K_q:
                    cmdText+='q'
                if event.key==K_r:
                    cmdText+='r'
                if event.key==K_s:
                    cmdText+='s'
                if event.key==K_t:
                    cmdText+='t'
                if event.key==K_u:
                    cmdText+='u'
                if event.key==K_v:
                    cmdText+='v'
                if event.key==K_w:
                    cmdText+='w'
                if event.key==K_x:
                    cmdText+='x'
                if event.key==K_y:
                    cmdText+='y'
                if event.key==K_z:
                    cmdText+='z'
                if event.key==K_RETURN:
                    command=cmdText
                    cmdText=''
            if event.type == KEYUP:
                loop="keep"
        

        while command=='warp':
            #blit the bg
            screen.blit(bg, (0, 0))
            #display the text
            displaytext(font, "warp:" + cmdText, 400, 100, 0, 0, 255, screen)
            displaytext(fontMedSmall, "please enter your warp", 400, 150, 0, 0, 255, screen)
            displaytext(fontMedSmall, "", 400, 50, 0, 0, 255, screen)
            #make the command text not go off the screen
            if len(cmdText)>26:
                cmdText=''
            for event in pygame.event.get():
                if event.type == QUIT :
                    MAIN=False
                    command=''
                    konami=False
                    print('stoping...')
                if event.type == KEYDOWN:
                    if event.key==K_BACKSPACE:
                        cmdText=''
                    if event.key==K_a:
                        cmdText+='a'
                    if event.key==K_b:
                        cmdText+='b'
                    if event.key==K_c:
                        cmdText+='c'
                    if event.key==K_d:
                        cmdText+='d'
                    if event.key==K_e:
                        cmdText+='e'
                    if event.key==K_f:
                        cmdText+='f'
                    if event.key==K_g:
                        cmdText+='g'
                    if event.key==K_h:
                        cmdText+='h'
                    if event.key==K_i:
                        cmdText+='i'
                    if event.key==K_j:
                        cmdText+='j'
                    if event.key==K_k:
                        cmdText+='k'
                    if event.key==K_l:
                        cmdText+='l'
                    if event.key==K_m:
                        cmdText+='m'
                    if event.key==K_n:
                        cmdText+='n'
                    if event.key==K_o:
                        cmdText+='o'
                    if event.key==K_p:
                        cmdText+='p'
                    if event.key==K_q:
                        cmdText+='q'
                    if event.key==K_r:
                        cmdText+='r'
                    if event.key==K_s:
                        cmdText+='s'
                    if event.key==K_t:
                        cmdText+='t'
                    if event.key==K_u:
                        cmdText+='u'
                    if event.key==K_v:
                        cmdText+='v'
                    if event.key==K_w:
                        cmdText+='w'
                    if event.key==K_x:
                        cmdText+='x'
                    if event.key==K_y:
                        cmdText+='y'
                    if event.key==K_z:
                        cmdText+='z'
                    if event.key==K_1:
                        cmdText+='1'
                    if event.key==K_2:
                        cmdText+='2'
                    if event.key==K_3:
                        cmdText+='3'
                    if event.key==K_4:
                        cmdText+='4'
                    if event.key==K_5:
                        cmdText+='5'
                    if event.key==K_6:
                        cmdText+='6'
                    if event.key==K_7:
                        cmdText+='7'
                    if event.key==K_8:
                        cmdText+='8'
                    if event.key==K_9:
                        cmdText+='9'
                    if event.key==K_0:
                        cmdText+='0'
                    if event.key==K_COMMA:
                        cmdText+=','
                    if event.key==K_RETURN:
                        commandInp=cmdText
                        cmdText=''


            if commandInp=='l1,1x1':
                level='L1, 1x1'
                commandInp=''
                command=''
                output='warped to ' + level
            if commandInp=='l1,1x2':
                level='L1, 1x2'
                commandInp=''
                command=''
                output='warped to ' + level
            if commandInp=='l1,1x3':
                level='L1, 1x3'
                commandInp=''
                command=''
                output='warped to ' + level
            if commandInp=='empty':
                level=commandInp
                commandInp=''
                command=''
                output='warped to ' + level
            if commandInp=='testing':
                level=commandInp
                pygame.mixer.stop()
                commandInp=''
                command=''
                output='warped to testing'
            pygame.display.update()
        if command=='back':
            konami=False
            play=True
            command=''
        elif command=='sys':
            output='N.Y.I.'
            command=''
        elif command=='bullettime':
            output='slowmo activated'
            fps=20
            command=''
        elif command=='normaltime':
            output='normal time resumed'
            fps=400
            command=''
        elif command=='resetcoal':
            CNum=0
            COn1=True
            output='coal reset'
            command=''
        else:
            if command!='':
                output='invalid command!'
                command=''
            
            
        pygame.display.flip()
        pygame.display.update()
pygame.quit()
