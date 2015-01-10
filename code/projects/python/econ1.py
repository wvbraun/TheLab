import random
import econ_terms
import sys

truth = True 

def one():

    econ_terms.budget()
    counter = 0

    try:
        while truth:
            while counter <= len(econ_terms.budget.terms):

                words = list(econ_terms.budget.terms.keys())
                random.shuffle(words)

                for word in words:

                    counter += 1  
                    phrase = econ_terms.budget.terms[word]
                    question, answer = word, phrase
                    if False:
                        question, answer = answer, question

                    tries = 2
                    while tries >= 0:
                        print(question)
                        response = input("> ")

                        if response == answer:
                            print("\nCorrect!")
                            break
                        else:
                            print("\nIncorrect!")
                            print("{0} more attempt(s)!\n" .format(tries))

                        if tries == 0:
                            print("Answer: {0}" .format(answer))
                        tries -= 1

                    print("------")
                    
                    if truth:
                        if counter == len(econ_terms.budget.terms) - 1:
                            print("You have answered everything.")
                            print("Would you like to see them again?")
                            end_answer = input("Yes or No: ")

                            if end_answer == "yes"  or end_answer == "Yes":
                                one()
                            elif end_answer == "no" or end_answer == "No":
                                print("\nWould you like to continue?")
                                move_answer = input("Yes or No: ")
                                if move_answer == "yes" or move_answer == "Yes":
                                    question()
                                else:
                                    print("Bye.\n")
                                    sys.exit()


    except EOFError:
        print("\nEnd.")
    


def two():

    econ_terms.preferences()
    counter = 0

    try:
        while truth:
            while counter <= len(econ_terms.preferences.terms):

                words = list(econ_terms.preferences.terms.keys())
                random.shuffle(words)

                for word in words:
                    counter += 1
                    phrase = econ_terms.preferences.terms[word]
                    question, answer = word, phrase
                    if False:
                        question, answer = answer, question

                    tries = 2
                    while tries >= 0:
                        print(question)
                        response = input("> ")

                        if response == answer:
                            print("\nCorrect!")
                            break
                        else:
                            print("\nIncorrect!")
                            print("{0} more attempt(s)!\n" .format(tries))

                        if tries == 0:
                            print("Answer: {0}" .format(answer))
                        tries -= 1

                    print("------")
                    
                    if truth:
                        if counter == len(econ_terms.preferences.terms) - 1:
                            print("You have answered everything.")
                            print("Would you like to see them again?")
                            end_answer = input("Yes or No: ")

                            if end_answer == "yes"  or end_answer == "Yes":
                                one()
                            elif end_answer == "no" or end_answer == "No":
                                print("\nWould you like to continue?")
                                move_answer = input("Yes or No: ")
                                if move_answer == "yes" or move_answer == "Yes":
                                    question()
                                else:
                                    print("Bye.\n")
                                    sys.exit()

    
    except EOFError:
        print("\nEnd.")
 
def three():
    
    econ_terms.utility()
    counter = 0

    try:
        while truth:
            while counter <= len(econ_terms.utility.terms):


                words = list(econ_terms.utility.terms.keys())
                random.shuffle(words)

                for word in words:
                    counter+=1
                    phrase = econ_terms.utility.terms[word]
                    question, answer = word, phrase
                    if False:
                        question, answer = answer, question

                    tries = 2
                    while tries >= 0:
                        print(question)
                        response = input("> ")

                        if response == answer:
                            print("\nCorrect!")
                            break
                        else:
                            print("\nIncorrect!")
                            print("{0} more attempt(s)!\n" .format(tries))

                        if tries == 0:
                            print("Answer: {0}" .format(answer))
                        tries -= 1

                    print("------")
                    
                    if truth:
                        if counter == len(econ_terms.utility.terms) - 1:
                            print("You have answered everything.")
                            print("Would you like to see them again?")
                            end_answer = input("Yes or No: ")

                            if end_answer == "yes"  or end_answer == "Yes":
                                one()
                            elif end_answer == "no" or end_answer == "No":
                                print("\nWould you like to continue?")
                                move_answer = input("Yes or No: ")
                                if move_answer == "yes" or move_answer == "Yes":
                                    question()
                                else:
                                    print("Bye.\n")
                                    sys.exit()


    except EOFError:
        print("\nEnd.")
 

