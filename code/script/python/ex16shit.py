from sys import argv

script, filename = argv 

print """ We are going to erase the %r file 
and create a new one!""" % filename
print "Hit RETURN."

raw_input(">")

print "Opening the file..."
target = open(filename, 'w')

print "Erasing the file. Peace out!"
target.truncate()

print "Now it's to create this new file, write whatever..."

line1 = raw_input("Line 1:")
line2 = raw_input("Line 2:")
line3 = raw_input("Line 3:")

print "These three lines are going to be your new file!"

target.write(line1)
target.write("\n")
target.write(line2)
target.write("\n")
target.write(line3)

print "Now lets close it!"
target.close()

print "Now lets look at the file!"
target = open(filename, 'r')
print target.read()

