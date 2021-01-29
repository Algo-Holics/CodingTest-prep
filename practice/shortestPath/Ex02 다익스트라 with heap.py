import heapq
INF = int(1e9)

# 노드, 간선 입력받기
N, M = map(int, input().split())
# 시작 노드 번호 입력받기
start = int(input())
# 각 노드에 연결된 노드들 입력받기
graph = [[] for _ in range(N+1)]
# visited 리스트
visited = [False] * (N+1)
# 최단거리 모두 무한으로 초기화
distance = [INF] * (N+1)

# 모든 간선 정보 입력받기
for _ in range(M):
    a, b, c = map(int, input().split())
    # a번 노드에서 b번 노드로 가는 거리가 c라는 의미
    graph[a].append((b, c))


def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로를 0을 설정한 후 큐에 삽입
    heapq.heappush(q, (0, start))
    distance[start] = 0

    # 큐가 비어있지 않다면
    while q:
        # 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)

# 모든 노드로 가기 위한 최단 거리를 출력
for i in range(1, N+1):
    # 도달할 수 없는 경우, 무한
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])