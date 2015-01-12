# DREAM 2D

I was discussing an odd dream I used to constanly have all the time as a child (< 10). 
The dream consisted of these two rocks which were just constanlty shrinking and growing. 
It appeard as if they were alternating, the first rock would become the second rock, vice-versa.
The odd thing about the dream, besides the fact that it was in 2D, was as the rocks grew/shrink
I could 'feel' them growing/shrinking. 


I have allowed the code to become modular, using racket's class system. The older code is now in
the old directory. 

```

-> := class     - extends/inherited/subclass'd

=> := interface - implements 

growable-circle-class -> circle-class 
					  => growable-interface

circle-class		  -> shape-class

rectangle-class 	  -> shape-class

shape-class			  => drawable-interface

line-class			  => moveable-interface

```



---

## How To Use

```
UNIX: ./Dream2D

ELSE: racket Dream2D.rkt
```

If you want to increase the speed, you need to edit the the
SPEED constant located in modules/defaults/defaults.rkt


