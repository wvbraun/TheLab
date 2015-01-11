import sys


# this helped tanner for his exam

scores = []
names = []

players = []

def playerScore():

    print("Enter the player name or 'END'")
    name = raw_input("> ")

    if name == 'END':
        players = zip(names, scores)
        print(players)

        for i in range(len(players)):
            name, score = players[i]
            players[i] = (score, name)

        players.sort(reverse=True)

        for i in range(len(players)):
            score, name = players[i]
            players[i] = (name, score)

        print("=========================")

        for name, score in players:
            print "\t", name, "\t",score
       
    else:
        names.append(name)
        print "\nEnter the player score"
        score = int(raw_input("> "))
        print "-----------\n"
        scores.append(score)
        playerScore()



print playerScore()
