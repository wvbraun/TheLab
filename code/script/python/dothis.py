# def wrong(n):
	
	# while n > 0:
		# print "You have %d more attempts." % n 
		# n = n - 1 
		

# print wrong(3)

print "Your first question."
print "In english, tell me what 'class X(Y)' means."
ans = raw_input("> ")
	
if ans == "Make a class named X that is-a Y.":
		print "Correct."
else:
	def wrong(n):
		while n > 0:
			print "Incorrect, try again!"
			print "You have %d more attempts." % n 
			print "In english, tell me what 'class X(Y)' means."
			ans = raw_input("> ")
		
			if ans == "Make a class named X that is-a Y.":
				print "Correct."
				break 
			else:	
				n = n -1 
			if n == 0:
				print "Die"
	print wrong(3)