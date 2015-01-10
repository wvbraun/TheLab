
def reverse():

    string = input("Speak: ")
    print("Reverse: {0}, Forward: {1}" .format(string[::-1], string))

    print("Again, yes or no?")
    again = input("Again: ")

    if again == 'yes' or again == 'Yes':
        reverse()
    
reverse()




