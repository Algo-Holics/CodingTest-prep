'''
25 5
'''
import time

start = time.time()
###############################
N, K = map(int, input().split())
cnt = 0
while N>1:
    if N%K==0:
        N //= K
        cnt += 1
    else:
        N -= 1
        cnt += 1
print(cnt)

###############################
end = time.time()
print(f'time: {end-start}')

'''
2
time: 1.9164400100708008
6
time: 1.8564558029174805
'''