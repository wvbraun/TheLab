
# count amt of words/chars in string from file, append sum to file

from sys import argv
import re

file = argv[1]

def wordCount():

    word = open(file, 'r')
    charSum = sum(len(char) for char in word)
   
    wordSum = re.findall('/w+', word)
    
    print(charSum)
    print(wordSum)
   
print(wordCount())
