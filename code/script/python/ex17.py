from sys import argv 
from os.path import exists 

scrit, from_file, to_file = argv 

# this is the script in one line
open(to_file, 'w').write(open(from_file).read())

# # this line lets us know that we are going to 
# # copy the from_file and paste into to_file
# print "Copying from %s to %s" % (from_file, to_file)

# #this allows the variable in_file == the open(from_file)
# in_file = open(from_file)
# # this lets indata == in_file.read()
# indata = in_file.read()

# #this line gives the length of indata 
# print "The input file is %d bytes long" % len(indata)

# #this checks if the to_file exists yet or not
# # if it exists it will return True, if not False
# print "Does the output file exist? %r" % exists(to_file)
# print "Ready, hit RETURN to continue, CTRL-C to abort."
# raw_input()

# # this lets out_file == open(to_file, 'w')
# # which means we are opening the to_file to write to it
# out_file = open(to_file, 'w')
# #this file writes whatever is in indata. 
# out_file.write(indata)

# print "Alright, all done."

# out_file.close()
# in_file.close()

# in_file = open(from_file)
# out_file = open(to_file)

# print in_file.read()
# print out_file.read()