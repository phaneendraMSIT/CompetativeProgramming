n = list(map(int, input().split()))
assert len(n) >= 3, Exception
n.sort()
print(max((n[0]*n[1]*n[len(n)-1]), (n[len(n)-1]*n[len(n)-2]*n[len(n)-3])))
