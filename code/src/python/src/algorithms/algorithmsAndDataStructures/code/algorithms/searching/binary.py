def binary(alist, item):

    first = 0
    last = len(alist) -1
    found = False

    while first <= last and not found:

        midpoint = int((first + last) / 2)

        if alist[midpoint] == item:
            found = True

        else: 
            if item < alist[midpoint]:
                last = midpoint -1

            else:
                first = midpoint +1

    return found

testList = [0, 1, 2, 8, 13, 17, 19, 32, 42]

print(binary(testList, 3))
print(binary(testList, 13))


# recursive call

def rebinary(alist, item):

    if len(alist) == 0: # if the item is not in the list
        return(False)

    else:
        midpoint = int(len(alist) / 2)

        if alist[midpoint] == item:
            return(True)
        
        else:
            if item < alist[midpoint]: # item is less than middle item
                return(rebinary(alist[:midpoint], item))
            # recursive call with alist[:midpoint] 
            # which is upper half of a list


            else:
                return(rebinary(alist[midpoint+1:], item))
            # recursive call with lower half of list

print(rebinary(testList, 3))
print(rebinary(testList, 13))
