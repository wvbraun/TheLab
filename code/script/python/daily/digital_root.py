# digital_root.py
# Challenge #122 Sum Them Digits r/dailyprogrammer
# create a function that can find the digital root of number
# solve it with only integer calculations 
# sample input: 31337
# sample output: 8, 3+1+3+3+7 = 17 and 1+7 = 8
# -------------------------------------------------------------

# Challenge Input: 1073741824

## The digital root can be found with the Congruence Formula:
# dr(n) = 1 + ((n-1) % 9)
# a simpler solution is simply finding the remainder 
# of the number divided by nine.
# the remainder is the digital root. 

input = 1073741824
def root(n):
	return n % 9
	
print root(input)

## another method 

def sum(n):
	print n
	print str(1) + str((int(n)-1) % 9)
	return n % 9 
	
print sum(12345)
print sum(input)
