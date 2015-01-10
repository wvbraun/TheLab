# Map
	# - next_scene
	# - opening_scene
# Engine 
	# - play
# Scene 
	# - enter 
	# * Death 
	# * Ground Zero
	# * City Limit
	# * Survivors 
	# * Escape
	
from sys import exit
from random import randint
import math
import random

class Scene(object):
	
	def enter(self):
		print "This scene is not ready"
		exit(1)
		
class Engine(object):
	
	def __init__(self, scene_map):
		self.scene_map = scene_map
	
	def play(self):
		current_scene = self.scene_map.opening_scene()
		
		while True: 
			print "\n----------"
			next_scene_name = current_scene.enter()
			current_scene = self.scene_map.next_scene(next_scene_name)
	
class Death(Scene):
	
	zomb = [
		"You have been viciously ripped apart by zombies.",
		"Well... now you know you are nothing special, you died like everyone else.",
		"Dead.",
		"Everyone in your group is dead, including you."
	]

		
	def enter(self):
		print Death.zomb[randint(0, len(self.zomb)-1)]
		exit(1)
		
class Math(Scene):
	
	
	
	def enter(self):
		equations = {
		'What is the sqaure root of 9?' : '3', 
		'What is the limit as x approaches 4 of (3x^2 - 4x + 5)?' : 37,
		'What is cos(arcsin(12/13))?' : '5/13', 
		'What is arcsin(sin(5))?' : '5',
		'Convert 60 degrees to radians' : 'pi/3',
		'Solve for x: 5x = 20' : '4', 
		'What is the limit as x approaches infinity for (x^2/x)?' : 'infinity'
	}
	
		wrong = 0
		questions = 0 
		correct = 0
		
		while wrong < 2 and correct < 3:
			quest = random.choice(equations.keys())
			print quest
			questions += 1 
			answer = raw_input('> ')
			if answer == equations[quest]:
				print "Correct"
				correct += 	1
			else:
				print "Wrong"
				wrong += 1
					
		if correct == 3:
			return 'finish'
		elif wrong == 2: 
			return 'die_bitch'
			
class DieBitch(Scene):
		
		def enter(self):
			print "Looks like this is the end of the road for you..."
			print "The survivor has killed you."
			exit(1)
	
	
class Die(Scene):
	
	def enter(self):
		print "The survivors did not take kindly to your answer."
		print "The leader pulled the gun from his waist and shot you dead."
		exit(1)
	
class GroundZero(Scene):
	
	def enter(self):
		print "At 1:34 AM this morning the first infected carrier of what the CDC is now calling"
		print "a rapidly mutating zombie virus was reported."
		print "Early attempts at containing the infectious disease proved to be futile."
		print "It is now one week since the first reported incident"
		print "and over 75% of the world's population is infected."
		print "You are one of the remaining survivors in the city of Bloomington."
		print "\n"
		print "You attempt to leave your apartment only to be spotted by a zombie."
		print "The zombie begins to approach you..."
		print "What do you do: Run, Attack, Hide?"
		
		action = raw_input("> ")
		
		if action == "Run" or action == "run":
			print "You quickly sprint to you car"
			print "As you are running a herd of zombies appear in the corner of your eye"
			print "Fortunately you have a keyless remote and are able to unlock your car from a distance",
			print "Once you get to your car you quickly start the engine and speed off."
			return 'city_limit'
		
				
		elif action == "Attack" or action == 'attack':
			print "The only weapon you have on you is a baseball bat", 
			print "You take this bat and begin approaching the zombie",
			print "You take a swing at the zombie and smash its brains out",
			print "However in the process you also break the bat in half",
			print "As you start walking away from the zombie you see a group of zombies",
			print "The zombies quickly surround you and swarm you",
			return 'death'
		
			
		elif action =="Hide" or action == "hide":
			print "You quickly run and hide behind a car"
			print "However as you are hiding a zombie ambushes you from behind"
			return 'death'
		
	
		else: 
			print "Does Not Compute"
			return "ground_zero"
	
