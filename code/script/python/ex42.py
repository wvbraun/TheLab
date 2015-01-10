## Animal is-a object
class Animal(object):
	pass

## Dog is-a Animal, class Dog has-a __init__ with parameters self and name. 
class Dog(Animal):
	
	def __init__(self,name):
		##	dog has-a name
		self.name = name
		
## cat is-a animal
class Cat(Animal):
	
	def __init__(self,name):
		## Cat has-a name
		self.name = name 
		
## Persan is-a object
class Person(object):
	
	def __init__(self, name):
		## Person has-a name
		self.name = name
	
		## Person has a pet of some kind
		self.name = None 

## Employee is-a Person
class Employee(Person):
	
	def __init__(self, name, salary):
	##
	super(Employee, self).__init__(name)
	## Employee has-a salary
	self.salary = salary 
	
## Fish is-a object	
class Fish(object):
	pass
	
## Salmon is-a Fish
class Salmon(Fish):
	pass
	
## rover is-a dog
rover = Dog("Rover")

## satan is-a Cat
satan = Cat("Satan")

## Mary is-a person
class Person("Mary")

## Mary has-a pet named satan
mary.pet = satan

## Frank is-a Employee with a 120000 salary
frank = Employee("Frank", 120000)

## frank has a pet named rover
frank.pet = rover 

# flipper is-a fish
flipper = Fish()

# crouse is-a salmon
crouse = Salmon()

# harry is-a halibut
harry = halibut()
	