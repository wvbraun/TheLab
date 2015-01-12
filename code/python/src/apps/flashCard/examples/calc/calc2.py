import random
import calc_terms
import sys

truth = True

def one():

    calc_terms.trig_ident()
    counter = 0

    try:
        while truth:
            while counter <= len(calc_terms.trig_ident.terms):

                words = list(calc_terms.trig_ident.terms.keys())
                random.shuffle(words)

                for word in words:
                    phrase = calc_terms.trig_ident.terms[word]
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
                        if counter == len(calc_terms.trig_ident.terms) - 1:
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

                counter -= 1  

    except EOFError:
        print("\nEnd.")
 


def two():

    calc_terms.trig_integral()
    counter = 0

    try:
        while truth:
            while counter <= len(calc_terms.trig_integral.terms):

                words = list(calc_terms.trig_integral.terms.keys())
                random.shuffle(words)

                for word in words:
                    phrase = calc_terms.trig_integral.terms[word]
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
                        if counter == len(calc_terms.trig_integral.terms) - 1:
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

                counter -= 1  

    except EOFError:
        print("\nEnd.")
    

def three():
    
    calc_terms.integration()
    counter=0

    try:
        while truth:
            while counter <= len(calc_terms.integration.terms):

                words = list(calc_terms.integration.terms.keys())
                random.shuffle(words)

                for word in words:
                    phrase = calc_terms.integration.terms[word]
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
                        if counter == len(calc_terms.integration.terms) - 1:
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

                counter -= 1  

    except EOFError:
        print("\nEnd.")
    

def four():

    calc_terms.reduction()
    counter = 0

    try:
        while truth:
            while counter <= len(calc_terms.reduction.terms):

                words = list(calc_terms.reduction.terms.keys())
                random.shuffle(words)

                for word in words:
                    phrase = calc_terms.reduction.terms[word]
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
                        if counter == len(calc_terms.reduction.terms) - 1:
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

                counter -= 1  

    except EOFError:
        print("\nEnd.")
    


def main():

    print("Which sections do you want to study?")
    print(calc_terms.short_line)
    question()

def question():

    print("Trig Identities, Trig Integration, Integration, Reduction?\n")
    answer = input("> ")

    if answer == "Trig Identities":
        one()
    elif answer == "Trig Integration":
        two()
    elif answer == "Integration":
        three()
    elif answer == "Reduction":
        four()
    else:
        print(calc_terms.short_line)
        print("Not a valid entry.")
        print("Enter the name as it appears.")
        print("Try again!")
        print(calc_terms.short_line)
        question()

main()
