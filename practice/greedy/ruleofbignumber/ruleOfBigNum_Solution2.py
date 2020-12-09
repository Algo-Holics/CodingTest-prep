import time

start = time.time()
#######################
N, M, K = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
first = data[N-1]
second = data[N-2]

cnt = int(M/(K+1)) * K
cnt += M % (K+1)

result = 0
result += cnt * first
result += (M-cnt) * second

print(result)
#######################
end = time.time()
print(f'time: {end-start}')

'''
46
time: 1.5095419883728027
28
time: 2.253507375717163
'''