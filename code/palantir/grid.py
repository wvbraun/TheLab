import fileinput
import sys
import Queue


def totalTime(mat, paths):
    tot = 0

    for path in paths:
        x = path[0]
        y = path[1]
        tot += mat[x][y]

    return(tot)

def avgTime(total, n):
    return (total / n)


def main():
    ls = []

    for line in fileinput.input(sys.argv[1]):
        ls.append(line)

    m = int(ls[0].split()[0])
    n = int(ls[0].split()[1])

    del ls[0]

    i = 0
    matls = []

    while (i < m):
        j = 0
        newls = ls[i].split()

        while (j < n):
            newls[j] = int(newls[j])
            j += 1

        matls.append(newls)
        i += 1

    i = 0
    while (i < m):
        del ls[0]
        i += 1

    numOfPeople = int(ls[0])
    del ls[0]

    i = 0
    points = []
    while (i < numOfPeople):
        pointls =[]
        x = int(ls[i].split()[0])
        y = int(ls[i].split()[1])
        pointls.append(x)
        pointls.append(y)
        points.append(pointls)
        i += 1

    finalLs = []

    for point in points:
        pathls = findPaths(point[0], point[1], m, n, [])
        tot = totalTime(matls, pathls)
        print(pathls)
        i = m - point[0] - 1
        amtPaths = C(2*i, i)
        avg = avgTime(tot, amtPaths)
        finalLs.append(avg)

    print(finalLs)

# using dfs im able to get a list of paths to the end 
# however its 
def findPaths(x, y, m, n, paths):

    ls = []
    ls.append(x)
    ls.append(y)

    if (x == (m - 1) and y == (n - 1)):
        paths.append(ls)

    elif (x > (m - 1) or y > (n - 1)):
        return

    else:
        paths.append(ls)
        findPaths(x + 1, y, m, n, paths)
        findPaths(x, y+1, m, n, paths)
        

    return paths

def C(n,k):
    if (n == 0 or k == 0):
        return 1

    return (factorial(n) / (factorial(k) * factorial(n - k)))

def factorial(n):
    if (n < 2):
        return n

    return n * factorial(n - 1) 



'''
def  findPaths(mat, start, end, q):
    ls = []
    tmp = [start]

    q.put(tmp)

    while not q.empty():
        tmp = q.get()
        lastNode = tmp[len(tmp) - 1]
        
        if last_node == end:
            ls.append(tmp)

        for linkNode in mat[lastNode[0]][lastNode[1]]:
'''


if __name__ == "__main__":
    main()
