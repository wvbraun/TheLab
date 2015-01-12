# shell sort

def shellSort(n):

    subListCount = len(n) // 2

    while subListCount > 0:

        for startPos in range(subListCount):

            gapInsertionSort(n, startPos, subListCount) # increment i, sometimes called gap

        print("After increments of size", subListCount, "the list is", n)

        subListCount = subListCount // 2

def gapInsertionSort(n, start, gap):

    for i in range(start + gap, len(n), gap):

        currentValue = n[i]
        pos = i

        while pos >= gap and n[pos - gap] > currentValue:

            n[pos] = n[pos - gap]
            pos = pos - gap


        n[pos] = currentValue

alist = [54, 26, 93, 17, 77, 31, 44, 55, 20]
shellSort(alist)
print(alist)
