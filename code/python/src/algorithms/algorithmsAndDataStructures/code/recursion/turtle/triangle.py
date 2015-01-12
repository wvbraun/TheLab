import turtle

def drawTriangle(points, color):

    turtle.fillcolor(color)
    turtle.up()
    turtle.goto(points[0][0], points[0][1])
    turtle.down()
    turtle.begin_fill()
    turtle.goto(points[1][0], points[1][1])
    turtle.goto(points[2][0], points[2][1])
    turtle.goto(points[0][0], points[0][1])
    turtle.end_fill()

def getMid(p1, p2):
    return ( (p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2)

def triangle(points, degree):

    colormap = ['blue', 'red', 'green', 'white', 'yellow', 
            'violet', 'orange']

    drawTriangle(points, colormap[degree])

    if degree > 0 :
        triangle([points[0], 
            getMid(points[0], points[1]), 
            getMid(points[0], points[2])], degree - 1)

        triangle([points[1],
            getMid(points[0], points[1]),
            getMid(points[1], points[2])], degree - 1)

        triangle([points[2], 
            getMid(points[2], points[1]), 
            getMid(points[0], points[2])], degree - 1)

def main():

    myPoints = [[-100, -50], [0, 100], [100, -50]]
    triangle(myPoints, 3)
    turtle.exitonclick()

main()
