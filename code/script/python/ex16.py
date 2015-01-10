#This imports the argv 
from sys import argv
#This unpacks the 2 variables into argv
script, filename = argv 

#this prints we are going to erase the file
print "We're going to erase %r." % filename
#this asks if you do not want that hit ctrlc
print "If you don't want that, hit CTRL-C (^C)."
print "If you do want that hit RETURN."

#This ask for a confirmation of the 2 choices stated above
raw_input("?")
#this says it is opening the file
print "Opening the file..."
#this assigns the variable target to the opening of the filename in
# write 'w' mode
target = open(filename, 'w')

# trunacte means erasing 
print "Trunacting the file. Goodbye!"
#this erases whatever was on the target file
target.truncate()

print "Now I'm going to ask you for three lines."

#you are asked to write three lines down
line1 = raw_input("line1: ")
line2 = raw_input("line2: ")
line3 = raw_input("line3: ")

print "I'm going to write these to the file."

# here we use the target.write() to write the lines
# from above to the target file
target.write(line1)
# target.write("\n")
# target.write(line2)
# target.write("\n")
# target.write(line3)
# target.write("\n")

print "And finally, we close it."
target.close()