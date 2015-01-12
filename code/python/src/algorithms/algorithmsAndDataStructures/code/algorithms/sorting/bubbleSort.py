def bubbleSort(aList):

    for passNum in range(len(aList)-1, 0, -1):

        for i in range(passNum):

            if aList[i] > aList[i+1]:
                temp = aList[i]
                aList[i] = aList[i+1]
                aList[i+1] = temp
                
aList = [54, 26, 93, 17, 77, 31, 44, 55, 20]
bubbleSort(aList)
print(aList)
#>>> [17, 20, 26, 31, 44, 54, 55, 77, 93] 


# Short BubbleSort

def shortBubbleSort(aList):

    exchanges = True
    passNum = len(aList) - 1 
    
    while passNum > 0 and exchanges:
        exchanges = False

        for i in range(passNum):
            if aList[i] > aList[i+1]:
                
                exchanges = True
                temp = aList[i]
                aList[i] = aList[i+1]
                aList[i+1] = temp 
        
        passNum -= 1

list2 = [20, 30, 40, 50, 60, 70, 80, 100, 110]
shortBubbleSort(list2)
print(list2)
#>>> [20, 30, 40, ...]
