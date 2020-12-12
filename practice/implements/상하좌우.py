'''
5
R R R U D D
'''
import time

start = time.time()
#########################################
directions = {'L': (0,-1), 'R':(0,1), 'U':(-1,0), 'D':(1,0)}

N = int(input())
dList = input().split()

x = 1
y = 1
for d in dList:
    if 0 < x+directions[d][0] <= N+1 and 0 < y+directions[d][1] <= N+1:
        x += directions[d][0]
        y += directions[d][1]
    else:
        continue

print(x, y)
#########################################
end = time.time()
print(f'time: {end-start}')

'''
3 4
time: 1.1798429489135742
'''