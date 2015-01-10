import random


vowels = ['a','e','i','o','u']

def pigLatin(n):

    if n[:1] in vowels:
        return(n + 'way')

    # y is sometimes a vowel...
    elif n[:1] == 'y':
        if random.randrange(9) % 2 == 0:
            return(n + 'way')
        else:
            return(n[1:] + n[:1] + 'ay')

    else:
        return(n[1:] + n[:1] + 'ay')

print(pigLatin('happy'))
print(pigLatin('egg'))
print(pigLatin('eight'))
print(pigLatin('duck'))
print(pigLatin('yellow'))
print(pigLatin('yummy'))