def four():

    econ_terms.sub()
    counter = 0

    try:
        while truth:
            while counter <= len(econ_terms.sub.terms):

                words = list(econ_terms.sub.terms.keys())
                random.shuffle(words)

                for word in words:
                    counter+=1
                    phrase = econ_terms.sub.terms[word]
                    question, answer = word, phrase
                    if False:
                        question, answer = answer, question

                    tries = 2
                    while tries >= 0:
                        print(question)
                        response = input("> ")

                        if response == answer:
                            print("\nCorrect!")
                            break
                        else:
                            print("\nIncorrect!")
                            print("{0} more attempt(s)!\n" .format(tries))

                        if tries == 0:
                            print("Answer: {0}" .format(answer))
                        tries -= 1

                    print("------")
                    
                    if truth:
                        if counter == len(econ_terms.sub.terms) - 1:
                            print("You have answered everything.")
                            print("Would you like to see them again?")
                            end_answer = input("Yes or No: ")

                            if end_answer == "yes"  or end_answer == "Yes":
                                one()
                            elif end_answer == "no" or end_answer == "No":
                                print("\nWould you like to continue?")
                                move_answer = input("Yes or No: ")
                                if move_answer == "yes" or move_answer == "Yes":
                                    question()
                                else:
                                    print("Bye.\n")
                                    sys.exit()

    
    except EOFError:
        print("\nEnd.")
 
    
def five():

    econ_terms.taxes()
    counter = 0
    
    try:
        while truth:
            while counter <= len(econ_terms.taxes.terms):

                words = list(econ_terms.taxes.terms.keys())
                random.shuffle(words)

                for word in words:
                    counter += 1  
                    phrase = econ_terms.taxes.terms[word]
                    question, answer = word, phrase
                    if False:
                        question, answer = answer, question

                    tries = 2
                    while tries >= 0:
                        print(question)
                        response = input("> ")

                        if response == answer:
                            print("\nCorrect!")
                            break
                        else:
                            print("\nIncorrect!")
                            print("{0} more attempt(s)!\n" .format(tries))

                        if tries == 0:
                            print("Answer: {0}" .format(answer))
                        tries -= 1

                    print("------")
                    
                    if truth:
                        if counter == len(econ_terms.taxes.terms) - 1:
                            print("You have answered everything.")
                            print("Would you like to see them again?")
                            end_answer = input("Yes or No: ")

                            if end_answer == "yes"  or end_answer == "Yes":
                                one()
                            elif end_answer == "no" or end_answer == "No":
                                print("\nWould you like to continue?")
                                move_answer = input("Yes or No: ")
                                if move_answer == "yes" or move_answer == "Yes":
                                    question()
                                else:
                                    print("Bye.\n")
                                    sys.exit()

    except EOFError:
        print("\nEnd.")
 

def six():

    econ_terms.obama()
    counter = 0     

    try:
        while truth:
            while counter <= len(econ_terms.obama.terms):

                words = list(econ_terms.obama.terms.keys())
                random.shuffle(words)

                for word in words:
                    counter += 1  
                    phrase = econ_terms.obama.terms[word]
                    question, answer = word, phrase
                    if False:
                        question, answer = answer, question

                    tries = 2
                    while tries >= 0:
                        print(question)
                        response = input("> ")

                        if response == answer:
                            print("\nCorrect!")
                            break
                        else:
                            print("\nIncorrect!")
                            print("{0} more attempt(s)!\n" .format(tries))

                        if tries == 0:
                            print("Answer: {0}" .format(answer))
                        tries -= 1

                    print("------")
                    
                    if truth:
                        if counter == len(econ_terms.obama.terms) - 1:
                            print("You have answered everything.")
                            print("Would you like to see them again?")
                            end_answer = input("Yes or No: ")

                            if end_answer == "yes"  or end_answer == "Yes":
                                one()
                            elif end_answer == "no" or end_answer == "No":
                                print("\nWould you like to continue?")
                                move_answer = input("Yes or No: ")
                                if move_answer == "yes" or move_answer == "Yes":
                                    question()
                                else:
                                    print("Bye.\n")
                                    sys.exit()

    
    except EOFError:
        print("\nEnd.")
        

def main():
    
    print("Which section do you want to study?")
    print(econ_terms.short_line)
    question()

def question():

    print("budget, preferences, utility, income/substitution, taxes, obamacare\n")

    answer = input("> ")

    if answer == "budget":
        one()
    elif answer == "preferences":
        two()
    elif answer == "utility":
        three()
    elif answer == "income/substitution":
        four()
    elif answer == "taxes":
        five()
    elif answer == "obamacare":
        six()
    else:
        print(econ_terms.short_line)
        print("Not a valid entry.")
        print("Enter the name as it appears.")
        print("Try again.")
        print(econ_terms.short_line)
        question()

main()
