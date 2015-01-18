#solution to anagram problem by checking off. 

def anagram1(s1, s2):

    a_list = list(s2)

    pos1 = 0
    stillOk = True

    while pos1 < len(s1) and stillOk:
        pos2 = 0
        found = False
        while pos2 < len(a_list) and not found:

            if s1[pos1] == a_list[pos2]:

                found = True

            else:

                pos2 += 1

        if found:
            a_list[pos2] = None
        else:
            stillOk = False


        pos1 += 1

    return stillOk

print(anagram1('abcd', 'dcba'))

#---------------------------------------------------------
# solution by sort and compare 

def anagram2(s1, s2):

    anagram2.list1 = list(s1)
    anagram2.list2 = list(s2)

    # this will put them in alphabetical order
    anagram2.list1.sort() 
    anagram2.list2.sort()

    pos2 = 0
    matches = True

    while pos2 < len(s1) and matches:

        if anagram2.list1[pos2] == anagram2.list2[pos2]:
            pos2 += 1
        else:
            matches = False

    return matches

print(anagram2('abcde', 'edcba'))

#-------------------------------------------------------
# count and compare
# this will take advantage of the fact that any two anagrams will
# have the same number of a's, b's, c's, etc. In order to decide
# whetere two strings are anagrams, we will first count the number
# of times each character occurs. since there are 26 possible characters,
# we will use a list of 26 counters... 

def anagram3(s1, s2):

    c1 = [0]*26
    c2 = [0]*26

    for i in range(len(s1)):
        pos = ord(s1[i]) - ord('a')
        c1[pos] += 1

    for i in range(len(s2)):
        pos = ord(s2[i]) - ord('a')
        c2[pos] += 1

    j = 0

    still_good = True 
    while j < 26 and still_good :
        if c1[j] == c2[j]:
            j += 1

        else:
            still_good = False

    return still_good

print(anagram3('apple', 'pleap'))


#-----

def wut(a,b):

    aL = list(a)
    bL = list(b)

    aL.sort()
    bL.sort()

    poz = 0
    truth = True

    while poz < len(aL) and truth:

        if aL[poz] == bL[poz]:
            poz += 1
        else:
            truth = False

    return truth

print(wut('abc', 'cba'))

