'''
5 3
1 2 5 4 3
5 5 6 6 5
'''
import time
start = time.time()
#################################
N, K = map(int, input().split())

A = sorted(list(map(int, input().split())))
B = list(map(int, input().split()))

for i in range(K):
    currentMax = B.index(max(B))
    A[i] = B[currentMax]
    B[currentMax] = 0

print(sum(A))
#################################
end = time.time()
print(f'time: {end-start}')

'''
26
time: 1.0314617156982422
'''