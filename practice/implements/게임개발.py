'''
4 4
1 1 0
1 1 1 1
1 0 0 1
1 1 0 1
1 1 1 1
'''

import time
start = time.time()
###############################
moves = [(-1, 0), (0, 1), (1, 0), (0, -1)]
# dx = [-1, 0, 1, 0]
# dy = [0, 1, 0, -1]

N, M = map(int, input().split())
visited = [[0]*M for _ in range(N)]
x, y, d = map(int, input().split())

myMap = [list(map(int, input().split())) for _ in range(N)]
cnt = 1
turn = 0
while True:
    visited[x][y] = 1

    # turn left
    if d-1 < 0:
        d = 3
    else:
        d -= 1

    currX = x+moves[d][0]
    currY = y+moves[d][1]
    if myMap[currX][currY] == 0 and visited[currX][currY] == 0:
        visited[currX][currY] = 1
        x = currX
        y = currY
        cnt += 1
        turn = 0

    else:
        turn += 1

    if turn == 4:
        currX = x-moves[d][0]
        currY = y-moves[d][1]
        if visited[currX][currY] == 0:
            x = currX
            y = currY
        else:
            break
        turn = 0

print(cnt)






###############################
end = time.time()
print(f'time: {end-start}')

'''
3
time: 0.9912295341491699
'''