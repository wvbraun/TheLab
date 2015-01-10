# r/dailyprogrammer challenege #119 Change Calculator 
# Write a function that takes an amount of money, 
# rounds it to the nearest penny
# and then tells you the minimum number of coins needed
#-----------------------------------------------------
from math import ceil 
# math.ceil(x) - returns the ceiling of x as a float 

q = 0 # quarters 
d = 0 # dimes 
n = 0 # nickels 
p = 0 # pennies
	
def calc(n):
	
	n = ceil( n * 100) / 100.0
	print n
	
 
	while n > 0.24:
		
		n -= 0.25 
		q += 1 
		
		
	while n > 0.09:
	
		n -= 0.1
		d += 1 
		
	while n > 0.04:
		
		n -= 0.05
		n += 1 
		
	while n > 0.0:
	
		n -= 0.01
		p += 1
		
	print n
	print "Quarters: %d" % (q)
	print "Dimes: %d" % (d)
	print "Nickels: %d" % (n)
	print "Pennies: %d" % (p)
	
print calc(1.23)
		
	
	