import collections as col


def checkmorse(i):
    if i is 'a':
        return '.-'
    elif i is 'b':
        return '-...'
    elif i is 'c':
        return '-.-.'
    elif i is 'd':
        return '-..'
    elif i is 'e':
        return '.'
    elif i is 'f':
        return '..-.'
    elif i is 'g':
        return '--.'
    elif i is 'h':
        return '....'
    elif i is 'i':
        return '..'
    elif i is 'j':
        return '.---'
    elif i is 'k':
        return '-.-'
    elif i is 'l':
        return '.-..'
    elif i is 'm':
        return '--'
    elif i is 'n':
        return '-.'
    elif i is 'o':
        return '---'
    elif i is 'p':
        return '.--.'
    elif i is 'q':
        return '--.-'
    elif i is 'r':
        return '.-.'
    elif i is 's':
        return '...'
    elif i is 't':
        return '-'
    elif i is 'u':
        return '..-'
    elif i is 'v':
        return '...-'
    elif i is 'w':
        return '.--'
    elif i is 'x':
        return '-..-'
    elif i is 'y':
        return '-.--'
    elif i is 'z':
        return '--..'
    return 0


def morsecode(word):
    string = ''
    temp = list(word)

    for i in temp:
        j = checkmorse(i)
        string += j
    return string
        # print(string)


def unique(n):
    temp = []
    for i in n:
        temp.append(morsecode(i))
    # print(temp)
    tempDict = dict(col.Counter(temp))
    # print(tempDict)
    return len(list(tempDict.keys()))


testcase1 = ["gin", "zen", "gig", "msg"]
print(unique(testcase1))

testcase2 =["a", "z", "g", "m"]
print(unique(testcase2))

testcase3 = ["bhi", "vsv", "sgh", "vbi"]
print(unique(testcase3))

testcase4 = ["a", "b", "c", "d"]
print(unique(testcase4))

testcase5 = ["hig", "sip", "pot"]
print(unique(testcase5))