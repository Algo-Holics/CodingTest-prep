'''
5
R R R U D D
'''
import time

start = time.time()
#########################################
N = int(input())
x, y = 1, 1
plans = input().split()

dx = [0,0,-1,1]
dy = [1,1,0,0]
moves = ['L', 'R', 'U', 'D']

for plan in plans:
    for i in range(4):
        if plan == moves[i]:
            nx = x+dx[i]
            ny = y+dy[i]
    if nx<1 or ny<1 or nx>N or ny>N:
        continue
    x, y = nx, ny

print(x, y)
#########################################
end = time.time()
print(f'time: {end-start}')

'''
3 4
time: 1.1867754459381104
'''