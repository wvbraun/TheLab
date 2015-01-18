from queue import Queue
import random

def hotPotato(namelist, num):

    simQueue = Queue()
    
    # for each person in namelist
    for name in namelist:
        # simQueue adds the person the the rear. 
        simQueue.enqueue(name)

    while simQueue.size() > 1:
        for i in random.randrange(num):
            simQueue.enqueue(simQueue.dequeue())

        simQueue.dequeue()

    return simQueue.dequeue()

print(hotPotato(["bill", "david", "susan", "jane", "kent", "brad"], 7))
