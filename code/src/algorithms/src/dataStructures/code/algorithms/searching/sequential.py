

def sequential(alist, item):

    pos = 0
    found = False

    while pos < len(alist) and not found:

        if alist[pos] == item:
            found = True

        else:
            pos += 1

    return found

testList = [1, 2, 32, 8, 17, 19, 42, 13, 0]
print("Unordered List: ")
print(sequential(testList, 3))
print(sequential(testList, 13))
print("")

def order(alist, item):

    pos = 0 
    found = False
    stop = False

    while pos < len(alist) and not found and not stop:

        if alist[pos] == item:
            found = True

        else:
            if alist[pos] > item:
                stop = True
            else:
                pos += 1

    return found

testList2 = [0, 1, 2, 8, 13, 17, 19, 32, 42]
print("Ordered List: ")
print(order(testList2, 3))
print(order(testList2, 13))

