from sys import argv

script, username = argv 
prompt = '> '

print "Hi %s, I am the %s script that you created!" %(username, script)
print "I am going to ask you a few questions."
print "%s, what do you think about me?" % username
cool = raw_input(prompt)

print "%s, where are you from?" % username
live = raw_input(prompt)

print "%s, where do you go to school?" %username
school = raw_input(prompt)

print """
Okay %r, you said that you think I am %r. 
You also said that you are from %r and 
that you go to %r. Awesome!
""" % (username, cool, live, school)

