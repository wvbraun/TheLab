import hashlib
import uuid

# MD5

error = "Nothing to hash!"

def md5(n):
    
    hashCode = hashlib.md5(n.encode())
    return(hashCode.hexdigest())

def hashmd5(phenny, input):

    output = input.group(2)

    if not output:
        return(phenny.say("Nothing to hash!"))

    phenny.say(md5(output))

hashmd5.commands = ['md5', 'hash md5']

# SHA1

def sha1(n):

    hashCode = hashlib.sha1(n.encode())
    return(hashCode.hexdigest())

def hashsha1(phenny, input):

    output = input.group(2)
    if not output:
        return(error)

    phenny.say(sha1(output))
hashsha1.commands = ['sha1', 'hash sha1']

# SHA224

def sha224(n):

    hashCode = hashlib.sha224(n.encode())
    return(hashCode.hexdigest())

def hash_sha224(phenny, input):

    output = input.group(2)
    if not output:
        return(error)

    phenny.say(sha224(output))

hash_sha224.commands = ['sha224', '224', 'hash sha224', 'hash 224']


# SHA256

def sha256(n):

    hashCode = hashlib.sha256(n.encode())
    return(hashCode.hexdigest())

def hash_256(phenny, input):

    output = input.group(2)
    if not output:
        return(error)

    phenny.say(sha256(output))

hash_256.commands = ['sha256', '256', 'hash 256', 'hash sha256']

# SHA384

def sha384(n):

    hashCode = hashlib.sha384(n.encode())
    return(hashCode.hexdigest())

def hash_384(phenny, input):

    output = input.group(2)
    if not output:
        return(error)

    phenny.say(sha384(output))

hash_384.commands = ['sha384', '384', 'hash 384', 'hash sha384']

# SHA512

def sha512(n):

    hashCode = hashlib.sha512(n.encode())
    return(hashCode.hexdigest())

def hash512(phenny, input):

    output = input.group(2)
    if not output:
        return(phenny.say("Error"))

    phenny.say(sha512(output))

hash512.commands = ["sha512", "512", 'hash sha512', 'hash 512', 'hash', 'hash sha']


# salt







"""
class remainderMethod:

    def __init__(self):
        self.list = [0]*11
        

    def hash(self, key):
        total = 0
        for char in key:
            total += ord(char)
        return(total % 11)
        


def remainderMethod(items, size):
   

   hashValue = []
    hashDict = {}

    for item in items:
        val = item % size 
        hashValue.append(val)
        hashDict[item] = val

    hashValue.sort()
    hashTable = []
    
    i = 0
    while i <= (size - 1):

        for num in hashValue:
        
            if i == num:
                hashTable.insert(i, hashDict[i])
            else:
                hashTable.insert(i, None)
        i += 1

    return hashTable

print(remainderMethod([54, 26, 93, 17, 77, 31], 11))


"""
