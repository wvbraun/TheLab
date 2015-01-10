# in order to implement an unordered list, we will construct 
# a linked list. 

# the basic building block for the linked list is the node. 
# each node object must hold at least 2 pieces of info. 
# 1. the item itself, we will call this the data field. 
# 2. Reference the next node. 

class Node:

    def __init__ (self, initData):
        self.data = initData
        self.next = None

    def getData(self):
        return self.data

    def getNext(self):
        return self.next

    def setData(self, newData):
        self.data = newData

    # sets self.next to newNext
    def setNext(self, newNext):
        self.next = newNext

# >>> temp = Node(93)
# >>> temp.getData()
# 93

# ----------------------------
# the unordered list class

class UnorderedList:

    # initially when we create a list, there are no items. 
    def __init__(self):
        self.head = None

    # checks to see if the head of the list is a reference to None. 
    # The result of self.head == None will only be true if there
    # are no nodes in the linked list. 
    def isEmpty(self):
        return self.head == None

    # since the list is unordered, the location of the new item
    # with respect to other items is not important. 
    # the linked list strucute provides us with only one entry
    # point, the head of the list. so we will make the new item
    # the first item of the list. 
    
    def add(self,item):
        temp = Node(item)
        # adding a new node is a 2 step process. 
        # step 1: changes the next reference of the new node
        # to refer to the old first node of the list.
        # because self.head == old head 
        temp.setNext(self.head)

        # step 2: sets the head of the list. 
        # now self.head == temp. 
        self.head = temp

    
    # linked list traversal - refers to the process of 
    # systematically visiting each node. To do this we use
    # an external reference that starts at the first node
    # in the list. As we visit each node, we move the 
    # reference to the next node by 'travesing' the next
    # reference. 

    # to implement the size method, we need to traverse the 
    # linked list and keep a count of the number of nodes that
    # occurred. 
    def size(self):

        # the external reference is called current that 
        # starts at the first node in list(self.head).
        current = self.head

        # we use count to keep track of the number of nodes
        # that occured.
        count = 0

        # these lines implement the traversal. 
        # as long as current has not seen the end 
        # of the list (None)
        while current!= None:

            # everytime current moves to a new node
            # we add 1 to count. 
            count += 1
            # we move current along to the next node
            current = current.getNext()

        
        return count

    # searching for a value also uses the traversal technique. 
    # as we visit each node in the linked list we will ask 
    # whether the data stored there matches the item we are
    # looking for. If we get to end of list, the item 
    # is not present. 
    def search(self, item):
        
        # traversal reference (current) is set to first node (self.head)
        current = self.head
        # found will 'remember' whether we have located the
        # item or not. set to false cause we havent found it yet.
        found = False

        # as long as there are more nodes to visit 
        # and we have not found the item. 
        while current != None and not found:

            # if current.getData() == item
            # we have found the item.
            if current.getData() == item:
                found = True

            # else: go to the next node.  
            else:
                current = current.getNext()

        return found


    # the remove method requires 2 steps. 
    # 1. traverse the list looking for the item 
    # we want to remove. 
    # 2. once we find the item, remove it.

    def remove(self, item):

        # 1. 
        # similar to search()
        # current = traverse reference = first node = self.head
        current = self.head
        # we assume that the item is present, thus we will
        # stop before current gets to None. 
        # previous is a traversal reference that will always
        # be one node behind current. that way when current
        # stops at the node to be removed, previous will
        # be referring to the proper place in the linked 
        # list modification. 
        # previous == None at first because there is no node
        # before the head. 
        previous = None
        found = False

        # we ask whether the item stored in currentnode
        # is the item we want to remove. 
        # if so, found == True. 
        # if not, previous and current move one node further. 
        # this process is referred to as 'inch-worming'
        while not found:
            # if current.getData == item, we found item. 
            if current.getData() == item:
                found = True
            # else: previous == current node
            # and current == next node 
            else:
                previous = current
                current = current.getNext()

        # once we find node to be removed, we remove it. 
        # but their is a special case:
        # if the item to be removed is the first item in list.
        # the current will reference the first node in the 
        # linked list. this also means that previous will 
        # be None. 

        # in the case of the special case
        # if previous did not move, it will still have the 
        # value None when found becomes True. 
        if previous == None:
            # the head of the list is modified to refer 
            # to the node after the current node, in effect 
            # remove the first node from the list. 
            self.head = current.getNext()
        
        # but if previous != None
        # the node to be removed is somewhere down the linked 
        # list structure. 
        else:
            # previous reference is providing us with the node
            # whose next reference must be changed. 
            # uses setNext to remove. 
            previous.setNext(current.getNext())



#--------------------------------------------------------
# Implementing an Ordered List
# in order to implement, we must remember that the relative
# positions of the items are based on some underlying charatersitc.
# The order list (17, 26, 31, 54, 77, 93) can be representing by
# a linked structure. 
# head -> [17][->][26][->][31][->][54][->][77][->][93][->]


class OrderedList:

    def __init__(self):
        self.head = None

    def isEmpty(self):
        return self.head == None

    def size(self):
        current = self.head
        count = 0 

        while current != None:
            count += 1 
            current = current.getNext()

        return count 

    # the search is similar to unordered except if 
    # the item is not in the list. 
    def search(self, item):

        current = self.head 
        found = False
        stop = False 

        while current != None and not found and not stop:

            if current.getData() == item:
                found = True

            else:
                # if the data is greater than item 
                # we are searching for, stop == True. 
                if current.getData() > item:
                    stop = True
                else:
                    current = current.getNext()

        return found 

    # with ordered list we have to find the specific place 
    # to add newitem 
    
    def add(self, item):

        # set up 2 traverse external references
        current = self.head
        previous = None
        stop = False

        while current != None and not stop:
            if current.getData() > item:
                stop = True

            else: 
                previous = current
                current = current.getNext()

        # once a new node has been created, we must figure
        # out whether the new node will be added at the 
        # beginning of the linked list or in middle.
        # if previous == None will give answer.

        temp = Node(item)

        if previous == None:
            temp.setNext(self.head)
            self.head = temp

        else:
            temp.setNext(current)
            previous.setNext(temp)
    
    def remove(self,item):

        current = self.head
        previous = None
        found = False

        while not found:
            if current.getData() == item:
                found = True

            else:
                previous = current
                current = current.getNext()

        if previous == None:
            self.head = current.getNext()


        else:
            previous.setNext(current.getNext())
