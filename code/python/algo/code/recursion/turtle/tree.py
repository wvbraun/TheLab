import turtle
import random

def tree(branchLen):

    # base case
    if branchLen > 5:

        angle = random.randrange(15,45)
        turtle.forward(branchLen)
        # right 20 degrees
        turtle.right(45)
        tree(branchLen- 15)
        # left by 40 bc we went right by 20. 
        turtle.left(90)
        tree(branchLen - 15)
        turtle.right(45)
        turtle.backward(branchLen)

def main():
    
    turtle.left(90)
    turtle.up()
    turtle.backward(100)
    turtle.down()
    turtle.color("blue")
    tree(75)
    turtle.exitonclick()

main()
