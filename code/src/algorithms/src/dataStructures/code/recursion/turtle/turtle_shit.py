import turtle

myWin = turtle.Screen()

def drawSpiral(myTurtle, lineLen):

    if lineLen > 0:

        turtle.forward(lineLen)
        turtle.right(90)
        drawSpiral(myTurtle, lineLen - 5)

drawSpiral(myTurtle, 100)
myWin.exitonclick()
