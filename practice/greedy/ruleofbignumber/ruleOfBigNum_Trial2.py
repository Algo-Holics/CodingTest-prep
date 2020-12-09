import time

# 시작시간
start = time.time()
###########################

N, M, K = map(int, input().split())
nList = sorted(list(map(int, input().split())))

first = nList[-1]
second = nList[-2]

total = (first * (K-1) + second) * (M//K) + first * (M % K)

print(total)
###########################

# 끝난 시간
end = time.time()
print(f'time: {end-start}')

'''
46
time: 1.257035255432129
28
time: 1.947439432144165
'''