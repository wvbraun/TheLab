from stack import Stack
from nodeTree import BinaryTree

def buildParseTree(exp):

    exp_list = exp.split() # creates a list of the tokens
    pStack = Stack()
    eTree = BinaryTree('')
    pStack.push(eTree)
    currentTree = eTree
    ops = ['+', '-', '*', '/']

    for i in exp_list:

        if i == '(':
            currentTree.insertLeft('')
            pStack.push(currentTree) 
            currentTree = currentTree.getLeftChild()

        elif i not in ops and i != ')':
            currentTree.setRootVal(int(i)) # cause its an operand
            parent = pStack.pop()
            currentTree = parent

        elif i in ops:
            currentTree.setRootVal(i)
            currentTree.insertRight('')
            pStack.push(currentTree)
            currentTree = currentTree.getRightChild()

        elif i == ')':
            currentTree = pStack.pop()

        else: # if we get a token that we do not recognize 
            raise ValueError

    return eTree

pt = buildParseTree("( ( 10 + 5 ) * 3 )")
pt.postorder()

# evaluate: first we obtain references to the left and right children of the current node.
# if both the left and right children evaluate to None, then we know that the current node
# is really a leaf node. If the current node is not a leaf node, look up the operator in the 
# current node and apply it to the results from recursively evaluating the left and right 
# children. 

# when we first call evaluate, we pass the root of the entire tree as the parameter
def evaluate(parseTree):

    # ops['+'](2,2) == operator.add(2,2)
    ops = {'+':operator.add, '-':operator.sub, '*':operator.mul, '/':operator.truediv}
    
    # then we obtain refernces to the left and right children to make sure they exist 
    leftC = parseTree.getLeftChild()
    rightC = parseTree.getRightChild()

    if leftC and rightC:

        fn = ops[parseTree.getRootVal()]
        return fn(evaluate(leftC), evaluate(rightC)) 
    

    else: 
        return parseTree.getRootVal()


# preorder tree traversal 

def preorder(tree):
    
    if tree:
        print(tree.getRootVal())
        preorder(tree.getLeftChild())
        preorder(tree.getRightChild())


def postorder(tree):

    if tree != None: # same as if tree:
        postorder(tree.getLeftChild())
        postorder(tree.getRightChild())
        print(tree.getRootVal())

def postordereval(tree):

    ops = {'+':operator.add, '-':operator.sub, '*':operator.mul, '/':operator.truediv}

    res1 = None
    res2 = None

    if tree:
        res1 = postordereval(tree.getLeftChild())
        res2 = postordereval(tree.getRightChild())

        if res1 and res2:
            return ops[tree.getRootVal()](res1, res2)

        else:
            return tree.getRootVal()

def inorder(tree):

    if tree != None:
        inorder(tree.getLeftChild())
        print(tree.getRootVal())
        inorder(tree.getRightChild)

def printexp(tree):

    sVal = ""

    if tree:
        sVal = '(' + printexp(tree.getLeftChild())
        sVal = sVal + str(tree.getRootVal())
        sVal = sval + printexp(tree.getRightChild()) + ')'

    return sVal
    

