ten_things = "Apples Oranges Crows Telephone Light Sugar"

print "Wait there's not 10 things in that list, let's fix that."
print "How many are there?"
print "There are %d items" % len(ten_things.split(' '))

stuff = ten_things.split(' ')
more_stuff = ["Day", "Night", "Song", "Frisbee", "Corn", "Banana", "Girl", "Boy"]

while len(stuff) != 10:
	next_one = more_stuff.pop()
	print "Adding: ", next_one
	stuff.append(next_one)
	print "There's %d items now." % len(stuff)
	
print "There we go: ", stuff

print "Let's do some things with stuff."

print stuff[1] # this prints the 2nd element in stuff
print stuff[-1] # prints the last element in stuff
print stuff.pop() # prints the removed item from stuff 
print stuff
print ' '.join(stuff) # join(' ', stuff) prints that. 
print '#'.join(stuff[3:5]) # adds '#' after element 3 and before element 5
