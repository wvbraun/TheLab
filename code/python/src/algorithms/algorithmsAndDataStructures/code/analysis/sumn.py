# this function computes the sum of the first n integers. 
import time


def sumOfN(n):
    theSum = 0
    for i in range(1, n+1):
        theSum = theSum + i

    return theSum

print(sumOfN(10))

def sumOfN2(n):

    start = time.time()

    theSum = 0
    for i in range(1, n+1):
        theSum = theSum + i 

    end = time.time()

    return theSum, end-start

def sumOfN3(n):
    return (n*(n+1)) / 2

print(sumOfN3(10))


def foo(tom):
    fred = 0
    for bill in range(1,tom+1):
        barney = bill
        fred = fred + barney 

    return fred 

print(foo(10))
