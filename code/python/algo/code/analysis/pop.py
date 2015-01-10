import timeit 

popzero = timeit.Timer("x.pop(0)",
        "from __main__ import x")

popend = timeit.Timer("x.pop()", 
        "from __main__ import x")

x = list(range(2000000))
print(popzero.timeit(number = 1000))

x = list(range(2000000))
print(popend.timeit(number = 1000))

# You can see that as the list gets longer, the time it takes to 
# pop(0) also increases while the time for pop stays very flat. 
