from itertools import combinations


N, M = map(int, input().split())
K = list(map(int, input().split()))

combos = list(combinations(K, 2))
cnt = 0
for c in combos:
    a, b = c
    if a != b:
        cnt += 1

print(cnt)

'''
5 3
1 3 2 3 2
=== 8

8 5
1 5 4 3 2 4 5 2
=== 25
'''