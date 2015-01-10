class Queue:

    def __init__(self):

        self.items = []

    def isEmpty(self):
        return self.items == []

    def enqueue(self, item):
        self.items.insert(0,item)
        # adds item to the 'rear' of items
        # although items[0] is the 1st value 
        # in the list, it is the rear of a queue. 

    def dequeue(self):
        return self.items.pop()
        # items.pop() pops the last item of the list
        # which is also the front of the queue. 

    def size(self):
        return len(self.items)

q = Queue()
q.enqueue('hello')
q.enqueue('wut')
q.enqueue(3)
q.dequeue()

