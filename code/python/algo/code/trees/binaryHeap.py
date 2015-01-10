

class BinHeap:

    # Since the entire binary heap can be represented by a single list, all the constructor will do is 
    # initialize the list 
    def __init__(self):
        self.heapList = [0]
        self.currentSize = 0 # keeps track of the current size of the heap. 

    def percUp(self, i):

        while i // 2 > 0: # parent node > 0 

            if self.heapList[i] < self.heapList[i // 2]: # if child node < parent node 
                tmp = self.heapList[i // 2]
                self.heapList[i // 2] = self.heapList[i]
                self.heapList[i] = tmp

            i = i // 2 

    # once a new item is inserted, percUp is used to position the new item 
    def insert(self, k):   
        self.heapList.append(k)
        self.currentSize += 1
        self.percUp(self.currentSize) 

    def percDown(self, i):

        while (i * 2) <= self.currentSize:
            mc = self.minChild(1)

            if self.heapList[i] > self.heapList[mc]:
                tmp = self.heapList[i]
                self.heapList[i] = self.heapList[mc]
                self.heapList[mc] = tmp
            i = mc

    def minChild(self, i):
        
        if (i * 2 + 1) > self.currentSize:
            return i * 2

        else:
            
            if self.heapList[i*2] < self.heapList[i * 2 + 1]:
                return i * 2
            
            else:
                return (i * 2 + 1)


