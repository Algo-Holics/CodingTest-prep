INF = int(1e9)

# 노드, 간선 입력받기
N = int(input())
M = int(input())
# 2차원 그래프 모두 무한대로 초기화
graph = [[INF] * (N+1) for _ in range(N+1)]

# 자기 자신에게 가는 비용은 0으로 초기화
for i in range(1, N+1):
    for j in range(1, N+1):
        if i == j:
            graph[i][j] = 0


# 각 간선에 대한 정보를 graph에 넣어줌
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a][b] = c


# floyd-warshall
for i in range(1, N+1):
    for j in range(1, N+1):
        for k in range(1, N+1):
            graph[j][k] = min(graph[j][k], graph[j][i]+graph[i][k])


# 프린트
for i in range(1, N+1):
    for j in range(1, N+1):
        if graph[i][j] == INF:
            print("INFINITY", end=" ")
        else:
            print(graph[i][j], end=" ")
    print()