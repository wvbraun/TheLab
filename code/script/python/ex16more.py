from sys import argv 

script, filename = argv 

print "We are going to open %r." % filename 

raw_input("Which file would you like to open?")
print "Opening the file..."

doit = open(filename, 'r')

print doit.read()

print "Now lets close it."
doit.close()