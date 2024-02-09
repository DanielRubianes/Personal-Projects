import random
import time


def displayIntro():
    print('You are in a land full of dragons. In fornt of you,')
    print('you see two caves. In one cave, the dragon is nice')
    print('and will share his treasure with you. The other dragon')
    print('is greeedy and hungry, and will eat you on sight')
    print()

def chooseCave():
    cave = ''
    while cave != '1' and cave != '2':
        print('Wich cave will you go in to? (1 or 2)')
        cave = input()

    return cave

def checkCave(chosenCave):
    print('you approach the cave...')
    time.sleep(2)
    print('A large dragon jumps out in front of you! He opens his jaws and...')
    print()
    time.sleep(2)

    friendlyCave = random.randint(1, 2)

    if chosenCave == str(friendlyCave):
        print('He gives you his treasure!')
    else:
        print('He gobbles you down in one bite!')

playAgain = 'yes'
while playAgain == 'yes' or playAgain == 'y':

    displayIntro()

    caveNumber = chooseCave()

    checkCave(caveNumber)

    print('Do you want to play again? (yes or no)')
    playAgain = input()

print('press enter to exit')
input()
