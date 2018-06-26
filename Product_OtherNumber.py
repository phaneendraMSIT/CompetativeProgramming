import numpy as ny

n = list(map(int, input().split()))
assert len(n) > 1, Exception
mlist = []
for i in range(0, len(n)):
    temp = n[:]
    # print(i,temp)
    temp.remove(temp[i])
    # print(temp)
    mlist.append(ny.prod(temp))
    # print(mlist)

print(mlist)