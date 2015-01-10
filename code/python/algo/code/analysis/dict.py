import timeit
import random 

for i in range(10000, 100001, 20000) :

    t = timeit.Timer("random.randrange(%d) in x" 
