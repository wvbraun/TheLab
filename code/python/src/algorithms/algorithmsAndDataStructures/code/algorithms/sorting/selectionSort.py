def selectionSort(aList):

    for fillSlot in range(len(aList)-1, 0, -1):
        positionOfMax = 0

        for location in range(1, fillSlot + 1):

            if aList[location] > aList[positionOfMax]:
                positionOfMax = location


        temp = aList[fillSlot]
        aList[fillSlot] = aList[positionOfMax]
        aList[positionOfMax] = temp

aList = [54, 26, 93, 17, 77, 31, 44, 55, 20]
selectionSort(aList)
print(aList)
#>>> [17, 20, 26, 31, 44, 54, 55, 77, 93]


