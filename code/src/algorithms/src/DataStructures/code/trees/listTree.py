
# BinaryTree() constructs a list with a root node and 2 empty sublists for the children. 
# to add a left subtree to the root of the tree, we need to insert a new list into the 2nd position
# of the root list. 
def BinaryTree(r):

    return [r, [], []]


def insertLeft(root, newBranch):

    t = root.pop(1) # obtain the list corresponding to the current left child 
    
    if len(t) > 1:
        root.insert(1, [newBranch, t, []])

    else: 
        root.insert(1, [newBranch, [], []])

    return root

def insertRight(root, newBranch):

    t = root.pop(2)

    if len(t) > 1:
        root.insert(2, [newBranch, [], t])

    else: 
        root.insert(2, [newBranch, [], []])

    return root

def getRootVal(root):
    return root[0]

def setRootVal(root, newVal):

    root[0] = newVal

def getLeftChild(root):
    return root[1]

def getRightChild(root):
    return root[2]

r = BinaryTree(3)
insertLeft(r, 4)
insertLeft(r, 5)
insertRight(r, 6)
insertRight(r, 7)
l = getLeftChild(r)
print(l)


setRootVal(l, 9)
print(r)
insertLeft(l, 11)
print(r)
print(getRightChild(getRightChild(r)))


def buildTree():

    x = BinaryTree('a')
    insertLeft(x, 'b')
    insertLeft(getLeftChild(x), 'd')
    insertRight(x, 'c')
    insertRight(insertLeft(getRightChild(x), 'e'))
    insertRight(insertRight(getRightChild(x), 'f'))

print(buildTree())
