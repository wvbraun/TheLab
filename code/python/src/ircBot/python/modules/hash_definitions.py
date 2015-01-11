import time


hash_table = "A collection of items which are stored in such a way as to make it \
        easy to find them later."

hash_slot = "Each position of a hash table."

hash_function = "The mapping between an item and the slot where the item belongs."

load_factor = "(lambda) = (number of items in table) / (table size)"

open_addressing = "attempts to find the next open slot or address in a hash table."

linear_probing = "Systematically visitng each slot one at at ime."

quad_probing = "Quadratic probing uses a skip consisting of perfect squares, \
        rather than constant skip."

chaining = "An alternative method for handeling collisions is to allow each slot to hold \
        a reference to a collection (or chain) of items."

success_linear = "(1/2) * [1 + (1 / (1 - lambda))]"

un_linear = "(1/2) * [1 + (1 / (1 - lambda))**2]"

success_chain = "1 + (lambda / 2)"

un_chain = "lambda"


def hashTable(phenny, input):
    
    time.sleep(1)
    phenny.say("Hash Table: " + hash_table)

hashTable.commands = ['hash table']

def slot(phenny, input):
    time.sleep(1)
    phenny.say("Hash Slot: " + hash_slot)

slot.commands = ['slot']

def load(phenny, input):

    time.sleep(1)
    phenny.say("Load Factor: " + load_factor)

load.commands = ['load factor', 'Load factor']

def hashFunction(phenny, input):
    time.sleep(1)
    phenny.say("Hash Function: " + hash_function)

hashFunction.commands = ['hash function']

def openAddress(phenny, input):
    time.sleep(1)

    phenny.say("Open addressing " + open_addressing)
openAddres.commands = ['open addressing', 'Open addressing', 'open address']

def linear(phenny, input):

    time.sleep(1)
    phenny.say("Linear Probing: " + linear_probing)

linear.commands = ['linear probing', 'Linear probing']

def quad(phenny, input):

    time.sleep(1)
    phenny.say("Quadratic Probing: " + quad_probing)

quad.commands = ['quad probing', 'quadratic probing', 'Quad probing', 'Quadratic probing']

def chain(phenny, input):

    time.sleep(1)
    phenny.say("Chaining: " + chaining)

chain.commands = ['chaining']

def successLinear(phenny, input):

    time.sleep(1)
    phenny.say("Formula for Average Number of Comparisons")
    phenny.say("Successful search using open addressing:")
    phenny.say(success_linear)

sucessLinear.commands = ['successfull linear','success linear','successful linear formula']

def unsuccessLinear(phenny, input):

    time.sleep(1)
    phenny.say("Formula for Average Number of Comparisons")
    phenny.say("Unsuccessful search using open addressing:")
    phenny.say(un_linear)

unsuccessLinear.commands = ['unsuccesful linear', 'unsuccessful linear formula']


def successChain(phenny, input):
    time.sleep(1)
    phenny.say("Formula for Average Number of Comparisons")
    phenny.say("Successful search using chaining:")
    phenny.say(success_chain)

successChain.commands = ['success chain', 'successful chain', 'successful chain formula']

def unsuccessChain(phenny, input):

    time.sleep(1)
    phenny.say("Formula for Average Number of Comparisons")
    phenny.say("Unsuccessful search using chaining:")
    phenny.say(un_chain)

unsuccessChain.commands = ['unsuccessful chaining', 'unsuccessful chainining formula']
