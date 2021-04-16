from itertools import combinations
from copy import deepcopy
from collections import deque


def spread(lab, combo):
    global result
    a, b, c = combo

    # 연구소 지도를 복사해와서 벽을 세워봄
    board = deepcopy(lab)
    board[a[0]][a[1]] = 1
    board[b[0]][b[1]] = 1
    board[c[0]][c[1]] = 1

    # 바이러스를 퍼트려본다
    for start in virus:
        q = deque()
        q.append(start)

        while q:
            x, y = q.popleft()
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if (-1 < nx < n and -1 < ny < m) and (board[nx][ny] == 0):
                    board[nx][ny] = 2
                    q.append((nx, ny))

    # 빈칸의 개수를 세는 건 모든 virus의 위치에서 다 spread한 이후에 세야함
    cnt = counter(board)
    if cnt > result:
        result = cnt


def counter(board):
    cnt = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                cnt += 1
    return cnt


n, m = map(int, input().split())
lab = [list(map(int, input().split())) for _ in range(n)]

# 지도에서 빈칸, 바이러스칸의 좌표만 뽑아냄
empty = []
virus = []
for i in range(n):
    for j in range(m):
        if lab[i][j] == 0:
            empty.append((i, j))
        if lab[i][j] == 2:
            virus.append((i, j))

# 3개의 벽을 세울 수 있는 조합을 미리 만들어둠
combos = list(combinations(empty, 3))

dx = [0, 1, -1, 0]
dy = [1, 0, 0, -1]

result = 0

# 가능한 벽의 위치들에 대해서 바이러스를 뿌려봄
for combo in combos:
    spread(lab, combo)
print(result)
