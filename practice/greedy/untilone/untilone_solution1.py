'''
25 5
25 3
'''
import time

start = time.time()
###############################
N, K = map(int, input().split())
cnt = 0
while N >= K:
    while N % K != 0:
        N -= 1
        cnt += 1
    N //= K
    cnt += 1
while N > 1:
    N -= 1
    cnt += 1
print(cnt)

###############################
end = time.time()
print(f'time: {end-start}')

'''
2
time: 1.1787710189819336
6
time: 2.3065431118011475
'''