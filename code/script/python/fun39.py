states = {'Indiana': 'IN', 'Kentucky': 'KY'}
cities = {'IN': 'New Albany', 'KY': 'Louisville'}
counties = {'New Albany': 'Floyd', 'Louisville': 'Jefferson'}

# print out cities 
print '-' * 5 
print "IN State has: ", cities['IN']
print "KY State has: ", cities['KY']

#print out states 
print '-' * 5 
print "Indiana's abbreviation is: ", states['Indiana']
print "Kentucky's abbreviation is: ", states['Kentucky']

print '-' * 5 
print "Indiana has: ", cities[states['Indiana']]
print "Kentucky has: ", cities[states['Kentucky']]

print '-' * 5 
for x, n in states.items():
	print "%s is abbrevaited %s" % (x, n)
	
print '-' * 5 
for abbrev, city in cities.items():
	print "%s has the city %s" % (abbrev, city)
	
print '-' * 5 
for state, abbrev in states.items():	
	print "%s is abbreivated %s, and has city %s" % (state, abbrev, cities[abbrev])
	