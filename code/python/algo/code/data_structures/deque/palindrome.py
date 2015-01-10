# palindromes can easily be solved with deques. 

from deque import Deque

def palindrome(aString):

    charDeque = Deque()

    for char in aString:
        charDeque.addRear(char)
        # charDeque.insert(0, char)

    stillOk = True

    while charDeque.size() > 1 and stillOk:

        # charDeque.pop()
        first = charDeque.removeFront()

        # charDeque.pop(0)
        last = charDeque.removeRear()

        if first != last:
            stillOk = False


    return stillOk

print(palindrome("lsdkjfskf"))
print(palindrome("bob"))
