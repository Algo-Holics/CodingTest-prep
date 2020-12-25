'''
5 6
101010
111111
000001
111111
111111
'''

from collections import deque

N, M = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]

cnt = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위 벗어나면 continue
            if nx < 0 or ny < 0 or N <= nx or M <= ny:
                continue
            # 벽일 때도 무시
            if maze[nx][ny] == 0:
                continue
            # 처음 방문하면 기록
            if maze[nx][ny] == 1:
                maze[nx][ny] = maze[x][y] + 1   # 그 전에꺼 +1
                q.append((nx, ny))

    return maze[N-1][M-1]

print(bfs(0,0))

'''
10
'''