from sys import exit

def dead(why):	
	print why, "Now you die!"
	exit(0)
	
def next(p):
	print p, "Next question!"
	
def try_again(p):
	print p, "Try again!"
	


def one():
	print "You arrive in a room and are greeted by a seven foot python who says..."
	print "You have choosen, however it was not a good choice for you have to face I the Serpant of Knowledge!"
	print "Fortunately you still have a chance."
	print "But you must act now! I hope you like math!"
	print "What is 10 + 5 + 4?"
	
	add = raw_input("> ")
	
	if int(add) == (10 + 5 + 4) : # if 'add' == 19 then it will tell you Correct! Next question!
		next("Correct!")
	else:
		try_again("Wrong!") # if 'add' != 19 then it will tell you Wrong, try again. 
		while True: # this while loop will go on forever unless you can let add == 19. 
			print "What is 10 + 5 + 4?"
			add = raw_input("> ")
			if int(add) == (10+5+4):
				next("Correct!")
				break # if add == 19 then it stops the while loop
			else: # wrong answers allows the loop to continue. 
				try_again("Wrong!")
	
	print "Not bad. But let's see if you can handle something a bit more difficult."
	print "What is the square root of 16?"
	
	import math 
	sqr = raw_input("> ")
	
	if int(sqr) == math.sqrt(16): # this is very similar to the previous question shit. 
		next("Correct!")
	else:
		try_again("Wrong!")
		while True:
			print "What is the square root of 16?"
			sqr = raw_input("> ")
			if int(sqr) == math.sqrt(16):
				next("Correct!")
				break
			else:
				try_again("Wrong!")
				
	print "Okay, I see we have ourselves a baddass on our hands." 
	print "So Mr. Baddass, I have one final question for you, it is the hardest yet."
	print "What is the square root of 64 times 4^5 plus 10?"
	
	der = raw_input("> ")
	
	if int(der) == math.sqrt(64) * 4**5 + 10:
		print "Correct!"
		print "You may have defeated me this time, but it will be your last!"
	else:
		try_again("Wrong!")
		while True:
			print "What is the square root of 64 times 4^5 plus 10?"
			der = raw_input("> ")
			if int(der) == math.sqrt(64) * 4**5 + 10:
				print "Correct!"
				print "You may have defeated me this time, but it will be your last!"
				break
			else:
				try_again("Wrong!")

	
	# do some math shit like 2x = 4, etc. 
	
	
def two():
	print "Hmmm... What is your name?"
	name = raw_input("> ")
	print "I am not too fond of you %r, but I am sure you feel the same." % name
	print "How much do you weigh?"
	weight = raw_input("> ")
	print "Oh my, aren't you quite the heavy one at %r pounds." % weight
	print "How old are you?"
	age = raw_input("> ")
	print "You're %r years old, that's weird because that's how old you'll be when you die..." % age
	print "So let me get this straight: "
	print "Your name is %r, you are %r years old and you weigh %r pounds." %(name, age, weight)
	print "Am I forgetting anything?"
	print "Yes or No"
	forget = raw_input("> ")
	
	if forget == "No" or forget == "no":
		print "Good, now let's move on."
	else:
		print "What is this foolery you speak of?"
		while True:
			print "Yes or No"
			forget = raw_input("> ")
			if forget == "No" or forget == "no":
				print "Good, now let's move on."
				break 
			else:
				print "What is this foolery you speak of?"
	print "You arrive at a door, do you proceed to enter?"
	print "Yes or No"
	enter = raw_input("> ")
	
	if enter == "Yes" or enter == "yes":
		#something
	else:
		print "You wander around the room helplessly until you starve."
		exit(0)
	
			
		
	# name, height, weight, etc. incorporate all this shit into something useful and ask more questions
	
def three():
	print "Welcome to the Twilight Zone."
	print "Here, you will be introduced to things you never thought possible."
	print "Let's get to know each other first..."
	print "My name is David, what is yours?"
	name = raw_input("> ")
	
	print "Now that we have been formally introduced allow me to explain what you are doing here."
	print "%r, I am going to take you through a series of tests."
	print "These tests will determine your future."
	print "Do not fail."
	
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
	
	# use a list and make it go forever type shit
	
	
def yes():
	print "Good answer."
	print "You have three choices, which do you choose?"
	print "1. \n2. \n3."
	print "Decide now!"
	
	decision = raw_input("> ")
	if decision == '1':
		one()
	elif decision == '2':
		two()
	elif decision == '3':
		three()
	else: 
		dead("You waste my time, I waste you.")
	



def start():
	print "You have awoken in a strange room with no memory of how you got there."
	print "A TV turns on and asks: Do you want to play a game?"
	
	do_you = raw_input("> ")
	if do_you == "yes":
		yes()
	else:
		dead("Wrong answer bitch.")
		
start()
	