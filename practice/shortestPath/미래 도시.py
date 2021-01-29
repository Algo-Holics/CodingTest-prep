'''
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

4 2
1 3
2 4
3 4
'''
INF = int(1e9)

# 회사(노드), 경로(간선) 입력받기
N, M = map(int, input().split())

graph = [[INF] * (N+1) for _ in range(N+1)]

# 자기 자신에게 가는 비용은 0으로 초기화
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            graph[i][j] = 0

for _ in range(M):
    a, b = map(int, input().split())
    # a ~ b까지 연결됨 = 1로 표기
    graph[a][b] = 1
    graph[b][a] = 1

# X, K == 1=>K=>X
X, K = map(int, input().split())

for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(1, N+1):
            graph[j][k] = min(graph[j][k], graph[j][i]+graph[i][k])

result = graph[1][K] + graph[K][X]

# 프린트
if result == 0:
    print(-1)
else:
    print(result)