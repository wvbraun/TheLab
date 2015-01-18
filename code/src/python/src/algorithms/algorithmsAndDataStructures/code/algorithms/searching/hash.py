
# ordinal value hash function

def hash(astring, tableSize):

    sum = 0
    for pos in range(len(astring)):
        sum += ord(astring[pos])

    return sum%tableSize

print(hash('cat', 11))
