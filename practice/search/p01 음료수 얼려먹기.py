'''
4 5
00110
00011
11111
00000
'''
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(graph, x, y):
    # 방문처리
    # 이걸 통해 한 묶음씩 9로 만들어버릴 수 있음
    graph[x][y] = 9

    # 근처에 연결된거 있는지 확인
    # 각 방향에 돌면서 범위내에 있고 값이 0인거 찾기
    for i in range(4):
        if 0 <= x+dx[i] < N and 0 <= y+dy[i] < M:
            if graph[x+dx[i]][y+dy[i]] == 0:
                x = x+dx[i]
                y = y+dy[i]
                dfs(graph, x, y)

N, M = map(int, input().split())
mold = [list(map(int, input())) for _ in range(N)]
# print(*mold, sep='\n')

cnt = 0
for i in range(N):
    for j in range(M):
        # 0이 나오면 연결된 거 있는지 dfs돌리고 cnt 추가
        if mold[i][j] == 0:
            dfs(mold, i, j)
            cnt += 1

print(cnt)