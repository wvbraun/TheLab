from random import randint 

def roll(ndm):
	
	rolls, sides = ndm.split("d")
	
	i = 0 
	s = []
	while i < int(rolls):
		s.append(randint(0, int(sides)))
		i += 1
	return str(s).strip("[]")
	

print roll('2d20')
print roll('5d10')
	
	# i = 0
	# m = []
	# while i < n:
		# m.append(randint( 0 , p))
		# i+= 1
	# return str(m).strip('[]')
	
# print roll(2,20)
# print roll(5,100)