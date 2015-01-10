from sys import argv 

Script, filename = argv 

today = open(filename, 'w') # 'today' opens a new file for me

import datetime 

date = "Date: " + datetime.date.today().strftime("%B %d, %Y") # assigns 'date' to the current date and time 
bulk = raw_input("What happened today?") # assigns 'bulk' to the question 
final = raw_input("Something to end on...") # assigns 'final' to question

today.write(date) # writes 'date' to the file today
today.write("\n")
today.write("\n")
today.write("What happened today?:")
today.write("\n")
today.write(bulk) # ^ 'bulk'
today.write("\n")
today.write("\n")
today.write("Something to end on:")
today.write("\n")
today.write(final) # ^^ 'final'

today.close() # closes the file 'today'

fun = open(filename, 'r')
print fun.read()

fun.close()