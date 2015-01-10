from sys import argv 

script, filename = argv 

fun = open(filename, 'w')


shit1 = raw_input("Line:")
shit2 = raw_input("Line:")
shit3 = raw_input("Line:")
x = shit1 
y = shit2 
z = shit3


fun.write(x), fun.write("\n"), fun.write(y), fun.write("\n"), fun.write(z)


fun.close()

fun = open(filename, 'r')
print fun.read()