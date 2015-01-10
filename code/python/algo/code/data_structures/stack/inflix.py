from stack import Stack 
import string

def inflix(expression):

    # prec contains the precedence values of the operators.
    # they are arbitrary values
    prec = {
            "*" : 3,
            "/" : 3,
            "+" : 2,
            "-" : 2,
            "(" : 1
    }

    # empty stack for keep operators
    opStack = Stack()

    # empty list for output 
    postList = []
    # splits 'expressions'
    tokenList = expression.split()

    for token in tokenList:

        # if token is an operand append it to end of postList
        if token in string.ascii_uppercase or token in range(10):
            postList.append(token)

        # if token is a left parenthesis, push it on opStack
        # which adds item to top of stack.
        elif token == '(':
            opStack.push(token)

        # if token is right parenthesis, it pops opStack
        # until its left paranthesis is removed. 
        elif token == ')':
            topToken = opStack.pop()

            # append each operator to end of output list. 
            while topToken != '(':
                postList.append(topToken)
                topToken = opStack.pop()

        else:

            while(not opStack.isEmpty()) and \
                    prec[opStack.peek()] >= prec[token]:

                        postList.append(opStack.pop())
            opStack.push(token)

    while not opStack.isEmpty():
        postList.append(opStack.pop())
    return " ".join(postList)

print(inflix("A * B + C * D"))
print(inflix(" ( A + B ) * C - ( D - E ) * ( F + G )"))

