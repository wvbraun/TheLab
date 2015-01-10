# def blah(n):
	# i = 0 
	# numbers = []
	# while i < n:
		# print "At the top i is %d" % i 
		# numbers.append(i)
	
		# i = (i +1) * 2
		# print "Numbers now: ", numbers 
		# print "At the bottom i is %d" % i 
	
	# print "The numbers:"

	# for num in numbers:
		# print num
		
# blah(8)

def blah(n, p):
	numbers = []
	for e in range(n,p):
		print "At the top e is %d" % e
		numbers.append(e)
		print "numbers now: ", numbers 
		e = e + 1
		print "At the bottom e is %d" % e
	
	print "The numbers: "
	for num in numbers:
		print num
		
blah(0, 10)

