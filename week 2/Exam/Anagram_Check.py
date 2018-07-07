import collections as col


def check(m,n):
    dict_m = dict(col.Counter(m.lower().replace(' ', '')))
    dict_n = dict(col.Counter(n.lower().replace(' ', '')))

    print(dict_m)
    print(dict_n)

    set_dif = dict_m.keys() - dict_n.keys()
    set_dif1 = dict_n.keys()- dict_m.keys()
    if len(set_dif) is 0 and len(set_dif1) is 0:
        print(True)
    else:
        print(False)


check('anagram', 'nagaram')
check('Keep', 'Peek')
check('Mother In Law', 'Hitler Woman')
check('School Master','The Classroom')
check('ASTRONOMERS','NO MORE STARS')
check('Toss','Shot')
check('joy','enjoy')
check('Debit Card','Bad Credit')
check('SiLeNt CAT','LisTen AcT')
check('Dormitory','Dirty Room')

