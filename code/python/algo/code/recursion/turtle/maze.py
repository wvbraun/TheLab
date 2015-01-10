import turtle

PART_OF_PATH = 'O'
TRIED = '.'
OBSTACLE = '+'
DEAD_END = '-'

class Maze:

    def __init__(self, mazeFileName):

        rowsInMaze = 0
        columnsInMaze = 0
        self.mazeList = {}
        mazeFile = open(mazeFileName, 'r')
        rowsInMaze =0
        
        for line in mazeFile:
            rowList = []
            col = 0
            for ch in line[:-1]:
                rowList.append(ch)
                if ch == 'S':
                    self.startRow = rowsInMaze
                    self.startCol = col

                col += 1 

            rowsInMaze += 1
            self.mazeList.append(rowList)
            columnsInMaze = len(rowList)

        self.rowsInMaze = rowsInMaze
        self.columnsInMaze = columnsInMaze
        self.xTranslate = -columnsInMaze / 2 
        self.yTranslate = rowsInMaze / 2
        turtle.shape('turtle')
        turtle.setup(width = 600, height = 600)
        turtle.setworldcoordinates(-(columnsInMaze -1) / 2-.5, 
                -(rowsInMaze -1) / 2 - .5,
                    (columnsInMaze -1) / 2 + .5,
                        (rowsInMaze -1) / 2 + .5)


        def drawMaze(self):
            for y in range(self.rowsInMaze):
                for x in range(self.columnsInMaze):
                    if self.mazeList[y][x] == OBSTACLE:
                        self.drawCenteredBox(x+self.xTranslate,
                                -y + self.yTranslate, 
                                'tan')

            turtle.color('black')
            turtle.fillcolor('blue')

        def drawCenteredBox(self, x, y, color):
            tracer(0)
            turtle.up()
            turtle.goto(x-.5, y-.5)
            turtle.color(color)
            turtle.fillcolor(color)
            turtle.setheading(90)
            turtle.down()
            self.t.begin_fill()
            for i in range(4):
                turtle.foward(1)
                turtle.right(90)
            turtle.end_fill()
            update()
            tracer(1)

        def moveTurtle(self, x, y):
            turtle.up()
            turtle.setheading(turtle.towards(x+self.xTranslate,
                -y + self.yTranslate))

            turtle.goto(x+self.xTranslate, -y+self.yTranslate)


        def dropBreadcrumb(self, color):
            turtle.dot(10, color)

        def updatePosition(self, row, col, val = None):

            if val:
                self.mazeList[row][col] = vale

            self.moveTurtle(col, row)

            if val == PART_OF_PATH:
                color = 'green'

            elif val == OBSTACLE:
                color = 'red'
            elif val == TRIED:
                color = 'black'
            elif val == DEAD_END:
                color = 'red'
            else:
                color = None

            if color:
                self.dropBreadcrumb(color)

        def isExit(self, row, col):

            return(row == 0 or
                    row == self.rowsInMaze-1 or
                    col == 0 or
                    col == self.columnsInMaze -1)

        def __get__item(self, idx):
            return self.mazeList[idx]



def searchFrom(maze, startRow, startColumn):

    maze.updatePosition(startRow, startColumn)

    # Check for base cases:
    # 1. We have ran into an obstacale, return false. 
    if maze[startRow][startColumn] == OBSTACLE:
        return False

    # 2. We have found a square that has already been 
    # explored. 
    if maze[startRow][startColumn] == TRIED:
        return False

    # 3. Success, an outside edge not occupied by an 
    # obstacle. 
    if maze.isExit(startRow, startColumn):
        maze.updatePosition(startRow, startColumn, PART_OF_PATH)
        return True
    maze.updatePosition(startRow, startColumn, TRIED)

    # otherwise, use logical short circuiting to try 
    # each direction in turn
    
    found = searchFrom(maze, startRow -1, startColumn) or \
            searchFrom(maze, startRow +1, startColumn) or \
            searchFrom(maze, startRow, startColumn -1) or \
            searchFrom(maze, startRow, startColumn +1)

    if found:
        maze.updatePosition(startRow, startColumn, PART_OF_PATH)

    else:
        maze.updatePosition(startRow, startColumn, DEAD_END)

    return found

myMaze = Maze('maze2.txt')
myMaze.drawMaze()
myMaze.updatePosition(myMaze.startRow, myMaze.startCol)

searchFrom(myMaze, myMaze.startRow, myMaze.startCol)
