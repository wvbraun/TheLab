# four ways to generate a list of n numbers starting with 0. 

# First, we will use a for loop and create the list by 
# concatentation. 

def test1():

    length = []

    for i in range(1000):
        length += 1 

# Using append

def test2():

    length = []
    for i in range(1000):
        length.append(i)

# list comprehension 

def test3():

    length = [i for i in range(1000)]

# range function wrapped by a call to the list constructor. 

def test4():
    length = list(range(1000))


t1 = Timer("test1()", "from __main__ import test1")
print("concat ", t1.timeit(number=1000), "milliseconds")
t2 = Timer("test2()", "from __main__ import test2")
print("append ", t2.timeit(number=1000), "milliseconds")
t3 = Timer("test3()", "from __main__ import test3")
print("comphrension ", t3.timeit(number=1000), "milliseconds")
t4 = Timer("test4()", "from __main__ import test4")
print("list range ", t4.timeit(number=1000), "milliseconds")
