x = [4, 5, 10, 6, 8, 3, 20]

def o2(n):
    overallmin = n[0]

    for i in n:
        ismin = True
        for j in n:
            if i > j:
                ismsin = False

        if ismin:
            overallmin = i 

    return overallmin

print(o2([5,4,3,2,1,0]))
print(o2([0,2,4]))
