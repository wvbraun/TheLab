# given x and y, it uses the Pythagorean thereon to find missing side. 
# do not import math
# x^2 + y^2 = z^2

#def pythag():

def pythag():

	x = raw_input("side 1 = ")
	y = raw_input("side 2 = ")
	
	print ((((int (x))**2) + ((int (y))**2))**(0.5))
	return again()
	
def again():

	print "Would you like to calculate another side?"
	print "Yes or No"
	again = raw_input("> ")
	
	if again == "Yes" or again == "yes":
		return pythag()
	elif again == "No" or again == "no":
		exit(1)
	else:
		exit(1)
	
print pythag()


# class Pythag(): 
	
	# def enter(self):
	
		# x = raw_input("side 1 = ")
		# y = raw_input("side 2 = ")
	
		# print ((((int (x))**2) + ((int (y))**2))**(0.5))
		
		# return Again()


# class Again():

	# def again(self):
	
		# again = raw_input("Would you like to calculate another side? ")
		# print "Yes or No"
	
		# if again == "Yes" or again == "yes":
			# return Pythag()
		# elif again == "No" or again == "no":
			# exit(1)
		# else:
			# exit(1)
		
# q = Pythag()
	
# print q
