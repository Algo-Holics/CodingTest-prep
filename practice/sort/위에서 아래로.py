'''
3
15
27
12
'''
import time
start = time.time()
#################################

N = int(input())
nums = sorted([int(input()) for _ in range(N)], reverse=True)
print(*nums)

#################################
end = time.time()
print(f'time: {end-start}')

'''
27 15 12
time: 0.9622151851654053
'''