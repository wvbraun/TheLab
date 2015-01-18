#Hex

##What is Hex?
Hex is a strategy board game played on a hexagonal grid, theoretically of any size and several possible shapes, but traditionally as an 11×11 rhombus. 

---

##Why Hex?
This was the final assigned project for a university course, focusing on object-oriented design. I spent approximately 8 weeks on it. There were many improvements in my solution from the required project, the most notable changes occurring within the GUI classes; we used swing for the graphics though, so not too much could be improved here. 

---

##How to Play
There is a jar file included. This should be run as follows:
```
    GUI:
		java -jar Hex.jar gui
	CLI:
		java -jar Hex.jar cli 
```

---

##Cool Things
	A* AI:
		This AI implements an A* search algorithm to determine the best possible path. 
		Each time getMove() is called, it determines if the path is still the best path
		(meaning the other player has not blocked it). If the path has been blocked, I 
		recalculate the start and goal tiles and then perform an A* search to compute the
		path. If I am unable to find a good path after size^2 attempts, i implement a brute
		force algorithm (same as the Basic AI) in order to find an open tile; this is not an
		optimal solution, but I do not have time to perfect the AI. 
			
	Basic AI:
		This AI implements a very crude heurisitic to determine moves to make.
	    This is accomplished by starting with the (size - 1, size - 1) tile and trying to
	    go straight to its goal (either (0, size - 1) or (size - 1, 0)).

---

##What Did I Learn?
This was the largest piece of software I have personally created so it was interesting
seeing everything that needed to go into this. I noticed a particularly troubling issue
that I, along with many other developers, struggle with: scope creep. It was odd encountering
this on such a small project; I assume this issue would have been greatly exacerbated by hypothetical
budget and time constraints.


I gained a ton of experience utilizing the strengths of java, while also noticing the limitiations
of the language. I was exposed to many useful java packages. I saw the benefits of an IDE for large
projects, or languages which are extremely verbose. 


I learned a decent amount about some path-finding algorithms, namely A*; this was extra credit
and not covered in the course. 
 

