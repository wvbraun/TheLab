# here we use 2 lists to create a HashTable class that implements 
# the Map abstract data type. One list, called slots, will hold the
# key item. A parrallel list, called data, will hold the data 
# values. When we look up a key, the corresponding position in the 
# data list will hold the associated data value. We will treat the 
# key list as a has table. Note: the initial size for the hash table
# will be 11; this is arbitrary, but we can to use a prime number
# so the collision resolution algo can be efficent. 

class HashTable:

    def __init__(self):

        self.size = 11
        self.slots = [None] * self.size # initially all None
        self.data = [None] * self.size 

    def put(self, key, data):

        hashValue = self.hashFunction(key, len(self.slots))

        if self.slots[hashValue] == None:
            self.slots[hashValue] = key
            self.data[hashValue] = data
 
        else: 
                # if key is already in the map
            if self.slots[hashValue] == key:
                self.data[hashValue] = data # swap old value for new

            else: 
                nextSlot = self.rehash(hashValue, len(self.slots))

                while self.slots[nextSlot] != None and \
                        self.slots[nextSlot] != key:
                            nextSlot = self.rehash(nextSlot, len(self.slots))

                if self.slots[nextSlot] == None:
                    self.slots[nextSlot] = key
                    self.data[nextSlot] = data
                else:
                    self.data[nextSlot] = data #replace

        # hashFunction implements simple remainder method. 
    def hashFunction(self, key, size):
        return(key % size)

        # the collision resolution algo is liner probing 
        # with a "plus 1" rehash function
    def rehash(self, oldHash, size):
        return((oldHash + 1) % size)

        # get begins by computing the initial hash value.
        # if the value is not in the initial slot, rehash is used
        # to locate the next possible position. 
    def get(self, key):

        startSlot = self.hashFunction(key, len(self.slots))

        data = None
        stop = False
        found = False
        position = startSlot

        while self.slots[position] != None and not found and not stop:

            if self.slots[position] == key:
                found = True
                data = self.data[position]

            else:
                position = self.rehash(position, len(self.slots))
                   
                # guarantees that the search will terminate
                # by check to make sure we have not returned
                # the initial slot. If that happens, we have
                # exhausted all possible slots, and the item
                # must not be present. 
                if position == startSlot:
                        stop = True
        
        return(data)

    #def del(self, key):
     #   self.slots[key] == None

    def len(self):
        return(len(self.slots))

   # def in(self, key):
        
    #    hashValue = self.hashFunction(key, len(self.slots))

     #   if self.slots[hashValue] == key:
       #     return True
      #  else:
        #    return False


    
    def __getitem__(self, key):
        return(self.get(key))

    def __setitem__(self, key, data):
        self.put(key, data)


