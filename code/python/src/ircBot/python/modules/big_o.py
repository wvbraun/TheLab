import textwrap
import time



# lists

bigO_list = {
        "copy" : "O(n)",
        "index" : "O(1)",
        "index assignment" : "O(1)",
        "append" : "O(1)",
        "pop()" : "O(1)",
        "pop(i)" : "O(n)",
        "insert" : "O(n)",
        "delete item" : "O(n)",
        "iteration" : "O(n)",
        "get slice" : "O(k)",
        "del slice" : "O(n)",
        "set slice" : "O(k+n)",
        "reverse" : "O(n)",
        "concotenate" : "O(k)",
        "sort" : "O(nlog(n))",
        "multiply" : "O(nk)"
    }

def convertList(output):

    for key, value in bigO_list.iteritems():   

        if output == key:
            return "The time complexity of {0}, a Python list operation: {1}" \
                    .format(output, value)
        
    if output not in bigO_list.keys():
        return "Not a valid entry, try again."


def bigoList(phenny, input):

    output = input.group(2)

    if not output:
        return phenny.say("Err, I think you forgot something...")

    time.sleep(1)
    phenny.say(convertList(output))
 
bigoList.commands = ['list growth', 'list', 'bigO list']


# dicts

bigO_dict = {
        "copy" : "O(n)",
        "get" : "O(1)",
        "set" : "O(1)",
        "delete" : "O(1)",
        "iteration" : "O(n)"
    }

def convertDict(output):

    for key, value in bigO_dict.iteritems():

        if output == key:
            return "The time complexity of {0}, a Python dictionary operations: {1}" \
                    .format(output, value)

    if output not in bigO_dict.keys():
        return "Not a valid entry, try again."

def bigoDict(phenny, input):

    output = input.group(2)
    if not output:
        return phenny.say("Err, I think you forgot something...")

    time.sleep(1)
    phenny.say(convertDict(output))

bigoDict.commands = ['dict_growth', 'dic']


# misc

notation = {
    "O(1)" : """
            O(1) represents consant growth. 
            It describes an algorithm that will always execute in the same time, or space, 
            regardless of the size  of the input data set.
            """,

    "O(n)" : """
            O(n) represents linear growth.
             It describes an algorithm whose performance will grow linearly, and in direct
             proportion, to the size of the input data set. 
            """,

    "O(n+k)" : """
                O(n+k) represents linear growth. 
                It describes an algorithm with two data sets involved, and it performance
                 depends on their combined size.
                """,

    "O(n**2)" : """
                O(n**2) represents quadratic growth.
                 It describes an algorithm whose performance is directly proportional to 
                the square of the size of the input data set.
                """,
    "O(2**n)" : """
                O(2**n) represents exponential growth.
                 It describes an algorithm whose growth will double with each 
                additional element in the input data set. 
                """,
    "O(logn)" : """
                O(logn) represents logarithmic growth; the inverse of exponential growth.
                 It describes an algorithm whose growth will halve with each additional 
                element in the input data set.
                """,

    "O(nlog(n))" : """
                O(nlog(n)) represents linear logarithmic growth. 
                O(n) * O(logn).
                """
    }

def convertNot(output):

    for key, value in notation.iteritems():
        if output == key:
            return textwrap.dedent(value).strip()

    if output not in notation.keys():
        return "Not a valid entry, try again."

def bigoNotation(phenny, input):
    output = input.group(2)

    if not output:
        return "Err, I think you forgot something..."

    time.sleep(1)
    phenny.say(convertNot(output))

bigoNotation.commands = ['notation', 'bigo', 'bigO', 'big o', 'big O']

    
scale1 = "An O(1) (linear) algorithm scales better than an O(logn) (logarithmic) algorithm."
scale2 = "An O(logn) algorithm scales better than an O(n) (linear) algorithm."
scale3 = "An O(n) algorithm scales better than an O(nlog(n)) (linear logarithmic) algorithm."
scale4 = "An O(nlog(n)) algorithm scales better than an O(n**2) (quadratic) algorithm."
scale5 = "An O(n**2) algorithm scales better than an O(2**n) (exponential) algorithm."
scale6 = "However, scalability != efficiency!!!!!!"

def oScale(phenny, input):

    time.sleep(1)
    phenny.say(scale1)
    phenny.say(scale2)
    phenny.say(scale3)
    phenny.say(scale4)
    phenny.say(scale5)
    phenny.say(scale6)

oScale.commands = ['scale', 'scalability']

# print (textwrap.fill(textwrap.dedent(scale).strip()))
#print(scale)
