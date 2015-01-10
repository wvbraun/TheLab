print "Time to study!"

def wrong():
	print "Incorrect, try again!"


print "In English, tell me what 'Class X(object): def M(self, J)' means."
ans = raw_input("> ")

if ans == "Class X has-a function named M that takes self and J parameters":
	print "Correct"
else:
	wrong()
	print "In English, tell me what 'Class X(object): def M(self, J)' means."
	ans = raw_input("> ")
	while True:
		if ans == "Class X has-a function named M that takes self and J parameters":
			print "Correct"
			break 
		else:
			wrong()
			print "In English, tell me what 'Class X(object): def M(self, J)' means."
			ans = raw_input("> ")
	
print "In English, tell me what 'foo = x()' means."
ans = raw_input("> ")

if ans == "Set foo to an instance of class X":
	print "Correct"
else:
	wrong()
	print "In English, tell me what 'foo = x()' means."
	ans = raw_input("> ")
	while True:
		if ans == "Set foo to an instance of class X":
			print "Correct"
			break 
		else:
			wrong()
			print "In English, tell me what 'foo = X()' means."
			ans = raw_input("> ")	
