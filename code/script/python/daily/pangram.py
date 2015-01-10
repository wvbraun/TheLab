# r/dailyprogrammer challenge 139 pangrams
# Implement a program that takes a series of strings and prints 
# either True (if string is pangram) or False. 
# -------------------------------------------------

#alphabet = ["A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", 
# "G", "g", "H", "h", "I", "i","J", "j", 'K', 'k', 'L', 'l', 'M', 'm', 'N',
# 'n', 'O', 'o', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U', 'u',
# 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z']

alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

test = "the quick brown fox jumps over the lazy dog"
wut = "saxophones quickly blew over my jazzy hair"
s = "my name is brandon peavler"
q = "Relaxing in basins at the end of inlets terminates the endless tests from the box"
r = "hey my name is brandon peavler what is your name who are you whatttttt"

def check(n):
	
	n = list(n)
	i = 1
	storage = []
	
	
	for let in n:
		#x = let
		for letter in alphabet:
			#y = letter
			if let == letter:
				i += 1
				storage += let
				
	
				
	if i >= 26:
		return True 
	else:
		return False 
		
#print list(test)
print check(test)
print check(wut)
print check(s)
print check(r)
print check(q)
			
