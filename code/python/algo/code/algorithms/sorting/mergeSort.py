
# first ask base case
# if the len of the list is less than or equal to one, then we have a sorted list
# otherwise, we will use splice to extract the left and right halves. 

def mergeSort(n):

    print("Splitting ", n)

    if len(n) > 1:

        mid = len(n) // 2
        left = n[:mid]
        right = n[mid:]

        mergeSort(left)
        mergeSort(right)

        i = 0
        j = 0
        k = 0

        while i < len(left) and j < len(right):

            if left[i] < right[j]:
                n[k] = left[i]
                i += 1
            else:
                n[k] = right[j]
                j += 1
            k += 1

        while i<len(left):
            n[k] = left[i]
            i += 1
            k += 1 

        while j < len(right):
            n[k] = right[j]
            j += 1
            k += 1

    print("Merging ", n)

alist = [54, 26, 93, 17, 77, 31, 44, 55, 20]
mergeSort(alist)
print(alist)
