def basecon(decNum, base):

    digits = "0123456789ABCDEF"

    while decNum > 0 :

        remainder = decNum % base
        push(remainder)
        decNum =/ base

    new = ""
    while not isEmpty()
