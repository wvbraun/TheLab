from queue import Queue
import random

class Task:

    def __init__(self, time):
        self.timeStamp = time
        self.pages = random.randrange(1,21)

    def getStamp(self):
        return self.timeStamp

    def getPages(self):
        return self.pages

    def waitTime(self, currentTime):
        return currentTime - self.timeStamp



class Printer:

    def __init__(self, ppm):

        self.pageRate = ppm
        self.currentTask = None
        self.timeRemaining = 0

    def tick(self):

        if self.currentTask != None:
            self.timeRemaining -= 1

            if self.timeRemaining <= 0:
                self.currentTask = None

    def busy(self):
        
        # if self.currentTask 
        if self.currentTask != None:
            return True
        else:
            return False

    def startNext(self, newTask):
        self.currentTask = newTask
        self.timeRemaining = newTask.getPages() * (60 / self.pageRate)

def sim(numSeconds, pagesPerMinute):

    labPrinter = Printer(pagesPerMinute)
    printQueue = Queue()
    waitingTimes = []

    for currentSecond in range(numSeconds):

        if newPrintTask():
            task = Task(currentSecond)
            printQueue.enqueue(task)


        if (not labPrinter.busy()) and (not printQueue.isEmpty()):
            nextTask = printQueue.dequeue()
            waitingTimes.append(nextTask.waitTime(currentSecond))
            labPrinter.startNext(nextTask)

        labPrinter.tick()

    averageWait = sum(waitingTimes) / len(waitingTimes)
    print("Average wait {0} secs. {.d} tasks remaining." \
                .format(averageWait, printQueue.size()))
def newPrintTask():

    num = random.randrange(1,181)
    if num == 180:
        return True
    else:
        return False

for i in range(10):
    sim(3600, 5)




