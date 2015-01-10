from sys import argv 

script, filename, new_file = argv 

file1 = open(filename, 'w')

file1.truncate()

line1 = raw_input("Line 1:")
line2 = raw_input("Line 2:")
line3 = raw_input("Line 3:")

n = "\n"

file1.write(line1)
file1.write(n)
file1.write(line2)
file1.write(n)
file1.write(line3)

file1.close()

file1 = open(filename, 'r')
print file1.read()

file1.close()

print "BREAK"

file2 = open(new_file, 'w')

file2.write(open(filename).read())

file2.close()

file2 = open(new_file, 'r')
print file2.read()

file2.close()

