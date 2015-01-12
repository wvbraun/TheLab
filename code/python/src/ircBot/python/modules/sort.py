import time

bubble_sort1 = "The bubble sort makes multiple passes through a list.\
 It compares adjacent items and exchanges those that are out of order."
 
bubble_sort2 = "Each pass through the list places the next largest value \
in its proper place. Essentially, each item 'bubbles' up to the location where it belongs; O(n**2)."

def bubbleSort(phenny, input):

    time.sleep(1)
    phenny.say(bubble_sort1)
    phenny.say(bubble_sort2)

bubbleSort.commands = ['bubble sort', 'bubble', 'Bubble sort']


selection_sort = "A selection sort looks for the largest value as it makes a pass, and after \
 completing the pass, places it in the proper location; O(n**2)."

def selectinSort(phenny, input):

    time.sleep(1)
    phenny.say(selection_sort)

selectinSort.commands = ['selection sort', 'selection', 'Selection', 'Selection sort']
