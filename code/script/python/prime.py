# counter = 1
# test = 3

# while counter < 1000:
    # prime = True
    # factor = 2
    # while factor < test and prime == True: #while candidate (test) is still apparently a prime and the factors we're checking haven't reached the candidate yet
        # if test%factor==0:
            # #print test, ' is divisible by ', factor
            # prime = False
        # else:
            # #print test, ' is not divisible by ', factor
            # if factor == 2:
                # factor = factor + 1
            # else:
                # factor = factor + 2

    # if prime == True:
        # counter = counter + 1 #counts to see when we reach 1000

        # if counter == 1000:
            # print test #, 'is a prime number, and it is number', counter

    # test = test + 2
	
number = 3 #the variable that we will be checking if it is a prime
primeCounter = 1 #Because 2 is the first prime number and our program doesn't find it

while primeCounter < 1000: #will stop loop when the 1000th prime is found
    stopCheck = number/3 #last number it needs to check because 3 is the smallest possible factor of any odd number other than 1
    prime = 0
    i = 3
    while i <= stopCheck and prime == 0:
        check = number%i
        if check == 0:
            prime = 1
        i = i+2
    if prime == 0:
        primeCounter = primeCounter +1
    if primeCounter != 1000:
        number = number +2
print number

	