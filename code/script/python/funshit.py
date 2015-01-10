from sys import argv 

script, username, major = argv 
prompt = ">"

print "Hello %s, I am the %s that you created!" % (username, script)
print "I am going to ask you a few questions about %s." % major
print "What can you do with an %s degree?" % major
todo = raw_input(prompt)

print "That sounds exciting!"
print "What year are you in?"
year = raw_input(prompt)

print """
So %r, you are currently majoring in %r and you plan to %r. 
You are going to enter year %r very soon, goodluck!
""" %(username, major, todo, year)
