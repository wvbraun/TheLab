cars=100
space_in_a_car=4.0
drivers=30
passengers=90
cars_not_driven= cars - drivers 
cars_driven = drivers
carpool_capacity= cars_driven * space_in_a_car
average_passengers_per_car= passengers/cars_driven

# this will tell how many cars there are 
print "There are", cars, "cars available."
# this tells how many drivers there are
print "there are only", drivers, "drivers available."
# this tells how many cars are not being driven
print "There will be", cars_not_driven, "empty cars today."
# this tells how many people that could be driven today
print "We can transport", carpool_capacity, "people today."
# this tells how many people are being driven today
print "We have", passengers, "to carpool today."
# this tells how many people should be in each car
print "We need to put about", average_passengers_per_car, "in each car."