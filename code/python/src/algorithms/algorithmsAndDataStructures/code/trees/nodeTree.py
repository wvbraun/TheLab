

class BinaryTree:

    def __init__(self, rootObj):

        self.key = rootObj
        self.leftChild = None
        self.rightChild = None 

# we must consider two cases for insertion. 
    def insertLeft(self, newNode):

        # 1st case - characterized by a node with no existing left child
        # When there is no left child, simply add a node to the tree. 
        if self.leftChild == None:
            self.leftChild = BinaryTree(newNode)

        # 2nd case - characterized by a node with an exisiting left child
        # We insert a node and push the existing child down one level in the tree. 
        else:
            t = BinaryTree(newNode)
            t.leftChild = self.leftChild
            self.leftChild = t

    def insertRight(self, newNode):

        if self.rightChild == None:
            self.rightChild = BinaryTree(newNode)

        else:
            t = BinaryTree(newNode)
            t.rightChild = self.rightChild
            self.rightChild = t

    
    def getRightChild(self):
        return self.rightChild

    def getLeftChild(self):
        return self.leftChild

    def setRootVal(self, obj):
        self.key = obj

    def getRootVal(self):
        return self.key

    def preorder(self):
        print(self.key)

        if self.leftChild:
            self.left.preorder()
        
        if self.rigthChild:
            self.right.preorder()

    def postorder(self):

        if self.leftChild:
            self.left.postorder()

        if self.rightChild:
            self.right.postorder()

        print(self.key)

        

r = BinaryTree('a')
print(r.getRootVal()) # this returns self.key, which is currently 'a'
#>>> a
print(r.getLeftChild()) # this returns self.leftChild, which is currently None
#>>> None 
r.insertLeft('b') # since self.leftChild == None, this creates a new BinaryTree with 'b'
print(r.getLeftChild()) # returns mem location of self.leftChild
#>>> <__main__.BinaryTree object at 0x7fa910973c90>
print(r.getLeftChild().getRootVal()) # returns the value of self.leftChild
#>>> b                               # since r.insertLeft created a new BinaryTree w/ value b
                                     # this is the self.key of the new binary tree
r.insertRight('c')
print(r.getRightChild())
#>>> <__main__.BinaryTree object at 0x7f0aa0cf0cd0>
print(r.getRightChild().getRootVal())
#>>> c
r.getRightChild().setRootVal('hello') # this sets the right child of the 'a' node   
                                      # to have the value 'hello'
print(r.getRightChild().getRootVal())
#>>> hello


# ------------------------------------------------------------------------------------------------
# 
print("-------------------------")

def buildTree():

    one = BinaryTree('a')
    one.insertLeft('b')
    one.getLeftChild().insertRight('d')
    
    one.insertRight('c')
    one.getRightChild().insertLeft('e')
    one.getRightChild().insertRight('f')

    print(one.getRootVal()) # a
    print(one.getLeftChild().getRootVal()) # b
    print(one.getLeftChild().getRightChild().getRootVal()) # d

    print(one.getRightChild().getRootVal()) # c
    print(one.getRightChild().getLeftChild().getRootVal()) # e
    return(one.getRightChild().getRightChild().getRootVal()) # f

print(buildTree())


