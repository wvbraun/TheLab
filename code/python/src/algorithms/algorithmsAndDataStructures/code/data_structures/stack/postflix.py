from stack import Stack

def postfix(expression):

    # 1. create empty stack called operandStack
    operandStack = Stack()

    # 2. convert string to list w/ split. 
    tokenList = expression.split()

    # 3. scan token list from left to right. 
    for token in tokenList:

        # if token is operand, convert it from string to int
        # and push the value onto the stack.
        # since it is string, cast it to int. 
        if token in range(10):
            operandStack.push(int(token))

        # if token is an operator, it will need 2 operands. 
        # pop operandStack twice. 

        else: 
            # 1st pop is second operand
            operand2 = operandStack.pop()
            # 2nd pop is first operand 
            operand1 = operandStack.pop()

            # perfrom arithmetic
            result = doMath(token, operand1, operand2)

            # push result back on operandStack
            operandStack.push(result)

# doMath takes 2 operands and an operator

def doMatch(op, op1, op2):

    if op == "*":
        return op1 * op2 

    elif op == "/":
        return op1 / op2

    elif op == "+" :
        return op1 + op2
    else:
        return op1 - op2

print(postfix('7 8 + 3 2 + /'))