class CityLimit(Scene):
		
	def enter(self):
		print "After driving for an hour you reach the city limits",
		print "Unfortunately you also run out of gas"
		print "You leave the car with a gas can and being searching for fuel",
		print "After a couple miles you notice a gas tank",
		print "You approach the tank but notice there is a lock on it",
		print "The lock requires 4 digits to open",
		print "You have five attempts"
			
		code = "%d%d%d" % (randint(1,9), randint(1,9), randint(1,9))
		guesses = 0 
		guess =	raw_input("[keypad]> ")
			
		while guesses != code and guesses < 6:
			print "WRONG!"
			guesses += 1
			guess = raw_input("[keypad]> ")
				
		if guess == code:
			print "The code works and you unlock the lock"
			print "You quickly fill the tank up and begin walking back towards your car"
			print "As you are walking back towards you car you are approached by a group of survivors"
			return 'survivors'
		
		if guesses == 6:
			print "Ah, fuck it."
			return 'survivors'
				
		
class Survivors(Scene):
	
	def enter(self):
		print "The group of survivors greet you, however both parties are quite wary towards each other"
		print "The group demands you tell them who you are."
		print "What is your name?"
		name = raw_input(">")
		print "Where are you from?"
		origin = raw_input("> ")
		print "Why are you alone?"
		alone = raw_input("> ")
		
		print "So your name is %r and you are from %r..." % (name, origin)
		print "Well it's nice to meet you, we have not came across any survivors in a long while."
		print "We had 10, now we only have 6; last week some walkers ambushed us?"
		print "So where are you headed?"
		headed = raw_input("> ")
		print "Bad Idea... the place is a graveyard."
		print "Why don't you come with us?"
		print "Yes or No?"
		
		decision = raw_input("> ")
		
		if decision == 'Yes' or decision == 'yes':
			print "Sure, why not?"
			print "I could use some company."
			
		elif decision == 'No' or decision == 'no':
			print "Suit yourself."
			return 'die'
			
		else:
			print "DOES NOT COMPUTE"
			return 'survivors'
			
		print "The survivors notice you have a can of gas in your hands, they ask what for?"
		print "You inform them that your car ran out of gas a couple miles back."
		print "The group responds in glee as they may finally be able to get out of town."
		
		return 'escape'
		
class Escape(Scene):
	
	def enter(self):
		print "You and the group finally reach the car."
		print "As you go to unlock the car you feel a gun on the back of your head."
		print "'Looks like this is the end of the road for you.'"
		print "What do you do: Beg or Attack?"
		
		whatdo = raw_input("> ")
		
		if whatdo == 'Attack' or whatdo == 'attack':
			print "You look deep within yourself to find the answer of escaping this situation?"
			print "In order to make an effective attack you must answer a three questions."
			print "You must correctly answer two..."
			return 'math'
			
		if whatdo == "Beg" or whatdo == 'beg':
			print "That's so sad..."
			print "I thought you would have more dignity than this."
			print "I expected more from you %d" % name
			return 'die_bitch'
			
			
class Finish(Scene):
	
	def enter(self):
		print "You grab the knife you have hidden on your waist"
		print "and quickly stab the survivor in his stomach."
		print "As the survivor bleeds you grab the gun from him"
		print "and point it at the remaining members in the group."
		print "They slowly back away."
		print "You tell them 'we could have beaten this thing...'"
		print "You get into your car and quickly drive away,"
		print "leaving the city behind you."
		exit(1)
		
class Map(object):
	
	scenes = {
		'city_limit' : CityLimit(),
		'death' : Death(),
		'escape' : Escape(), 
		'ground_zero' : GroundZero(),
		'survivors' : Survivors(),
		'math' : Math(),
		'die_bitch' : DieBitch(),
		'finish' : Finish()
	}
		
	
	def __init__(self, start_scene):
		self.start_scene = start_scene
	
	def next_scene(self, scene_name):
		return Map.scenes.get(scene_name)
		
	def opening_scene(self):
		return self.next_scene(self.start_scene)
		
a_map = Map('ground_zero')
a_game = Engine(a_map)
a_game.play()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	