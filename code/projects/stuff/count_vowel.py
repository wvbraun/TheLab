# program to count number of vowels in string 
# also will give total ordinal value. 

vowels = ['a','e','i','o','u']

def vowelCount(n):

    n.split(',')
    
    vowelSum = 0
    ordSum = 0

    for char in n:
        if char in vowels:
            vowelSum += 1
            ordSum += ord(char)

    print(vowelSum)
    return(ordSum)

print(vowelCount('melloyello'))


