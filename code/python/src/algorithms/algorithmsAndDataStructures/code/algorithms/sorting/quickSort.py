
def quickSort(n):

    quickSortHelper(n, 0, len(n)-1)

def quickSortHelper(n, first, last):

    if first < last: 

        splitPoint = partition(n, first, last)

        quickSortHelper(n, first, splitPoint -1)
        quickSortHelper(n, splitPoint +1, last)

def partition(n, first, last):

    pivotValue = n[first]

    leftMark = first +1
    rightMark = last 

    done = False 

    while not done:

        while leftMark <= rightMark and n[leftMark] <= pivotValue:
            leftMark += 1

        while n[rightMark] >= pivotValue and rightMark >= leftMark:

            rightMark -= 1


        if rightMark < leftMark:
            done = True

        else:
            temp = n[leftMark]
            n[leftMark] = n[rightMark]
            n[rightMark] = temp

    temp = n[first]
    n[first] = n[rightMark]
    n[rightMark] = temp

    return rightMark

alist = [54, 26, 93, 17, 77, 31, 44, 55, 20]
quickSort(alist)
print(alist)

