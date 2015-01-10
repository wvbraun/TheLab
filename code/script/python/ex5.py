name= 'Brandon S. Peavler'
age= 19 
height= 67 #inches 
weight= 165 #pounds
eyes = 'Blue'
teeth = 'White' 
hair = 'Brown'
x = weight / 2.2
y = height * 2.54

print "Let's talk about %r." % name
print "He's %r inches tall, which is %r centimeters." % (height, y)
print "He's %d pounds heavy, which is %r kilograms." % (weight,x)
print "Actually that is not too heavy."
print "He's got %s eyes and %s hair." % (eyes, hair)
print "His teeth are usually %s depending on the morning coffee." % teeth

print "If I add %d, %d, and %d I get %d." %( age, height, weight, age+height+weight)