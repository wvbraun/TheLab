import fileinput
import sys

def main():
    allMatrices = []
    orgMatrix = []
    allMatrices.append(orgMatrix)
    Max = 0

    for line in fileinput.input(sys.argv[1]):
        orgMatrix.append(line)

    rows = int(orgMatrix[0].split()[0])
    cols = int(orgMatrix[0].split()[1])

    del orgMatrix[0]

    print(orgMatrix)

    n = 1

    while (n < (cols + 1)):
        ls = flipNColumns(orgMatrix, n)
        allMatrices.append(ls)
        n += 1

    for matrix in allMatrices:
        count = countSame(matrix)
        if (count > Max):
            Max = count

    print(Max)


def countSame(ls):
    tot = 0
    row = 0

    while (row < len(ls)):
        col = 0
        item = ls[row][col]
        same = True
        while (col < len(ls)):
            if ls[row][col] != item:
                same = False
                break

            col += 1

        if not same:
            row += 1
            continue

        tot += 1
        row += 1
                
    return tot

def flipNColumns(ls, n):
    new = ls
    col = 0
    while (n > 0):
        row = 0
        while (row < len(ls)):
            if (new[row][col] == "P"):
                del new[row][col]
                new[row][col] = "T"
            else:
                del new[row][col]
                new[row][col] = "P"

            row += 1

        col += 1

    return ls

        




if __name__ == "__main__":
    main()
