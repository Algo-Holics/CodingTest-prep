dx = [0, 1, -1]
dy = [1, 0, 0]

N = int(input())
board = [[0] * (N+1) for _ in range(N+1)]

for i in range(int(input())):
    x, y = map(int, input().split())
    board[x][y] += 1

orders = []
for i in range(int(input())):
    t, d = map(str,input().split())
    t = int(t)
    orders.append((t, d))

startX, startY = 1, 0
endX, endY = 1, 0
d, total = 0, 0
previousTime, previousD = 0, 0
for order in orders:
    time, direction = order
    if previousTime == 0:
        previousTime = time
    else:
        time -= previousTime
        previousTime += time
    for i in range(time):

        newX, newY = startX + dx[d], startY + dy[d]
        # startX += dx[d]
        # startY += dy[d]
        current = board[newX][newY]
        if 0 < newX < N+1 or 0 < newY < N+1 or current != 2:
            if current == 0:
                board[endX][endY] = 0
                endX += dx[previousD]
                endY += dy[previousD]

            # else:
            startX, startY = newX, newY
                # endX, endY = startX, startY
            board[newX][newY] = 2

            total += 1
        else:
            total += 1
            break
    previousD = d
    if direction == 'D':
        d = 1
    else:
        d = 2


print(total)