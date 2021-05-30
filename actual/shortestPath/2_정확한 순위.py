INF = int(1e9)

# n = vertex, m = edge
vertex, edge = map(int, input().split())

# 그래프 초기화 + 간선 입력받기
graph = [[INF] * (vertex) for _ in range(vertex)]
for x in range(vertex):
    graph[x][x] = 0
for _ in range(edge):
    a, b = map(int, input().split())
    graph[a-1][b-1] = 1

# 플로이드 워셜
for i in range(vertex):
    for row in range(vertex):
        for col in range(vertex):
            graph[row][col] = min(graph[row][col], graph[row][i] + graph[i][col])


# 정확히 성적을 알 수 있는 학생 카운트하기
result = 0
for i in range(vertex):
    cnt = 0
    for j in range(vertex):
        if graph[i][j] != INF or graph[j][i] != INF:
            cnt += 1
    if cnt == vertex:
        result += 1

print(result)
'''
6 6
1 5
3 4
4 2
4 6
5 2
5 4
'''