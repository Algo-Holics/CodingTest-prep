'''
3 3
3 1 2
4 1 4
2 2 2

2 4
7 3 1 8
3 3 3 4
'''
import time

start = time.time()
###############################
N, M = map(int, input().split())
cards = []
mini = 0
for i in range(N):
    row = list(map(int, input().split()))
    tmp = min(row)
    if tmp > mini:
        mini = tmp
print(mini)
###############################
end = time.time()
print(f'time: {end-start}')

'''
2
time: 1.4213221073150635
3
time: 1.037740707397461
'''