# Tower of Hanoi 

# 1. Move a tower of height -1 to an intermediate pole, 
# using the final pole. 
# 2. Move the remaining disk to the final pole. 
# 3. Move the tower of height -1 from the intermediate pole,
# to the final pole using the original pole. 


def moveTower(height, fromPole, toPole, withPole):

    if height >= 1:

        # here we move all but the bottom disk (height -1)
        # on the initial tower to an intermediate pole
        moveTower(height -1, fromPole, withPole, toPole)
        moveDisk(fromPole, toPole)
        # here we move the tower from the intermediate pole
        # to the top of the largest disk. 
        moveTower(height -1, withPole, toPole, fromPole)

def moveDisk(fp, tp):
    print("Moving disk from ", fp, "to ", tp)

moveTower(3, "A", "B", "C")

# moving disk from A to B
# moving disk from A to C 
# moving disk from B to C


