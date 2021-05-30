# 무한 정의
INF = int(1e9)

# n = vertex, m = edge
vertex = int(input())
edge = int(input())

# 그래프 초기화 + 간선 입력받기
graph = [[INF] * (vertex) for _ in range(vertex)]
for x in range(vertex):
    graph[x][x] = 0
for _ in range(edge):
    start_idx, end_idx, cost = map(int, input().split())

    # 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다
    # == 더 작은 값만 keep한다
    if graph[start_idx - 1][end_idx - 1] > cost:
        graph[start_idx - 1][end_idx - 1] = cost

# 플로이드 워셜
for i in range(vertex):
    for row in range(vertex):
        for col in range(vertex):
            graph[row][col] = min(graph[row][col], graph[row][i] + graph[i][col])

# 출력 => INF면 0으로 출력하기
for i in range(vertex):
    for j in range(vertex):
        if graph[i][j] == INF:
            print(0, end=" ")
        else:
            print(graph[i][j], end=" ")
    print()