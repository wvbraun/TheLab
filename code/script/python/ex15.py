# This imports the sys module from argv
from sys import argv

#This line 'unpacks' argv, assigning it to 2 variables
script, filename = argv

#This assigns the variable txt to the opening of 'filename'
txt = open(filename)

#This prints 'Here's your file etc'
print "Here's your file %r:" %filename
# This gives a command 
print txt.read()

print "Type the filename again:"
#This assigns variable to the raw_input/question
file_again = raw_input("> ")

#This assigns variable to the opening of fileagain
txt_again = open(file_again)

print txt_again.read()

txt.close()
txt_again.close()

# from sys import argv

# script, filename = argv

# txt = open(filename)

# print "Here's your file %r:" % filename
# print txt.read()

# print "Type the filename again:"
# file_again = raw_input("> ")

# txt_again = open(file_again)

# print txt_again.read()